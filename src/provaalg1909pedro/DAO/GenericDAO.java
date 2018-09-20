package provaalg1909pedro.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Pedro Henrique Martins Stulp
 */
public interface GenericDAO<T> {
    public void save(T entity) throws SQLException;
    public void update(T entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public T getById(int id) throws SQLException;
    public List<T> getByName(String name) throws SQLException;
    public List<T> getAll() throws SQLException;
    public int getLastId() throws SQLException;
}
