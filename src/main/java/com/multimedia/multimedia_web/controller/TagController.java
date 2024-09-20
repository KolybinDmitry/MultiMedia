package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.TagModel;
import com.multimedia.multimedia_web.model.VideoModel;
import com.multimedia.multimedia_web.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public String listTags(Model model) {
        model.addAttribute("tag", new TagModel()); // создаем новый объект
        model.addAttribute("tags", tagService.findAll()); // загружаем существующие теги
        return "tag_list"; // шаблон
    }

    @PostMapping("/add")
    public String addTag(@ModelAttribute TagModel tag) {
        tagService.addTag(tag);
        return "redirect:/tags";
    }

    @PostMapping("/update")
    public String updateTag(@ModelAttribute TagModel tag) {
        tagService.updateTag(tag);
        return "redirect:/tags";
    }

    @PostMapping("/delete/{id}")
    public String deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/tags";
    }
}
