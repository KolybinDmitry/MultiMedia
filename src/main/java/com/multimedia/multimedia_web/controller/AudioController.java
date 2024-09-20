package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.AudioModel;
import com.multimedia.multimedia_web.model.TagModel;
import com.multimedia.multimedia_web.service.AudioService;
import com.multimedia.multimedia_web.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/audios")
public class AudioController {

    @Autowired
    private AudioService audioService;

    @Autowired
    private TagService tagService;

    @GetMapping
    public String listAudios(Model model) {
        model.addAttribute("audio", new AudioModel());
        model.addAttribute("audios", audioService.findAllAudios(0,10));
        model.addAttribute("tags", tagService.findAll());
        return "audio_list";
    }

    @PostMapping("/add")
    public String addAudio(@Valid @ModelAttribute("audio") AudioModel audio, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("audios", audioService.findAllAudios(0,10));
            model.addAttribute("tags", tagService.findAll());
            return "audio_list"; // Возвращаем ту же форму с ошибками
        }
        audioService.addAudio(audio);
        return "redirect:/audios";
    }

    @PostMapping("/update")
    public String updateAudio(@ModelAttribute AudioModel audio) {
        audioService.updateAudio(audio);
        return "redirect:/audios";
    }

    @PostMapping("/delete/{id}")
    public String deleteAudio(@PathVariable Long id) {
        audioService.deleteAudio(id);
        return "redirect:/audios";
    }
}
