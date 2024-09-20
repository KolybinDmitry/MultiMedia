package com.multimedia.multimedia_web.repository;

import com.multimedia.multimedia_web.model.PlaylistModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlaylistModel, Long> {
}
