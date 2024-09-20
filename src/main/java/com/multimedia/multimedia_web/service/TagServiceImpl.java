package com.multimedia.multimedia_web.service;

import com.multimedia.multimedia_web.model.TagModel;
import com.multimedia.multimedia_web.repository.TagRepository;
import com.multimedia.multimedia_web.service.TagService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagModel> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<TagModel> listAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public TagModel findTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public TagModel addTag(TagModel tag) {
        return tagRepository.save(tag);
    }

    @Override
    public TagModel updateTag(TagModel tag) {
        return tagRepository.existsById(tag.getId()) ? tagRepository.save(tag) : null;
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
