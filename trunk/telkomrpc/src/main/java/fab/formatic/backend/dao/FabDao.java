package fab.formatic.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * @author gilang
 *
 * @param <T>
 * @param <ID>
 */
public interface FabDao<T,ID extends Serializable> {
	
	void persist(T entity) throws DataAccessException;
	void remove(T entity) throws DataAccessException;
	T merge(T entity) throws DataAccessException;
	T find(ID id);
	List<T> findAll();

}
