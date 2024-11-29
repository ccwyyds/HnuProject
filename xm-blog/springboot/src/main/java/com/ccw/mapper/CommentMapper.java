package com.ccw.mapper;

import com.ccw.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 新增
     */
    int insert(Comment comment);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Comment comment);

    /**
     * 根据ID查询
     */
    Comment selectById(Integer id);

    /**
     * 查询所有
     */
    List<Comment> selectAll(Comment comment);

    /**
     * 查询前台展示的评论信息
     * @author xixiw
     * @time 2024/5/28 💕 20:39
     */
    List<Comment> selectForUser(Comment comment);


    /**
     * 查询评论条数
     * @author xixiw
     * @time 2024/5/28 💕 21:36
     */
    @Select("select count(*) from comment where fid = #{fid} and module = #{module}")
    Integer selectCount(@Param("fid") Integer fid,@Param("module") String module);
}