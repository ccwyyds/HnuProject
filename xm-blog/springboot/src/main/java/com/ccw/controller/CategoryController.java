package com.ccw.controller;

import com.ccw.common.Result;
import com.ccw.entity.Category;
import com.ccw.entity.User;
import com.ccw.service.CategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 博客分类操作接口
 * @author xixiw
 * @time 2024/5/22 💕 0:52
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    /**
     * 新增博客分类
     * @author xixiw
     * @time 2024/5/22 💕 0:54
     */
    @RequestMapping("/add")
    public Result insertCategory(@RequestBody Category category){
        categoryService.insertCategory(category);
        return Result.success();
    }

    /**
     * 根据id删除博客分类
     * @author xixiw
     * @time 2024/5/22 💕 0:54
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
        return Result.success();
    }


    /**
     * 批量删除博客分类
     * @author xixiw
     * @time 2024/5/22 💕 0:54
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        categoryService.deleteBatch(ids);
        return Result.success();
    }


    /**
     * 修改博客内容
     * @author xixiw
     * @time 2024/5/22 💕 0:54
     */
    @PutMapping("/update")
    public Result updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return Result.success();
    }

    /**
     * 根据id查询
     * @author xixiw
     * @time 2024/5/22 💕 0:54
     */
    @GetMapping("/select/{id}")
    public Result selectById(@PathVariable Integer id){
        Category category = categoryService.selectById(id);
        return Result.success(category);
    }


    /**
     * 查询所有
     * @author xixiw
     * @time 2024/5/22 💕 0:55
     */
    @GetMapping("/selectAll")
    public Result selectAll( Category category){
        List<Category> categoryList = categoryService.selectAll(category);
        return Result.success(categoryList);
    }



    /**
     * 分页查询
     * @author xixiw
     * @time 2024/5/22 💕 14:46
     */
    @GetMapping("/selectPage")
    public Result selectPage(Category category,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Category> page = categoryService.selectPage(category, pageNum, pageSize);
        return Result.success(page);
    }


}
