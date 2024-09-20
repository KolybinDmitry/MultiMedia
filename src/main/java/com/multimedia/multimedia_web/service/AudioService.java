package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.AudioModel;
import java.util.List;

public interface AudioService {
    List<AudioModel> findAllAudios(int page, int size);
    List<AudioModel> listAllAudios();
    AudioModel findAudioById(Long id);
    AudioModel addAudio(AudioModel audio);
    AudioModel updateAudio(AudioModel audio);
    void deleteAudio(Long id);
}
