package fab.formatic.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BaseDao<T,ID extends Serializable> {
	
	void persist(T entity) throws DataAccessException;
	void remove(T entity) throws DataAccessException;
	T find(ID id);
	T merge(T entity) throws DataAccessException;
	List<T> findAll();
}
