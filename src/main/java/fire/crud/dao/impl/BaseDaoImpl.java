package fire.crud.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fire.crud.dao.IBaseDao;


@Repository("baseDao")
public class BaseDaoImpl<M extends java.io.Serializable> implements IBaseDao<M> {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Serializable save(M object) {
		return getSession().save(object);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public M findByID(Class clazz, Serializable id){
		return (M)getSession().get(clazz, id);
	}
	
	public void update(M o) {
		getSession().update(o);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public void deleteByID(Class clazz, Serializable id) {
		
//		try {
//			Object o = Class.forName(clazz.getName()).newInstance();
//			Ognl.setValue("id", o, id);
//			getSession().delete(o);
//		} catch (InstantiationException e) {
//			log.error("delete fail", e);
//		} catch (IllegalAccessException e) {
//			log.error("delete fail", e);
//		} catch (ClassNotFoundException e) {
//			log.error("delete fail", e);
//		}catch (OgnlException e) {
//			log.error("ognl fail", e);
//		}
		
//		只能删除单个文件
//		String hql = "delete from "+clazz.getName()+" t where t.id=?";
//		Object values[] = {id};
//		this.update(hql, values);
		
		//只有这种可以删除关联表，不过这样是不是太低效了
		Object o = findByID(clazz, id);
		getSession().delete(o);
	}
	
	@SuppressWarnings({ "rawtypes" })
	public M findByIdAndLock(Class clazz, Serializable id) {
		M o = (M)getSession().get(clazz, id);
		//TODO 查看锁定的几种选项
		getSession().buildLockRequest(LockOptions.UPGRADE).lock(o);
		return o;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<M> findAll(Class<M> clazz) {
		Query query = getSession().createQuery("from "+ clazz.getName()); 
		return query.list();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int countByMultiKeys(Class<M> clazz, Map<String, Object> baseKeys) {
		
		StringBuffer sb = new StringBuffer("select count(*) from "+ clazz.getName() +" t where 1=1 ");
		List params = new ArrayList();
		if(baseKeys!=null&&baseKeys.size()!=0){
			//生成Trademark表的 where语句
			Iterator it = baseKeys.entrySet().iterator(); 
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = (String) entry.getKey();
				Object value =  entry.getValue();
	
				sb.append("and t.").append(key).append("? ");
				params.add(value);
			}
		}
		
		String hql = sb.toString();
		log.debug(hql);
		
		Query query = getSession().createQuery(hql); 
		
		int i=0;
		for(Object param:params.toArray()){
			query.setParameter(i++, param);
		}
		
		Long size = (Long)query.uniqueResult();
		return size.intValue();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<M> findByMultKeys(Class<M> clazz, Map<String, Object> baseKeys,
			Map<String, String> baseOrderKeys, final int start, final int maxResults)
			throws RuntimeException {
		StringBuffer sb = new StringBuffer("from "+ clazz.getName() +" t where 1=1 ");
		final List params = new ArrayList();
		if(baseKeys!=null&&baseKeys.size()!=0){
			//生成Trademark表的 where语句
			Iterator it = baseKeys.entrySet().iterator(); 
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = (String) entry.getKey();
				Object value =  entry.getValue();
	
				sb.append("and t.").append(key).append("? ");
				params.add(value);
			}
		}

		if(baseOrderKeys!=null&&baseOrderKeys.size()!=0){
			//生成Trademark表的 order by 语句
			sb.append("order by ");
			Iterator it = baseOrderKeys.entrySet().iterator(); 
			if (it.hasNext()) {
				Map.Entry entry  = (Map.Entry) it.next();
				String orderfield = (String) entry.getKey();
				String ordertype =  (String) entry.getValue();
				sb.append("t.").append(orderfield).append(' ').append(ordertype).append(' ');
			}
			while(it.hasNext()) {
				Map.Entry entry  = (Map.Entry) it.next();
				String orderfield = (String) entry.getKey();
				String ordertype =  (String) entry.getValue();
				sb.append(", t.").append(orderfield).append(' ').append(ordertype).append(' ');
			}
		}
		
		String hql = sb.toString();
		log.debug(hql);
		
		Query query = getSession().createQuery(hql);

		int i = 0;
		for (Object param : params.toArray())
			query.setParameter(i++, param);

		query.setFirstResult(start);
		query.setMaxResults(maxResults);
		return query.list();
		
	}
	
	public int update(String hql, Object[] values){
		Query query = getSession().createQuery(hql);
		int i = 0;
		for (Object param : values){
			query.setParameter(i++, param);
		}
		return query.executeUpdate();
	}
	
	
}
