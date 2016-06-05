package main.dal;

import javax.persistence.*;

/**
 * Created by alex on 05.06.16.
 */
@Entity
@Table(name = "text_type")
public class TextTypeEntity {
    private int textTypeId;
    private String textTypeName;

    @Id
    @Column(name = "text_type_id", nullable = false)
    public int getTextTypeId() {
        return textTypeId;
    }

    public void setTextTypeId(int textTypeId) {
        this.textTypeId = textTypeId;
    }

    @Basic
    @Column(name = "text_type_name", nullable = true, length = 50)
    public String getTextTypeName() {
        return textTypeName;
    }

    public void setTextTypeName(String textTypeName) {
        this.textTypeName = textTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextTypeEntity that = (TextTypeEntity) o;

        if (textTypeId != that.textTypeId) return false;
        if (textTypeName != null ? !textTypeName.equals(that.textTypeName) : that.textTypeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = textTypeId;
        result = 31 * result + (textTypeName != null ? textTypeName.hashCode() : 0);
        return result;
    }
}
