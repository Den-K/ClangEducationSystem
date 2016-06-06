package dal.dao;

import dal.entities.UserRolesEntity;
import dal.entities.UsersEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class UserDao extends BaseDao<UsersEntity> {

    private static final Logger log = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private UserRolesDao userRolesDao;

    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
        insert = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void add(UsersEntity user) throws DuplicateKeyException {
        if (!userExists(user.getLogin())) {
            Map<String, Object> parameters = new HashMap<>(5);
            parameters.put("login", user.getLogin());
            parameters.put("name", user.getName());
            parameters.put("surname", user.getSurname());
            parameters.put("password", user.getPassword());
            parameters.put("enabled", true);
            Number key = insert.executeAndReturnKey(parameters);
            UserRolesEntity userRolesEntity = new UserRolesEntity();
            userRolesEntity.setRoleId(1);//ROLE_USER
            userRolesEntity.setUserId(key.intValue());
            userRolesDao.add(userRolesEntity);
        } else throw new DuplicateKeyException("Duplicate user entry: " + user.getLogin());
    }

    private boolean userExists(String login) {
        int rows = jdbcTemplate.queryForObject("select count(*) from users where login = ?", Integer.class, login);
        return rows > 0;
    }
}
