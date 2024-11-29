package com.ccw.controller;

import com.ccw.common.Result;
import com.ccw.entity.Likes;
import com.ccw.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;


    /**
     * 点赞和取消点赞
     * @author xixiw
     * @time 2024/5/27 💕 19:20
     */
    @PostMapping("/set")
    public Result set(@RequestBody Likes likes){
        likesService.set(likes);
        return Result.success();
    }
}
