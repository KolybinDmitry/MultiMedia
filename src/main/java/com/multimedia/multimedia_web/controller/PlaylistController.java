package com.multimedia.multimedia_web.controller;

import com.multimedia.multimedia_web.model.PlaylistModel;
import com.multimedia.multimedia_web.model.VideoModel;
import com.multimedia.multimedia_web.service.AudioService;
import com.multimedia.multimedia_web.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private AudioService audioService;

    @GetMapping
    public String listPlaylists(Model model) {
        model.addAttribute("playlist", new PlaylistModel());
        model.addAttribute("playlists", playlistService.findAllPlaylists(0,10));
        model.addAttribute("audios", audioService.findAllAudios(0,10));
        return "playlist";
    }

    @PostMapping("/add")
    public String addPlaylist(@ModelAttribute PlaylistModel playlist) {
        playlistService.addPlaylist(playlist);
        return "redirect:/playlists";
    }

    @PostMapping("/update")
    public String updatePlaylist(@ModelAttribute PlaylistModel playlist) {
        playlistService.updatePlaylist(playlist);
        return "redirect:/playlists";
    }

    @PostMapping("/delete/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return "redirect:/playlists";
    }
}
