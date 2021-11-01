package com.api.persik.Models.Entities;

import javax.persistence.*;

@Table(name = "quote_comment_status")
@Entity
public class QuoteCommentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "quote_comment_status_name")
    private String quoteCommentStatusName;

    public String getQuoteCommentStatusName() {
        return quoteCommentStatusName;
    }

    public void setQuoteCommentStatusName(String quoteCommentStatusName) {
        this.quoteCommentStatusName = quoteCommentStatusName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}