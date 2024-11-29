package com.ccw.service.impl;

import com.ccw.entity.Category;
import com.ccw.entity.User;
import com.ccw.mapper.CategoryMapper;
import com.ccw.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 新增博客分类
     * @author xixiw
     * @time 2024/5/22 💕 12:57
     */
    @Override
    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    /**
     * 根据id删除博客分类
     * @author xixiw
     * @time 2024/5/22 💕 12:57
     */
    @Override
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteCategoryById(id);
    }

    /**
     * 批量删除博客分类
     * @author xixiw
     * @time 2024/5/22 💕 12:57
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            categoryMapper.deleteCategoryById(id);
        }

    }

    /**
     * 修改博客分类
     * @author xixiw
     * @time 2024/5/22 💕 13:00
     */
    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    /**
     * 根据id查询用户信息
     * @author xixiw
     * @time 2024/5/22 💕 13:50
     */
    @Override
    public Category selectById(Integer id) {
        Category category = categoryMapper.selectById(id);
        return category;
    }

    @Override
    public List<Category> selectAll(Category category) {
         List<Category> categoryList = categoryMapper.selectAll(category);
        return categoryList;
    }


    @Override
    public PageInfo<Category> selectPage(Category category, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Category> list = categoryMapper.selectAll(category);
        return PageInfo.of(list);
    }

}
