package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.ImageModel;
import com.multimedia.multimedia_web.model.VideoModel;
import com.multimedia.multimedia_web.service.ImageService;
import com.multimedia.multimedia_web.service.TagService;
import com.multimedia.multimedia_web.service.ImageCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ImageCategoryService categoryService;

    @GetMapping
    public String listImages(Model model) {
        model.addAttribute("image", new ImageModel());
        model.addAttribute("images", imageService.findAllImages(0, 10));
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("categories", categoryService.findAllCategories(0, 10));
        return "image_list"; // шаблон
    }

    @PostMapping("/add")
    public String addImage(@Valid @ModelAttribute ImageModel image, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("images", imageService.findAllImages(0, 10));
            model.addAttribute("tags", tagService.findAll());
            model.addAttribute("categories", categoryService.findAllCategories(0, 10));
            return "audio_list";
        }
        imageService.addImage(image);
        return "redirect:/images";
    }

    @PostMapping("/update")
    public String updateImage(@ModelAttribute ImageModel image) {
        imageService.updateImage(image);
        return "redirect:/images";
    }

    @PostMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return "redirect:/images";
    }
}
