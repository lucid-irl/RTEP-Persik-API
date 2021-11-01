package com.api.persik.Models.Entities;

import com.api.persik.Models.Entities.User.User;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "article", indexes = {
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "tag_id", columnList = "tag_id")
})
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "content")
    private byte[] content;

    @Column(name = "view")
    private Integer view;

    @Column(name = "upvote")
    private Integer upvote;

    @Column(name = "downvote")
    private Integer downvote;

    @Column(name = "public_date")
    private Instant publicDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "thumbnail_image", length = 2083)
    private String thumbnailImage;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "is_anonymous")
    private Boolean isAnonymous;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
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

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
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