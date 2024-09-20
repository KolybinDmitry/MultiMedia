package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.AudioModel;
import com.multimedia.multimedia_web.model.ImageModel;
import java.util.List;

public interface ImageService {
    List<ImageModel> findAllImages(int page, int size);
    List<ImageModel> listAllImages();
    ImageModel findImageById(Long id);
    ImageModel addImage(ImageModel image);
    ImageModel updateImage(ImageModel image);
    void deleteImage(Long id);
}
