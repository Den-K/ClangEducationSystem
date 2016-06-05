package dal.dao;

import dal.entities.UsersEntity;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private SimpleJdbcInsert insert;

    public void setDataSource(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    public void add(UsersEntity user, String password) {
            Map<String, Object> parameters = new HashMap<>(3);
            parameters.put("login", user.getLogin());
            parameters.put("name", user.getName());
            parameters.put("surname", user.getSurname());
            parameters.put("password", password);
            parameters.put("enabled", true);
            insert.execute(parameters);
    }
}
