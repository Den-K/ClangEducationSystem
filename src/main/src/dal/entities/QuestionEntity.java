package dal.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class QuestionEntity implements BaseEntity {
    private int questionId;
    private Integer rightAnswerId;
    private Integer paragraphId;
    private String text;
    private Set<AnswerEntity> answers = new HashSet<>();

    @Id
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "right_answer_id")
    public Integer getRightAnswerId() {
        return rightAnswerId;
    }
    public void setRightAnswerId(Integer rightAnswerId) {
        this.rightAnswerId = rightAnswerId;
    }

    @Basic
    @Column(name = "paragraph_id")
    public Integer getParagraphId() {
        return paragraphId;
    }
    public void setParagraphId(Integer paragraphId) {
        this.paragraphId = paragraphId;
    }

    @Basic
    @Column(name = "text", length = 200)
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionId")
    public Set<AnswerEntity> getAnswers() {
        return answers;
    }
    public void setAnswers(Set<AnswerEntity> answers) {
        this.answers = answers;
    }
}
