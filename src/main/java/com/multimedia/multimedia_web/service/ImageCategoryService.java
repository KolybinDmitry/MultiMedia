    package com.multimedia.multimedia_web.service;

    import com.multimedia.multimedia_web.model.AudioModel;
    import com.multimedia.multimedia_web.model.ImageCategoryModel;
    import java.util.List;

    public interface ImageCategoryService {
        List<ImageCategoryModel> findAllCategories(int page, int size);
        List<ImageCategoryModel> listAllCategory();
        ImageCategoryModel findCategoryById(Long id);
        ImageCategoryModel addCategory(ImageCategoryModel category);
        ImageCategoryModel updateCategory(ImageCategoryModel category);
        void deleteCategory(Long id);
    }
