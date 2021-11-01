package com.api.persik.Models.Entities;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "quote_comment", indexes = {
        @Index(name = "article_id", columnList = "article_id"),
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "quote_status_id", columnList = "quote_status_id")
})
@Entity
public class QuoteComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content", length = 8000)
    private String content;

    @Column(name = "sentence", length = 2000)
    private String sentence;

    @Column(name = "start_index")
    private Integer startIndex;

    @Column(name = "end_index")
    private Integer endIndex;

    @Column(name = "upvote")
    private Integer upvote;

    @Column(name = "downvote")
    private Integer downvote;

    @Column(name = "public_date")
    private Instant publicDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Article user;

    @ManyToOne
    @JoinColumn(name = "quote_status_id")
    private QuoteCommentStatus quoteStatus;

    public QuoteCommentStatus getQuoteStatus() {
        return quoteStatus;
    }

    public void setQuoteStatus(QuoteCommentStatus quoteStatus) {
        this.quoteStatus = quoteStatus;
    }

    public Article getUser() {
        return user;
    }

    public void setUser(Article user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
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