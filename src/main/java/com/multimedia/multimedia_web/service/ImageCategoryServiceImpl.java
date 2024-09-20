package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.ImageCategoryModel;
import com.multimedia.multimedia_web.repository.ImageCategoryRepository;
import com.multimedia.multimedia_web.service.ImageCategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageCategoryServiceImpl implements ImageCategoryService {

    private final ImageCategoryRepository imageCategoryRepository;

    public ImageCategoryServiceImpl(ImageCategoryRepository imageCategoryRepository) {
        this.imageCategoryRepository = imageCategoryRepository;
    }

    @Override
    public List<ImageCategoryModel> findAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return imageCategoryRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ImageCategoryModel> listAllCategory() {
        return imageCategoryRepository.findAll();
    }

    @Override
    public ImageCategoryModel findCategoryById(Long id) {
        return imageCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ImageCategoryModel addCategory(ImageCategoryModel category) {
        return imageCategoryRepository.save(category);
    }

    @Override
    public ImageCategoryModel updateCategory(ImageCategoryModel category) {
        return imageCategoryRepository.existsById(category.getId()) ? imageCategoryRepository.save(category) : null;
    }

    @Override
    public void deleteCategory(Long id) {
        imageCategoryRepository.deleteById(id);
    }
}
