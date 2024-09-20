package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.AudioModel;
import com.multimedia.multimedia_web.model.ImageCategoryModel;
import com.multimedia.multimedia_web.model.ImageModel;
import com.multimedia.multimedia_web.service.TagService;
import com.multimedia.multimedia_web.service.ImageCategoryService;
import com.multimedia.multimedia_web.service.ImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/image-category")
public class ImageCategoryController {



    @Autowired
    private ImageCategoryService categoryService;

    @GetMapping
    public String listImages(Model model) {
        model.addAttribute("category", new ImageCategoryModel());
        model.addAttribute("categories", categoryService.findAllCategories(0, 10));
        return "image_category"; // шаблон
    }

    @PostMapping("/add")
    public String addAudio(@Valid @ModelAttribute("category") ImageCategoryModel category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAllCategories(0,10));
            return "image_category";
        }
        categoryService.addCategory(category);
        return "redirect:/image-category";
    }


    @PostMapping("/update")
    public String updateImage(@ModelAttribute ImageCategoryModel category) {

        categoryService.updateCategory(category);
        return "redirect:/image-category";
    }

    @PostMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/image-category";
    }
}
