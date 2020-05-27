package com.negen.controller;

import com.negen.common.ServerResponse;
import com.negen.service.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Negen
 * @Date ：Created in 21:24 2020/4/8
 * @Description：消息记录控制类
 * @Modified By：
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "message")
public class MessageListController {
    @Autowired
    MessageListService messageListService;

    /**
     *
     * @param sid 发送信息id
     * @param rid 获取信息id
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ServerResponse get10message(@RequestParam("sid") Long sid
            , @RequestParam("rid") Long rid){
        return messageListService.get10Messages(sid, rid);
    }
}
