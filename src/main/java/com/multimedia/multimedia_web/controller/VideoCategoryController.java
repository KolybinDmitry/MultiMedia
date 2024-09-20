package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.VideoCategoryModel;
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
@RequestMapping("/video-category")
public class VideoCategoryController {



    @Autowired
    private VideoCategoryService categoryService;

    @GetMapping
    public String listVideos(Model model) {
        model.addAttribute("category", new VideoCategoryModel());
        model.addAttribute("categories", categoryService.findAllCategories(0, 10));
        return "video_category"; // шаблон
    }

    @PostMapping("/add")
    public String addVideo(@ModelAttribute VideoCategoryModel category) {
        categoryService.addCategory(category);
        return "redirect:/video-category";
    }

    @PostMapping("/update")
    public String updateVideo(@ModelAttribute VideoCategoryModel category) {
        categoryService.updateCategory(category);
        return "redirect:/video-category";
    }

    @PostMapping("/delete/{id}")
    public String deleteVideo(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/video-category";
    }
}
