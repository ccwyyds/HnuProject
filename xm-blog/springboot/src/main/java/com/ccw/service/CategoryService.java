package com.ccw.service;

import com.ccw.entity.Category;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CategoryService {
    void insertCategory(Category category);

    void deleteCategoryById(Integer id);

    void deleteBatch(List<Integer> ids);

    void updateCategory(Category category);

    Category selectById(Integer id);

    List<Category> selectAll(Category category);

    PageInfo<Category> selectPage(Category category, Integer pageNum, Integer pageSize);
}
