package com.api.persik.Models.Entities;

import com.api.persik.Models.Entities.User.User;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "poll", indexes = {
        @Index(name = "user_id", columnList = "user_id")
})
@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "content", length = 999)
    private String content;

    @Column(name = "public_date")
    private Instant publicDate;

    @Column(name = "modify_time")
    private Instant modifyTime;

    @Column(name = "expire_day")
    private Instant expireDay;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getExpireDay() {
        return expireDay;
    }

    public void setExpireDay(Instant expireDay) {
        this.expireDay = expireDay;
    }

    public Instant getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Instant getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Instant publicDate) {
        this.publicDate = publicDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}