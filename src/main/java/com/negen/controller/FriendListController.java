package com.negen.controller;

import com.negen.common.ServerResponse;
import com.negen.service.FriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Negen
 * @Date ：Created in 22:46 2020/4/7
 * @Description：好友列表控制类
 * @Modified By：
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "friend")
public class FriendListController {
    @Autowired
    FriendListService friendListService;

    /**
     * 获取好友列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    ServerResponse listAllFriend(@PathVariable Long userId){
        return friendListService.listAllFriendInfo(userId);
    }


    /**
     * 获取非好友列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/list/un/{userId}", method = RequestMethod.GET)
    ServerResponse listAllUnFriend(@PathVariable Long userId){
        return friendListService.listAllUnFriendInfo(userId);
    }


    /**
     * 删除好友
     * @param sendUserId
     * @param receiveUserId
     * @return
     */
    @RequestMapping(value = "/list/delete", method = RequestMethod.POST)
    ServerResponse deleteFriend(@RequestParam Long sendUserId,
                                @RequestParam Long receiveUserId){
        return friendListService.deleteFriend(sendUserId, receiveUserId);
    }

}
