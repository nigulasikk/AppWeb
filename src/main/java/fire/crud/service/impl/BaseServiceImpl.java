package fire.crud.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fire.crud.dao.IBaseDao;
import fire.crud.service.IBaseService;



@Service("baseService")
public class BaseServiceImpl<M extends java.io.Serializable> implements IBaseService<M> {
 
	@Autowired
	private IBaseDao<M> baseDao;
	
	public IBaseDao<M> getBaseDao() {
		return baseDao;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Serializable save(M object) {
		return baseDao.save(object);
	}
	
	@SuppressWarnings({ "rawtypes"})
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public M findByID(Class clazz, Serializable id)
			throws RuntimeException {
		return baseDao.findByID(clazz, id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(M object) {
		baseDao.update(object);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteByID(Class clazz, Serializable id) {
		baseDao.deleteByID(clazz, id);
	}
	
//	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public int countByMultiKeys(Class<M> clazz, Map<String, Object> baseKeys) {
		return baseDao.countByMultiKeys(clazz, baseKeys);
	}
	
//	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<M> findByMultiKeys(Class<M> clazz, Map<String, Object> baseKeys,
			Map<String, String> baseOrderKeys, final int start, final int maxResults)
			throws RuntimeException {
		return baseDao.findByMultKeys(clazz, baseKeys, baseOrderKeys, start, maxResults);
	}
	
	
}
