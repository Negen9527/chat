package com.negen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：Negen
 * @Date ：Created in 17:10 2020/4/6
 * @Description：添加好友列表
 * @Modified By：
 * @Version: 1.0
 * 添加好友表
 * 	发送人id
 * 	接受人id
 * 	备注信息
 * 	发送时间
 * 	是否同意
 */
@Entity
@Table(name = "tb_add_friend_list")
@Data
public class AddFriendList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sendUserId;
    Long receiveUserId;
    String message;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="UTC")
    Date sendTime;
//    Boolean isReceive = false;
    Integer isReceive = 0;   //0：未处理  1：同意  2：拒绝

}
