package fab.formatic.backend.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public abstract class FabBaseDao<T,ID extends Serializable> implements BaseDao<T, ID> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FabBaseDao() {
		ParameterizedType type=(ParameterizedType)getClass().getGenericSuperclass();
		entityClass=(Class) type.getActualTypeArguments()[0];
	}

	@Transactional
	public void persist(T entity) throws DataAccessException {
		entityManager.persist(entity);
	}

	@Transactional
	public void remove(T entity) throws DataAccessException {
		if(entityManager.contains(entity)){
			entityManager.remove(entity);
		}else{
			T toremove=entityManager.merge(entity);
			entityManager.remove(toremove);
		}
	}

	public T find(ID id) {
		return entityManager.find(entityClass, id);
	}

	@Transactional
	public T merge(T entity) throws DataAccessException {
		T merged=entityManager.merge(entity);
		entityManager.flush();
		return merged;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query q=entityManager.createQuery("select c from "+entityClass.getSimpleName()+" c");
		return q.getResultList();
	}

	

}
