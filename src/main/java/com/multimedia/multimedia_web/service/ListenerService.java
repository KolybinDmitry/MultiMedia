package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.ListenerModel;
import java.util.List;

public interface ListenerService {
    List<ListenerModel> findAllListeners(int page, int size);
    ListenerModel findListenerById(Long id);
    ListenerModel addListener(ListenerModel listener);
    ListenerModel updateListener(ListenerModel listener);
    void deleteListener(Long id);
}
