package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.ImageModel;
import com.multimedia.multimedia_web.repository.ImageRepository;
import com.multimedia.multimedia_web.service.ImageService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<ImageModel> findAllImages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return imageRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ImageModel> listAllImages() {
        return null;
    }

    @Override
    public ImageModel findImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public ImageModel addImage(ImageModel image) {
        return imageRepository.save(image);
    }

    @Override
    public ImageModel updateImage(ImageModel image) {
        return imageRepository.existsById(image.getId()) ? imageRepository.save(image) : null;
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
