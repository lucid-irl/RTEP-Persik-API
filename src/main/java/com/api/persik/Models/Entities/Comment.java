package com.api.persik.Models.Entities;

import com.api.persik.Models.Entities.User.User;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "comment", indexes = {
        @Index(name = "article_id", columnList = "article_id"),
        @Index(name = "parent_id", columnList = "parent_id"),
        @Index(name = "comment_status_id", columnList = "comment_status_id"),
        @Index(name = "userId", columnList = "userId")
})
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @Column(name = "content", length = 8000)
    private String content;

    @Column(name = "upvote")
    private Integer upvote;

    @Column(name = "downvote")
    private Integer downvote;

    @Column(name = "public_date")
    private Instant publicDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "comment_status_id")
    private CommentStatus commentStatus;

    public CommentStatus getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatus commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Instant getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Instant publicDate) {
        this.publicDate = publicDate;
    }

    public Integer getDownvote() {
        return downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }

    public Integer getUpvote() {
        return upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}