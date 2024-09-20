package com.multimedia.multimedia_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "tags")
public class TagModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Название тега не должно быть пустым")
    @Size(min = 4, message = "Название не должно содержать менее 4х смиволов")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<VideoModel> videos;

    @ManyToMany(mappedBy = "tags")
    private Set<AudioModel> audios;

    @ManyToMany(mappedBy = "tags")
    private Set<ImageModel> images;



    public TagModel() {}

    public TagModel(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<AudioModel> getAudios() {
        return audios;
    }

    public void setAudios(Set<AudioModel> audios) {
        this.audios = audios;
    }

    public Set<ImageModel> getImages() {
        return images;
    }

    public void setImages(Set<ImageModel> images) {
        this.images = images;
    }
}
