package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.PlaylistModel;
import java.util.List;

public interface PlaylistService {
    List<PlaylistModel> findAllPlaylists(int page, int size);
    PlaylistModel findPlaylistById(Long id);
    PlaylistModel addPlaylist(PlaylistModel playlist);
    PlaylistModel updatePlaylist(PlaylistModel playlist);
    void deletePlaylist(Long id);
}
