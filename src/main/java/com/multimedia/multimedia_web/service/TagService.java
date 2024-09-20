package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.ImageCategoryModel;
import com.multimedia.multimedia_web.model.TagModel;
import java.util.List;

public interface TagService {
    List<TagModel> findAll();
    List<TagModel> listAllTags();
    TagModel findTagById(Long id);
    TagModel addTag(TagModel tag);
    TagModel updateTag(TagModel tag);
    void deleteTag(Long id);
}
