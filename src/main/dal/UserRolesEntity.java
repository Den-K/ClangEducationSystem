package main.dal;

import javax.persistence.*;

/**
 * Created by alex on 05.06.16.
 */
@Entity
@Table(name = "user_roles")
public class UserRolesEntity {
    private int userId;
    private int roleId;
    private int id;

    @Basic
    @Column(name = "user_id", nullable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_id", nullable = true)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesEntity that = (UserRolesEntity) o;

        if (userId != that.userId) return false;
        if (roleId != that.roleId) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + roleId;
        result = 31 * result + id;
        return result;
    }
}
