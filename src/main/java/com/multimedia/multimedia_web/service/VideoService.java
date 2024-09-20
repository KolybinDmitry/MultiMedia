package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.VideoModel;
import java.util.List;

public interface VideoService {
    List<VideoModel> findAllVideos(int page, int size);
    VideoModel findVideoById(Long id);
    VideoModel addVideo(VideoModel video);
    VideoModel updateVideo(VideoModel video);
    void deleteVideo(Long id);
}
