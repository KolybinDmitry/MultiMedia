package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.ListenerModel;
import com.multimedia.multimedia_web.model.VideoModel;
import com.multimedia.multimedia_web.service.AudioService;
import com.multimedia.multimedia_web.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/listeners")
public class ListenerController {

    @Autowired
    private ListenerService listenerService;
    @Autowired
    private AudioService audioService;

    @GetMapping
    public String listListeners(Model model) {
        model.addAttribute("listener", new ListenerModel());
        model.addAttribute("listeners", listenerService.findAllListeners(0,10));
        model.addAttribute("audios", audioService.findAllAudios(0,10));
        return "listener_list";
    }

    @PostMapping("/add")
    public String addListener(@ModelAttribute ListenerModel listener) {
        listenerService.addListener(listener);
        return "redirect:/listeners";
    }

    @PostMapping("/update")
    public String updateListener(@ModelAttribute ListenerModel listener) {
        listenerService.updateListener(listener);
        return "redirect:/listeners";
    }

    @PostMapping("/delete/{id}")
    public String deleteListener(@PathVariable Long id) {
        listenerService.deleteListener(id);
        return "redirect:/listeners";
    }
}
