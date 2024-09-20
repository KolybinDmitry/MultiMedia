package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.VideoModel;
import com.multimedia.multimedia_web.service.TagService;
import com.multimedia.multimedia_web.service.VideoCategoryService;
import com.multimedia.multimedia_web.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private TagService tagService;

    @Autowired
    private VideoCategoryService categoryService;

    @GetMapping
    public String listVideos(Model model) {
        model.addAttribute("video", new VideoModel());
        model.addAttribute("videos", videoService.findAllVideos(0, 10));
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("categories", categoryService.findAllCategories(0, 10));
        return "video"; // шаблон
    }

    @PostMapping("/add")
    public String addVideo(@ModelAttribute VideoModel video) {
        videoService.addVideo(video);
        return "redirect:/videos";
    }

    @PostMapping("/update")
    public String updateVideo(@ModelAttribute VideoModel video) {
        videoService.updateVideo(video);
        return "redirect:/videos";
    }

    @PostMapping("/delete/{id}")
    public String deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return "redirect:/videos";
    }
}
