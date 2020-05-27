package com.negen.service;

import com.negen.common.ServerResponse;

public interface FriendListService {
    /**
     * 获取所有好友信息
     * @param userId
     * @return
     */
    ServerResponse listAllFriendInfo(Long userId);

    /**
     * 获取所有非好友信息
     */
    ServerResponse listAllUnFriendInfo(Long userId);

    /**
     * 删除好友
     * @param sendUserId
     * @param receiveUserId
     * @return
     */
    ServerResponse deleteFriend(Long sendUserId, Long receiveUserId);

}
