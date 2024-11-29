package com.ccw.controller;

import com.ccw.common.Result;
import com.ccw.entity.Comment;
import com.ccw.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 评论操作
 * @author xixiw
 * @time 2024/5/28 💕 15:55
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    /**
     * 新增
     * @author xixiw
     * @time 2024/5/28 💕 15:55
     */
    @PostMapping("/add")
    public Result add(@RequestBody Comment comment) {
        commentService.add(comment);
        return Result.success();
    }

    /**
     * 删除
     * @author xixiw
     * @time 2024/5/28 💕 15:55
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        commentService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     * @author xixiw
     * @time 2024/5/28 💕 15:55
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        commentService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     * @author xixiw
     * @time 2024/5/28 💕 15:55
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Comment comment) {
        commentService.updateById(comment);
        return Result.success();
    }

    /**
     * 根据id查询
     * @author xixiw
     * @time 2024/5/28 💕 15:55
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Comment comment = commentService.selectById(id);
        return Result.success(comment);
    }

    /**
     * 查询所有评论
     * @author xixiw
     * @time 2024/5/28 💕 15:56
     */
    @GetMapping("/selectAll")
    public Result selectAll(Comment comment) {
        List<Comment> list = commentService.selectAll(comment);
        return Result.success(list);
    }

    /**
     * 为前台用户专门查询
     * @author xixiw
     * @time 2024/5/28 💕 20:47
     */
    @GetMapping("/selectForUser")
    public Result selectForUser(Comment comment) {
        List<Comment> list = commentService.selectForUser(comment);
        return Result.success(list);
    }
    /**
     * 分页查询
     * @author xixiw
     * @time 2024/5/28 💕 15:56
     */
    @GetMapping("/selectPage")
    public Result selectPage(Comment comment,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Comment> page = commentService.selectPage(comment, pageNum, pageSize);
        return Result.success(page);
    }



    /**
     * 查询评论条数
     * @author xixiw
     * @time 2024/5/28 💕 21:19
     */
    @GetMapping("/selectCount")
    public Result selectPage(@RequestParam Integer fid,@RequestParam String module) {
        Integer count = commentService.selectCount(fid, module);
        return Result.success(count);
    }

}