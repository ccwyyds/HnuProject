package com.ccw.service.impl;

import cn.hutool.core.date.DateUtil;
import com.ccw.common.enums.RoleEnum;
import com.ccw.entity.Account;
import com.ccw.entity.Comment;
import com.ccw.mapper.CommentMapper;
import com.ccw.service.CommentService;
import com.ccw.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    /**
     * 新增
     * @author xixiw
     * @time 2024/5/28 💕 15:59
     */
    public void add(Comment comment) {
        Account currentUser = TokenUtils.getCurrentUser();
        if(RoleEnum.USER.name().equals(currentUser.getRole())){
            comment.setUserId(currentUser.getId());
        }
        comment.setTime(DateUtil.now());
        commentMapper.insert(comment);
        if(comment.getRootId() == null){
            comment.setRootId(comment.getId());
            commentMapper.updateById(comment);
        }

    }

    /**
     * 删除
     * @author xixiw
     * @time 2024/5/28 💕 15:59
     */
    public void deleteById(Integer id) {
        commentMapper.deleteById(id);
    }

    /**
     * 批量删除
     * @author xixiw
     * @time 2024/5/28 💕 15:59
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            commentMapper.deleteById(id);
        }
    }

    /**
     * 修改
     * @author xixiw
     * @time 2024/5/28 💕 15:59
     */
    public void updateById(Comment comment) {
        commentMapper.updateById(comment);
    }

    /**
     * 根据id查询
     * @author xixiw
     * @time 2024/5/28 💕 15:59
     */
    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }

    /**
     * 查询所有
     * @author xixiw
     * @time 2024/5/28 💕 15:59
     */
    public List<Comment> selectAll(Comment comment) {
        return commentMapper.selectAll(comment);
    }


    /**
     * 查询所有子集评论
     * @author xixiw
     * @time 2024/5/28 💕 20:41
     */
    public List<Comment> selectForUser(Comment comment) {
        List<Comment> commentList = commentMapper.selectForUser(comment);  // 查询一级的评论
        for (Comment c : commentList) {  // 查询回复列表
            Comment param = new Comment();
            param.setRootId(c.getId());
            List<Comment> children = this.selectAll(param);
            children = children.stream().filter(child -> !child.getId().equals(c.getId())).collect(Collectors.toList());  // 排除当前查询结果里最外层节点

            c.setChildren(children);
        }
        return commentList;
    }

    /**
     * 查询评论条数
     * @author xixiw
     * @time 2024/5/28 💕 21:23
     */
    @Override
    public Integer selectCount(Integer fid, String module) {
        return commentMapper.selectCount(fid,module);
    }

    /**
     * 分页查询
     * @author xixiw
     * @time 2024/5/28 💕 16:00
     */
    public PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentMapper.selectAll(comment);
        return PageInfo.of(list);
    }
}
