package cs544.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private String font;
    @Range(min=100,max=400)
    private Integer wordCount;
    @Temporal(TemporalType.DATE)
    private Date dateCommented;
    @Temporal(TemporalType.TIME)
    private Date timeCommented;

    private Long postId;


    public Comment() {

    }
  public Comment(String text,String font, Integer wordCount,Long postId,Date dateCommented,Date timeCommented) {
       this.text=text;
       this.font = font;
       this.wordCount = wordCount;
       this.postId=postId;
       this.dateCommented=dateCommented;
       this.timeCommented=timeCommented;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateCommented() {
        return dateCommented;
    }

    public void setDateCommented(Date dateCommented) {
        this.dateCommented = dateCommented;
    }

    public Date getTimeCommented() {
        return timeCommented;
    }

    public void setTimeCommented(Date timeCommented) {
        this.timeCommented = timeCommented;
    }
}