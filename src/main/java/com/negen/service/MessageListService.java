package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.entity.MessageList;

public interface MessageListService {
    /**
     * 获取十条聊天记录
     * @param sendUserId
     * @param receiveUserId
     * @return
     */
    ServerResponse get10Messages(Long sendUserId, Long receiveUserId);


    void saveMessage(MessageList messageList);

}
