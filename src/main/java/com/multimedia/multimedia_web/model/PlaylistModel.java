package com.multimedia.multimedia_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "playlists")
public class PlaylistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 4, message = "Название не должно содержать менее 4х смиволов")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "playlist_audios",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "audio_id")
    )
    private Set<AudioModel> audios;

    public PlaylistModel() {
    }

    public PlaylistModel(Long id, String name, Set<AudioModel> audios) {
        this.id = id;
        this.name = name;
        this.audios = audios;
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

    public Set<AudioModel> getAudios() {
        return audios;
    }

    public void setAudios(Set<AudioModel> audios) {
        this.audios = audios;
    }
}
