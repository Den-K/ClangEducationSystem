package dal.dao;

import dal.entities.UserRolesEntity;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class UserRolesDao extends BaseDao<UserRolesEntity> {

    @Override
    public void setDataSource(DataSource dataSource) {
        insert = new SimpleJdbcInsert(dataSource)
                .withTableName("user_roles")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void add(UserRolesEntity userRoles) {
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("user_id", userRoles.getUserId());
        parameters.put("role_id", userRoles.getRoleId());
        insert.execute(parameters);
    }
}
