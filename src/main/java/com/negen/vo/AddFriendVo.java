package com.negen.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ：Negen
 * @Date ：Created in 18:58 2020/5/11
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
@Data
public class AddFriendVo {
    Integer id;
    Date sendTime;
    String message;
    String avatar;
    Integer sex;
    String userName;
}
