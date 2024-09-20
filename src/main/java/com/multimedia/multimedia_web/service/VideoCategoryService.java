package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.VideoCategoryModel;
import java.util.List;

public interface VideoCategoryService {
    List<VideoCategoryModel> findAllCategories(int page, int size);
    VideoCategoryModel findCategoryById(Long id);
    VideoCategoryModel addCategory(VideoCategoryModel category);
    VideoCategoryModel updateCategory(VideoCategoryModel category);
    void deleteCategory(Long id);
}
