package com.api.persik.Models.Entities;

import javax.persistence.*;

@Table(name = "poll_option", indexes = {
        @Index(name = "parent_poll_id", columnList = "parent_poll_id")
})
@Entity
public class PollOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content", length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "parent_poll_id")
    private Poll parentPoll;

    public Poll getParentPoll() {
        return parentPoll;
    }

    public void setParentPoll(Poll parentPoll) {
        this.parentPoll = parentPoll;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}