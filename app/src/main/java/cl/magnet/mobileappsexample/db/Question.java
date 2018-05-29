package cl.magnet.mobileappsexample.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {@ForeignKey(entity = Form.class,
                                   parentColumns = "formId",
                                   childColumns = "formId",
                                   onDelete = CASCADE)})
public class Question {

    @PrimaryKey(autoGenerate = true)
    private long questionId;

    @ColumnInfo(name = "statement")
    private String statement;

    @ColumnInfo(name = "kind")
    private String kind;

    @ColumnInfo(name = "formId")
    private long formId;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public Question(String statement, long formId) {
        this.statement = statement;
        this.kind = "TextQuestion";
        this.formId = formId;
    }
}
