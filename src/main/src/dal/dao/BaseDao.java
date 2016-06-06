package dal.dao;

import dal.entities.BaseEntity;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

public abstract class BaseDao<T extends BaseEntity> {

    SimpleJdbcInsert insert;

    public abstract void setDataSource(DataSource dataSource);

    public abstract void add(T entity);
}
