package com.multimedia.multimedia_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "listeners")
public class ListenerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Имя слушателя не должно быть пустым")
    @Size(min = 3, message = "Имя не должно содержать менее 3х смиволов")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "listener_audios",
            joinColumns = @JoinColumn(name = "listener_id"),
            inverseJoinColumns = @JoinColumn(name = "audio_id")
    )
    private Set<AudioModel> listenedAudios;

    public ListenerModel() {
    }

    public ListenerModel(Long id, String name, Set<AudioModel> listenedAudios) {
        this.id = id;
        this.name = name;
        this.listenedAudios = listenedAudios;
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

    public Set<AudioModel> getListenedAudios() {
        return listenedAudios;
    }

    public void setListenedAudios(Set<AudioModel> listenedAudios) {
        this.listenedAudios = listenedAudios;
    }
}
