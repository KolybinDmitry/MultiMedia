package com.multimedia.multimedia_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "video_categories")
public class VideoCategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Название категории не должно быть пустым")
    @Size(min = 4, message = "Название не должно содержать менее 4х смиволов")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<VideoModel> videos;

    public VideoCategoryModel() {
    }

    public VideoCategoryModel(Long id, String name, Set<VideoModel> videos) {
        this.id = id;
        this.name = name;
        this.videos = videos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<VideoModel> getVideos() {
        return videos;
    }

    public void setVideos(Set<VideoModel> videos) {
        this.videos = videos;
    }
}
