package fire.crud.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fire.crud.Cache;
import fire.crud.entity.User;
import fire.crud.service.IUserService;
import fire.crud.util.PasswordHelper;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	private void init() {

		logger.info("开始缓存用户信息...");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User u where u.enable!='停用'");
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		Map<Integer, User> userMap = new HashMap<Integer, User>();
		// 完成后更改全局变量
		Cache.users = users;

		for (User u : users) {
			userMap.put(u.getId(), u);
		}
		Cache.userMap = userMap;

		logger.info("完成缓存用户信息!条数: {}", userMap.size());
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public User verify(String loginName, String pswd) {
		Map<String, Object> baseKeys = new HashMap<String, Object>();
		baseKeys.put("loginName = ", loginName);
		// try {
		// baseKeys.put("pswd = ", MD5Helper.EncoderByMd5(pswd));
		// } catch (NoSuchAlgorithmException e) {
		// logger.warn("用户名或密码错误!",e);
		// return null;
		// } catch (UnsupportedEncodingException e) {
		// logger.warn("用户名或密码错误!",e);
		// return null;
		// }

		List<User> list = getBaseDao().findByMultKeys(User.class, baseKeys, new LinkedHashMap<String, String>(), 0, 1);

		if (list.size() == 0) {
			return null;
		}

		User user = list.get(0);

		try {
			if (PasswordHelper.verifySHA(user.getPswd(), pswd)) {
				return user;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addLoginCount(int id) {
		String hql = "update User u set u.loginCount=u.loginCount+1 where u.id = ?";
		Object[] values = { id };
		int rst = getBaseDao().update(hql, values);
		return rst == 1 ? true : false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean doLastLoginInfo(int id, String ip, Date loginTime) {
		String hql = "update User u set u.lastLoginTime=?,u.lastLoginIp=? where u.id = ?";
		Object[] values = { loginTime, ip, id };
		int rst = getBaseDao().update(hql, values);
		return rst == 1 ? true : false;
	}

}
