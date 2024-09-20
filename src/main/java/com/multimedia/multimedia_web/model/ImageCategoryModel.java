package com.multimedia.multimedia_web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "image_categories")
public class ImageCategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, message = "Название не должно содержать менее 4х смиволов")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ImageModel> category;

    public ImageCategoryModel() {
    }

    public ImageCategoryModel(Long id, String name, Set<ImageModel> images) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ImageModel> getCategory() {
        return category;
    }

    public void setCategory(Set<ImageModel> images) {
        this.category = images;
    }
}
