package com.ccw.mapper;

import com.ccw.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CategoryMapper {
    public void insertCategory(Category category);

    void deleteCategoryById(Integer id);

    void updateCategory(Category category);

    Category selectById(Integer id);

    List<Category> selectAll(Category category);


}
