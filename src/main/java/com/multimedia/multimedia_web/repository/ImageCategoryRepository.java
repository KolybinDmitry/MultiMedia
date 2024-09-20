package com.multimedia.multimedia_web.repository;

import com.multimedia.multimedia_web.model.ImageCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageCategoryRepository extends JpaRepository<ImageCategoryModel, Long> {
}
