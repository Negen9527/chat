package com.negen.repository;

import com.negen.entity.MessageList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author ：Negen
 * @Date ：Created in 21:02 2020/4/8
 * @Description：
 * @Modified By：
 * @Version: 1.0
 */
public interface MessageListRepository extends JpaRepository<MessageList, Long>, JpaSpecificationExecutor {
}
