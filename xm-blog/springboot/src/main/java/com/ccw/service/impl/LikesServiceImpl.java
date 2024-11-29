package com.ccw.service.impl;

import com.ccw.entity.Account;
import com.ccw.entity.Likes;
import com.ccw.mapper.LikesMapper;
import com.ccw.service.LikesService;
import com.ccw.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesMapper likesMapper;

    @Override
    public void set(Likes likes) {
        Account currentUser = TokenUtils.getCurrentUser();
        likes.setUserId(currentUser.getId());
        Likes dbLikes = likesMapper.selectUserLikes(likes);
        if(dbLikes == null){
            likesMapper.insert(likes);
        }else {
            likesMapper.deleteById(dbLikes.getId());
        }


    }

    /**
     * 查询当前用户是否点过赞
     * @author xixiw
     * @time 2024/5/27 💕 21:56
     */
    public Likes selectUserLikes(Integer fid ,String module){
        Likes likes = new Likes();
        Account currentUser = TokenUtils.getCurrentUser();
        likes.setUserId(currentUser.getId());

        likes.setFid(fid);
        likes.setModule(module);
        return likesMapper.selectUserLikes(likes);
    }


    @Override
    public int selectByFidAndModule(Integer fid, String module) {

        return likesMapper.selectByFidAndModule(fid,module);
    }
}
