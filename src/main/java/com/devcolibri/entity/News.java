package com.devcolibri.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "NEWS")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "news_ID")
    private long id;

    @Size(min = 2, max = 200)
    @NotNull
    @Column(name = "message")
    private String message;

   /*@NotNull
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;*/
   @Column(name = "topic id")
    private long topic_id;

    public News() {
    }

    public News(String message, long topic_id){
        this.message = message;
        this.topic_id=topic_id;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   /* public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
