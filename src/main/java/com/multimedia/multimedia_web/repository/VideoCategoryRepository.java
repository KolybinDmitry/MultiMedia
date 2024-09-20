package com.multimedia.multimedia_web.repository;

import com.multimedia.multimedia_web.model.VideoCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoCategoryRepository extends JpaRepository<VideoCategoryModel, Long> {
}
