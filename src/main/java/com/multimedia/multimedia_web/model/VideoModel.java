package com.multimedia.multimedia_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "videos")
public class VideoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 4, message = "Название не должно содержать менее 4х смиволов")
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private VideoCategoryModel category;

    @ManyToMany
    @JoinTable(
            name = "video_tags",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagModel> tags;

    public VideoModel() {
    }

    public VideoModel(Long id, String title, VideoCategoryModel category, Set<TagModel> tags) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VideoCategoryModel getCategory() {
        return category;
    }

    public void setCategory(VideoCategoryModel category) {
        this.category = category;
    }

    public Set<TagModel> getTags() {
        return tags;
    }

    public void setTags(Set<TagModel> tags) {
        this.tags = tags;
    }
}
