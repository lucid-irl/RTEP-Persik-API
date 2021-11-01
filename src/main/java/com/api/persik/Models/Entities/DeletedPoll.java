package com.api.persik.Models.Entities;

import com.api.persik.Models.Entities.User.User;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "deleted_poll", indexes = {
        @Index(name = "poll_id", columnList = "poll_id"),
        @Index(name = "who_delete", columnList = "who_delete")
})
@Entity
public class DeletedPoll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "who_delete")
    private User whoDelete;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @Column(name = "delete_date")
    private Instant deleteDate;

    public Instant getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Instant deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public User getWhoDelete() {
        return whoDelete;
    }

    public void setWhoDelete(User whoDelete) {
        this.whoDelete = whoDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}