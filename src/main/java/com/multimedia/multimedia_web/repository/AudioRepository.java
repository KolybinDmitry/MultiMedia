package com.multimedia.multimedia_web.repository;

import com.multimedia.multimedia_web.model.AudioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<AudioModel, Long> {
}
