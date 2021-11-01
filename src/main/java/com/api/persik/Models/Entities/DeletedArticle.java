package com.api.persik.Models.Entities;

import com.api.persik.Models.Entities.User.User;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "deleted_article", indexes = {
        @Index(name = "article_id", columnList = "article_id"),
        @Index(name = "who_delete", columnList = "who_delete")
})
@Entity
public class DeletedArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "who_delete")
    private User whoDelete;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column(name = "delete_date")
    private Instant deleteDate;

    public Instant getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Instant deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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