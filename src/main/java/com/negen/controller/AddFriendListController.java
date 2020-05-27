package com.negen.controller;

import com.negen.common.ServerResponse;
import com.negen.entity.AddFriendList;
import com.negen.service.AddFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Negen
 * @Date ：Created in 15:09 2020/4/17
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
@RestController
@RequestMapping("friend")
public class AddFriendListController {
    @Autowired
    AddFriendService addFriendService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    ServerResponse addFriend(@RequestBody AddFriendList addFriendList){
        return addFriendService.addFriendReq(addFriendList);
    }

    @RequestMapping(value = "add/list/{userId}", method = RequestMethod.GET)
    ServerResponse listFriend(@PathVariable Long userId){
        return addFriendService.listAddFriendReq(userId);
    }

    @RequestMapping(value = "add/list/handle", method = RequestMethod.POST)
    ServerResponse handleFriend(@RequestParam Long addFriendId,
                              @RequestParam Integer isReceive){
        return addFriendService.handleAddFriend(addFriendId, isReceive);
    }
}
