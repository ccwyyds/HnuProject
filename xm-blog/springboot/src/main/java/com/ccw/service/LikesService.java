package com.ccw.service;

import com.ccw.entity.Likes;

public interface LikesService  {
   void set(Likes likes);

   int selectByFidAndModule(Integer id, String value);

   Likes selectUserLikes(Integer fid ,String module);
}
