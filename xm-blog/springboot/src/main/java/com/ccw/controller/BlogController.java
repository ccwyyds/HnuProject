package com.ccw.controller;

import com.ccw.common.Result;
import com.ccw.entity.Blog;
import com.ccw.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 博客控制类
 * @author xixiw
 * @time 2024/5/22 💕 16:01
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 新增博客
     * @author xixiw
     * @time 2024/5/22 💕 16:01
     */
    @PostMapping("/add")
    public Result add(@RequestBody Blog blog) {
        blogService.add(blog);
        return Result.success();
    }

    /**
     * 删除博客
     * @author xixiw
     * @time 2024/5/22 💕 16:01
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        blogService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除博客
     * @author xixiw
     * @time 2024/5/22 💕 16:01
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        blogService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改博客内容
     * @author xixiw
     * @time 2024/5/22 💕 16:02
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Blog blog) {
        blogService.updateById(blog);
        return Result.success();
    }


    /**
     * 修改博客浏览量
     * @author xixiw
     * @time 2024/5/30 💕 22:18
     */
    @PutMapping("/updateReadCount/{blogId}")
    public Result updateById(@PathVariable Integer blogId) {
        blogService.updateReadCount(blogId);
        return Result.success();
    }

    /**
     * 根据id查询博客内容
     * @author xixiw
     * @time 2024/5/22 💕 16:02
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Blog blog = blogService.selectById(id);
        return Result.success(blog);
    }

    /**
     * 查询所有博客
     * @author xixiw
     * @time 2024/5/22 💕 16:02
     */
    @GetMapping("/selectAll")
    public Result selectAll(Blog blog) {
        List<Blog> list = blogService.selectAll(blog);
        return Result.success(list);
    }


    /**
     * 分页查询所有博客
     * @author xixiw
     * @time 2024/5/22 💕 16:02
     */
    @GetMapping("/selectPage")
    public Result selectPage(Blog blog,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Blog> page = blogService.selectPage(blog, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询自己点过赞的博客列表
     * @author xixiw
     * @time 2024/5/22 💕 16:02
     */
    @GetMapping("/selectLike")
    public Result selectLike(Blog blog,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Blog> page = blogService.selectLike(blog, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 分页查询当前用户收藏的博客列表
     * @author vv
     * @time 2024/11/26 💕 0:02
     */
    @GetMapping("/selectCollect")
    public Result selectCollect(Blog blog,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Blog> page = blogService.selectCollect(blog, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 分页查询当前用户评论的博客列表
     * @author vv
     * @time 2024/11/26 💕 0:02
     */
    @GetMapping("/selectComment")
    public Result selectComment(Blog blog,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Blog> page = blogService.selectComment(blog, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询博客榜单
     * @author xixiw
     * @time 2024/5/26 💕 21:34
     */
    @GetMapping("/selectTop")
    public Result selectTop() {
        List<Blog> list = blogService.selectTop();
        return Result.success(list);
    }


    /**
     * 博客推荐
     * @author xixiw
     * @time 2024/5/27 💕 18:19
     */
    @GetMapping("/selectRecommend/{bolgId}")
    public Result selectRecommend(@PathVariable Integer bolgId) {
        Set<Blog> list = blogService.selectRecommend(bolgId);
        return Result.success(list);
    }
}