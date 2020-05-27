package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.entity.AddFriendList;

public interface AddFriendService {

    /**
     * 添加好友请求
     * @return
     */
    ServerResponse addFriendReq(AddFriendList addFriendList);

    /**
     * 处理添加好友请求
     * @return
     */
    ServerResponse handleAddFriend(Long addFriendId, Integer isReceive);

    /**
     * 添加请求列表
     * @param userId 当前用户id
     * @return
     */
    ServerResponse listAddFriendReq(Long userId);

}
