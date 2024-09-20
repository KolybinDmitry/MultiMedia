package com.multimedia.multimedia_web.repository;

import com.multimedia.multimedia_web.model.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {
}
