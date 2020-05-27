package com.negen.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.negen.common.Constant;
import com.negen.common.ResponseEnum;
import com.negen.common.ServerResponse;
import com.negen.entity.User;
import com.negen.repository.FriendListRepository;
import com.negen.service.FriendListService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author ：Negen
 * @Date ：Created in 22:36 2020/4/7
 * @Description：好友列表业务类
 * @Modified By：
 * @Version: 1.0
 */
@Slf4j
@Service
public class FriendListServiceImpl implements FriendListService {
    @Autowired
    FriendListRepository friendListRepository;

    @Override
    public ServerResponse listAllFriendInfo(Long userId) {
        try {
            List<Object[]> friends = friendListRepository.selectAllFriendByUserId(userId);
            JSONArray friendInfoJsonArr = new JSONArray();
            friends.forEach(row -> {
                JSONObject friendInfo = new JSONObject();
                BigInteger id = (BigInteger) row[0];
                String avatar = (String) row[1];
                Boolean isOnline = (Boolean) row[2];
                Integer sex = (Integer) row[3];
                String userName = (String) row[5];
                String nickName = (String) row[6];
                friendInfo.put("id",id);
                friendInfo.put("avatar",avatar);
                friendInfo.put("isOnline",isOnline);
                friendInfo.put("sex",sex);
                friendInfo.put("userName",userName);
                friendInfo.put("nickName",nickName);
                friendInfoJsonArr.add(friendInfo);
            });
            return ServerResponse.getInstance().responseEnum(ResponseEnum.GET_SUCCESS)
                    .data(friendInfoJsonArr);
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_NEGEN + e.getMessage());
            return ServerResponse.getInstance()
                    .responseEnum(ResponseEnum.INNER_ERROR);
        }
    }

    @Override
    public ServerResponse listAllUnFriendInfo(Long userId) {
        try {
            List<Object[]> users = friendListRepository.selectAllUnFirendByUserId(userId);
            JSONArray unfriendInfoJsonArr = new JSONArray();
            users.forEach(row -> {
                JSONObject friendInfo = new JSONObject();
                BigInteger id = (BigInteger) row[0];
                String avatar = (String) row[1];
                Boolean isOnline = (Boolean) row[2];
                Integer sex = (Integer) row[3];
                String userName = (String) row[5];
                friendInfo.put("id",id);
                friendInfo.put("avatar",avatar);
                friendInfo.put("isOnline",isOnline);
                friendInfo.put("sex",sex);
                friendInfo.put("userName",userName);
                unfriendInfoJsonArr.add(friendInfo);
            });
            return ServerResponse.getInstance().responseEnum(ResponseEnum.GET_SUCCESS)
                    .data(unfriendInfoJsonArr);
        }catch (Exception e){
            log.info(Constant.TAG_NEGEN + e.getMessage());
            return ServerResponse.getInstance()
                    .responseEnum(ResponseEnum.INNER_ERROR);
        }
    }

    @Override
    public ServerResponse deleteFriend(Long sendUserId, Long receiveUserId) {
        try {

            friendListRepository.deleteFriend(sendUserId, receiveUserId);
            return ServerResponse.getInstance().responseEnum(ResponseEnum.UPDATE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_NEGEN + e.getMessage());
            return ServerResponse.getInstance()
                    .responseEnum(ResponseEnum.INNER_ERROR);
        }
    }
}
