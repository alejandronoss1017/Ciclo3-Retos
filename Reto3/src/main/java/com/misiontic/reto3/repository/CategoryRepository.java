package com.misiontic.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.misiontic.reto3.model.Category;
import com.misiontic.reto3.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category c) {
        return categoryRepository.save(c);
    }

    public void delete(Category c) {
        categoryRepository.delete(c);
    }
}
