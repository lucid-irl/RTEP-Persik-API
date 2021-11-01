package com.api.persik.Models.Entities.User;

import javax.persistence.*;

@Table(name = "user_status")
@Entity
public class UserStatus {
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