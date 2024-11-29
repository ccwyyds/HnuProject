package com.ccw.service;

import com.ccw.entity.Collect;

public interface CollectService {
    void set(Collect collect);
    Collect selectUserCollect(Integer fid, String module);
    int selectByFidAndModule(Integer fid, String module);
}
