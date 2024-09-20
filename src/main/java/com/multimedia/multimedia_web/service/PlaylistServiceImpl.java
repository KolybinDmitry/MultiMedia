package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.PlaylistModel;
import com.multimedia.multimedia_web.repository.PlaylistRepository;
import com.multimedia.multimedia_web.service.PlaylistService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<PlaylistModel> findAllPlaylists(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return playlistRepository.findAll(pageable).getContent();
    }

    @Override
    public PlaylistModel findPlaylistById(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public PlaylistModel addPlaylist(PlaylistModel playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public PlaylistModel updatePlaylist(PlaylistModel playlist) {
        return playlistRepository.existsById(playlist.getId()) ? playlistRepository.save(playlist) : null;
    }

    @Override
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
