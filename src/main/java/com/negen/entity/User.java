package com.negen.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author     ：Negen
 * @Date       ：Created in 16:31 2020/4/6
 * @Description：用户信息实体
 * @Modified By：
 * @Version: 1.0
 * 账号信息表
 * 	用户名
 * 	密码
 * 	性别
 * 	头像
 * 	是否在线
 */
@Entity
@Table(name = "tb_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String password;
    Integer sex;
    String avatar;
    Boolean isOnline = false;
}
