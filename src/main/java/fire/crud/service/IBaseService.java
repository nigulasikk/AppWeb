package fire.crud.service;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 数据访问基类
 * @author jf
 *
 * @param <M> 实体类的类型，比如user类
 * @param <PK> 主键的类型，一般是Integer
 */
public interface IBaseService<M extends java.io.Serializable>{

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
	 *  
	 * @param clazz
	 * @param id
	 * @return 如果没找到,返回null
	 * @throws RuntimeException
	 */
	public M findByID(Class<M> clazz, Serializable id);
	
	/**
	 * 
	 * @param clazz
	 * @param id
	 * @throws RuntimeException 如果数据库中没有该id,将抛出异常
	 */
	@SuppressWarnings("rawtypes")
	public void deleteByID(Class clazz, Serializable id);
	
	
	/**
	 * 按条件统计某种实体类的记录的数量
	 * @param clazz
	 * @param keys
	 * @return
	 */
	public int countByMultiKeys(Class<M> clazz, Map<String, Object> keys);
	
	/**
	 * 按多个条件查询,并且按条件进行排序
	 * @param clazz
	 * @param keys
	 * @param orderKeys
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<M> findByMultiKeys(Class<M> clazz, Map<String, Object> keys,
			Map<String, String> orderKeys, int start, int pageSize);
	
	
}
