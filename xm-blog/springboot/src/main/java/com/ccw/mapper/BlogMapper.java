package com.ccw.mapper;

import com.ccw.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作blog相关数据接口
 */
@Mapper
public interface BlogMapper {

    /**
     * 新增
     */
    int insert(Blog blog);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Blog blog);

    /**
     * 根据ID查询
     */
    Blog selectById(Integer id);

    /**
     * 查询所有
     */
    List<Blog> selectAll(Blog blog);

    /**
     * 查询用户的博客数量
     * @author xixiw
     * @time 2024/5/29 💕 15:41
     */
    List<Blog> selectUserBlog(Integer userId);

    /**
     * 更新用户阅读量
     * @author xixiw
     * @time 2024/5/30 💕 22:27
     */
    void updateReadCount(Integer blogId);

    List<Blog> selectLike(Blog blog);

    List<Blog> selectCollect(Blog blog);

    List<Blog> selectComment(Blog blog);
}