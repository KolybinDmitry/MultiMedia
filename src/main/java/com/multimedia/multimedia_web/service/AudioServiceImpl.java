package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.AudioModel;
import com.multimedia.multimedia_web.repository.AudioRepository;
import com.multimedia.multimedia_web.service.AudioService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioServiceImpl implements AudioService {

    private final AudioRepository audioRepository;

    public AudioServiceImpl(AudioRepository audioRepository) {
        this.audioRepository = audioRepository;
    }

    @Override
    public List<AudioModel> findAllAudios(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return audioRepository.findAll(pageable).getContent();
    }

    @Override
    public List<AudioModel> listAllAudios() {
        return audioRepository.findAll();
    }

    @Override
    public AudioModel findAudioById(Long id) {
        return audioRepository.findById(id).orElse(null);
    }

    @Override
    public AudioModel addAudio(AudioModel category) {
        return audioRepository.save(category);
    }

    @Override
    public AudioModel updateAudio(AudioModel category) {
        return audioRepository.existsById(category.getId()) ? audioRepository.save(category) : null;
    }

    @Override
    public void deleteAudio(Long id) {
        audioRepository.deleteById(id);
    }
}
