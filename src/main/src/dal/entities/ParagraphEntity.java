package dal.entities;

import javax.persistence.*;

/**
 * Created by alex on 05.06.16.
 */
@Entity
@Table(name = "paragraph")
public class ParagraphEntity implements BaseEntity {
    private int paragraphId;
    private int partId;
    private String text;
    private int textTypeId;
    private int orderNo;

    @Id
    @Column(name = "paragraph_id", nullable = false)
    public int getParagraphId() {
        return paragraphId;
    }

    public void setParagraphId(int paragraphId) {
        this.paragraphId = paragraphId;
    }

    @Basic
    @Column(name = "part_id", nullable = true)
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Basic
    @Column(name = "text", nullable = true, length = 20000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "text_type_id", nullable = true)
    public int getTextTypeId() {
        return textTypeId;
    }

    public void setTextTypeId(int textTypeId) {
        this.textTypeId = textTypeId;
    }

    @Basic
    @Column(name = "order_no", nullable = true)
    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParagraphEntity that = (ParagraphEntity) o;

        if (paragraphId != that.paragraphId) return false;
        if (partId != that.partId) return false;
        if (textTypeId != that.textTypeId) return false;
        if (orderNo != that.orderNo) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paragraphId;
        result = 31 * result + partId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + textTypeId;
        result = 31 * result + orderNo;
        return result;
    }
}
