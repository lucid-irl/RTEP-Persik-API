package com.api.persik.Models.Entities;

import com.api.persik.Models.Entities.User.User;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "voted_poll_option", indexes = {
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "option_id", columnList = "option_id")
})
@Entity
public class VotedPollOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "voting_date")
    private Instant votingDate;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private PollOption option;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PollOption getOption() {
        return option;
    }

    public void setOption(PollOption option) {
        this.option = option;
    }

    public Instant getVotingDate() {
        return votingDate;
    }

    public void setVotingDate(Instant votingDate) {
        this.votingDate = votingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}