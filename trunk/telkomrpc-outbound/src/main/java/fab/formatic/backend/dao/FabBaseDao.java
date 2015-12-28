package fab.formatic.backend.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gilang
 *
 * @param <T> domain or entity class
 * @param <ID> primary key of the entity
 */
public abstract class FabBaseDao<T, ID extends Serializable> implements FabDao<T, ID> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public FabBaseDao() {
		ParameterizedType type=(ParameterizedType) getClass().getGenericSuperclass();
		entityClass=(Class<T>) type.getActualTypeArguments()[0];
	}

	@Transactional
	public void persist(T entity) throws DataAccessException{
		entityManager.persist(entity);
	}

	@Transactional
	public void remove(T entity) throws DataAccessException{
		if(entityManager.contains(entity)){
			entityManager.remove(entity);
		}else{
			T detach=entityManager.merge(entity);
			entityManager.remove(detach);
		}
	}

	@Transactional
	public T merge(T entity) throws DataAccessException{
		T merged=entityManager.merge(entity);
		entityManager.flush();
		return merged;
	}

	public T find(ID id) {
		return entityManager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query q=entityManager.createQuery("select e from "+entityClass.getSimpleName()+" e");
		return q.getResultList();
	}
	
	

}
