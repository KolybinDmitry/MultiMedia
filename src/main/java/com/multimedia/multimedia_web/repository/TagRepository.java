package com.multimedia.multimedia_web.repository;

import com.multimedia.multimedia_web.model.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagModel, Long> {
}
