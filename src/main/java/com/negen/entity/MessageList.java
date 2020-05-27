package com.negen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ：Negen
 * @Date ：Created in 17:05 2020/4/6
 * @Description：消息记录表
 * @Modified By：
 * @Version: 1.0
 * 消息记录表
 * 	发送人id
 * 	接受人id
 * 	消息内容
 * 	发送时间
 */
@Entity
@Table(name = "tb_message_list")
@Data
public class MessageList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sendUserId;
    Long receiveUserId;
    String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="UTC")
    Date sendTime;
}
