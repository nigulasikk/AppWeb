package fire.crud.service;

import java.util.Date;

import fire.crud.entity.User;



/**
 * user
 * @author jf
 *
 */
public interface IUserService extends IBaseService<User>{
	/**
	 * 判断用户名密码是否正确
	 * @param loginName
	 * @param pswd 未用md5加密,在方法中会加密
	 * @return
	 */
	public User verify(String loginName, String pswd);
	
	/**
	 * 增加登录次数1次
	 * <b>不改变修改时间</b>
	 * @param id
	 * @return true 成功 ;false 失败
	 */
	public boolean addLoginCount(int id);

	/**
	 * 修改最后登录的时间和ip
	 * @param id
	 * @param ip
	 * @param loginTime
	 * @return
	 */
	public boolean doLastLoginInfo(int id, String ip, Date loginTime);

}
