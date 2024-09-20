package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.VideoModel;
import com.multimedia.multimedia_web.repository.VideoRepository;
import com.multimedia.multimedia_web.service.VideoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<VideoModel> findAllVideos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return videoRepository.findAll(pageable).getContent();
    }

    @Override
    public VideoModel findVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    @Override
    public VideoModel addVideo(VideoModel video) {
        return videoRepository.save(video);
    }

    @Override
    public VideoModel updateVideo(VideoModel video) {
        return videoRepository.existsById(video.getId()) ? videoRepository.save(video) : null;
    }

    @Override
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
