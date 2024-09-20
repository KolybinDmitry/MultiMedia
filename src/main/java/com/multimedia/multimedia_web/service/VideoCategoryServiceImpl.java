package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.VideoCategoryModel;
import com.multimedia.multimedia_web.repository.VideoCategoryRepository;
import com.multimedia.multimedia_web.service.VideoCategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCategoryServiceImpl implements VideoCategoryService {

    private final VideoCategoryRepository videoCategoryRepository;

    public VideoCategoryServiceImpl(VideoCategoryRepository videoCategoryRepository) {
        this.videoCategoryRepository = videoCategoryRepository;
    }

    @Override
    public List<VideoCategoryModel> findAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return videoCategoryRepository.findAll(pageable).getContent();
    }

    @Override
    public VideoCategoryModel findCategoryById(Long id) {
        return videoCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public VideoCategoryModel addCategory(VideoCategoryModel category) {
        return videoCategoryRepository.save(category);
    }

    @Override
    public VideoCategoryModel updateCategory(VideoCategoryModel category) {
        return videoCategoryRepository.existsById(category.getId()) ? videoCategoryRepository.save(category) : null;
    }

    @Override
    public void deleteCategory(Long id) {
        videoCategoryRepository.deleteById(id);
    }
}
