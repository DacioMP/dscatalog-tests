package com.pedrosa.dscatalog.services;

import com.pedrosa.dscatalog.dto.CategoryDTO;
import com.pedrosa.dscatalog.entities.Category;
import com.pedrosa.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = repository.findAll();

        return list
                .stream()
                .map(CategoryDTO::new)
                .toList();
    }
}
