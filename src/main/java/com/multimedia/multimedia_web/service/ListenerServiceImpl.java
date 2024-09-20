package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.ListenerModel;
import com.multimedia.multimedia_web.repository.ListenerRepository;
import com.multimedia.multimedia_web.service.ListenerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListenerServiceImpl implements ListenerService {

    private final ListenerRepository listenerRepository;

    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public List<ListenerModel> findAllListeners(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return listenerRepository.findAll(pageable).getContent();
    }

    @Override
    public ListenerModel findListenerById(Long id) {
        return listenerRepository.findById(id).orElse(null);
    }

    @Override
    public ListenerModel addListener(ListenerModel listener) {
        return listenerRepository.save(listener);
    }

    @Override
    public ListenerModel updateListener(ListenerModel listener) {
        return listenerRepository.existsById(listener.getId()) ? listenerRepository.save(listener) : null;
    }

    @Override
    public void deleteListener(Long id) {
        listenerRepository.deleteById(id);
    }
}
