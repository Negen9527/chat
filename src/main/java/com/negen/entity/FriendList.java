package com.negen.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ：Negen
 * @Date ：Created in 17:02 2020/4/6
 * @Description：好友列表
 * @Modified By：
 * @Version: 1.0
 * 好友列表
 * 	用户id
 * 	好友id
 * 	好友昵称
 * 	是否删除
 */
@Entity
@Table(name = "tb_friend_list")
@Data
public class FriendList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long friendUserId;
    String friendNickName;
    Boolean isDelete = false;
}
