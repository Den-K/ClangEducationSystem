package dal.dao;

import dal.entities.BaseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

public abstract class BaseDao<T extends BaseEntity> {

    JdbcTemplate jdbcTemplate;

    SimpleJdbcInsert insert;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public abstract void add(T entity);
}
