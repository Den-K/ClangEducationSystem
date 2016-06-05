package main.src.dal;

import javax.persistence.*;

/**
 * Created by alex on 05.06.16.
 */
@Entity
@Table(name = "part")
public class PartEntity {
    private int partId;
    private Integer orderNo;
    private Integer parentId;
    private String name;

    @Id
    @Column(name = "part_id", nullable = false)
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Basic
    @Column(name = "order_no", nullable = true)
    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "parent_id", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartEntity that = (PartEntity) o;

        if (partId != that.partId) return false;
        if (orderNo != that.orderNo) return false;
        if (parentId != that.parentId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partId;
        result = 31 * result + orderNo;
        result = 31 * result + parentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
