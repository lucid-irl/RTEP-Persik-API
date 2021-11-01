package com.api.persik.Models.Entities;

import javax.persistence.*;

@Table(name = "comment_status")
@Entity
public class CommentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}