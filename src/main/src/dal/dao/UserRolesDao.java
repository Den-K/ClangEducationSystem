package dal.dao;

import dal.entities.UserRolesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class UserRolesDao extends BaseDao<UserRolesEntity> {

    private static final Logger log = LoggerFactory.getLogger(UserRolesDao.class);

    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
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
