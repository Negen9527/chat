package com.negen.service.impl;

import com.negen.common.Constant;
import com.negen.common.ResponseEnum;
import com.negen.common.ServerResponse;
import com.negen.entity.MessageList;
import com.negen.repository.MessageListRepository;
import com.negen.service.MessageListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Negen
 * @Date ：Created in 21:16 2020/4/8
 * @Description：消息记录业务层
 * @Modified By：
 * @Version: 1.0
 */
@Slf4j
@Service
public class MessageListServiceImpl implements MessageListService {
    @Autowired
    MessageListRepository messageListRepository;
    @Override
    public ServerResponse get10Messages(Long sendUserId, Long receiveUserId) {
        try {

            //查询条件
            Specification specification = new Specification() {
                @Override
                public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    List<Predicate> predicates2 = new ArrayList<>();
                    predicates.add(criteriaBuilder.equal(root.get("sendUserId"),sendUserId));
                    predicates.add(criteriaBuilder.equal(root.get("receiveUserId"),receiveUserId));

                    predicates2.add(criteriaBuilder.equal(root.get("sendUserId"),receiveUserId));
                    predicates2.add(criteriaBuilder.equal(root.get("receiveUserId"),sendUserId));
                    Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                    predicate = criteriaBuilder.or(predicate, criteriaBuilder.and(predicates2.toArray(new Predicate[predicates.size()])));
                    return predicate;
                }
            };
            Sort orders = Sort.by(Sort.Direction.DESC,"sendTime");
            MessageList messageList = new MessageList();
            messageList.setSendUserId(sendUserId);
            messageList.setReceiveUserId(receiveUserId);
            Example<MessageList> example = Example.of(messageList);
            PageRequest pageRequest = PageRequest.of(0,10, orders);
            Page<MessageList> page = messageListRepository.findAll(specification, pageRequest);
            List<MessageList> messageLists = page.getContent();
            return ServerResponse.getInstance().responseEnum(ResponseEnum.GET_SUCCESS).data(messageLists);
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_NEGEN + e.getMessage());
            return ServerResponse.getInstance()
                    .responseEnum(ResponseEnum.INNER_ERROR);
        }
    }


    /**
     * 保存消息记录
     * @param messageList
     */
    @Override
    public void saveMessage(MessageList messageList) {
        try {
            messageListRepository.save(messageList);
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_NEGEN + e.getMessage());
        }
    }
}
