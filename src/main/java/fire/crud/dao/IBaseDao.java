package fire.crud.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

/**
 *数据访问基类
 * @author jf
 *
 * @param <M> 实体类的类型，比如user类
 * @param <PK> 主键的类型，一般是Integer
 */
public interface IBaseDao <M extends java.io.Serializable>{

	/**
	 * 降序
	 */
	final public String DESC = "desc";
	
	/**
	 * 升序
	 */
	final public String ASC = "asc";
	
	/**
	 * 保存
	 * @param o
	 * @return
	 */
	public Serializable save(M object);

	/**
	 * 
	 * @param o
	 * @throws RuntimeException 如果数据库中没有该id,将抛出异常
	 */
	public void update(M object);
	
	/**
	 * 根据hql修改
	 * @param hql
	 * @param values
	 * @return
	 */
	public int update(String hql, Object[] values);
	
	/**
	 *  
	 * @param clazz
	 * @param id
	 * @return 如果没找到,返回null
	 */
	@SuppressWarnings("rawtypes")
	public M findByID(Class clazz, Serializable id);
	
	/**
	 * 
	 * @param clazz
	 * @param id
	 * @throws RuntimeException 如果数据库中没有该id,将抛出异常
	 */
	@SuppressWarnings("rawtypes")
	public void deleteByID(Class clazz, Serializable id);
	
	/**
	 * 查询对象,并且锁定该条记录;注意:只是锁定该记录,如果实体中有many-to-one, set(one-to-many) 之类的, 关联的类没有锁定
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public M findByIdAndLock(Class clazz, Serializable id);
	
	/**
	 * 按条件统计某种实体类的记录的数量
	 * @param entityName
	 * @param baseKeys
	 * @return
	 * @throws RuntimeException
	 */
	public int countByMultiKeys(Class<M> clazz, Map<String, Object> baseKeys);
	
	/**
	 * 按多个条件查询,并且按条件进行排序
	 * @param baseKeys
	 * @param baseOrderKeys
	 * @param start
	 * @param maxResults
	 * @return
	 * @throws RuntimeException
	 */
	public List<M> findByMultKeys(Class<M> clazz, Map<String, Object> baseKeys,
			Map<String, String> baseOrderKeys, int start, int maxResults);
	
	/**
	 * 返回所有的对象
	 * @param clazz
	 * @return
	 */
	public List<M> findAll(Class<M> clazz);
			
	/**
	 * 得到hibernatetemplate 可以作更多的数据访问
	 * @return
	 * @throws RuntimeException
	 */
	public Session getSession();
	
}
