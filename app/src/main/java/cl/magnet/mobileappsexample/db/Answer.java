package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = Question.class,
                                   parentColumns = "questionId",
                                   childColumns = "questionId",
                                   onDelete = CASCADE)})
public class Answer {

    @PrimaryKey(autoGenerate = true)
    private long answerId;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "questionId")
    private long questionId;

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public Answer(String content, long questionId) {
        this.content = content;
        this.questionId = questionId;
    }
}
