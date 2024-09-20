package com.multimedia.multimedia_web.repository;

import com.multimedia.multimedia_web.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}
