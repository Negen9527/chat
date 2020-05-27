package com.negen.repository;

import com.negen.entity.AddFriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddFriendListRepository extends JpaRepository<AddFriendList, Long> {

    AddFriendList findBySendUserIdAndReceiveUserIdAndIsReceive(Long sendUserId,Long receiveUserId, Integer isReceive);

    List<AddFriendList> findByReceiveUserIdAndIsReceiveOrderBySendTimeDesc(Long userId, Integer isReceive);

    String selectByReceiveUserIdAndIsReceiveOrderBySendTimeDescStr = "SELECT\n" +
            "    `tb_user`.`user_name`\n" +
            "    , `tb_user`.`sex`\n" +
            "    , `tb_user`.`avatar`\n" +
            "    , `tb_add_friend_list`.`message`\n" +
            "    , `tb_add_friend_list`.`is_receive`\n" +
            "    , `tb_add_friend_list`.`send_time`\n" +
            "    , `tb_add_friend_list`.`id`\n" +
            "FROM\n" +
            "    `db_chat`.`tb_user`\n" +
            "    INNER JOIN `db_chat`.`tb_add_friend_list` \n" +
            "        ON (`tb_user`.`id` = `tb_add_friend_list`.`send_user_id`)\n" +
            "WHERE `tb_add_friend_list`.`receive_user_id` = ?1 AND `tb_add_friend_list`.`is_receive` IS FALSE \n" +
            "ORDER BY `tb_add_friend_list`.`send_time` DESC;";
    @Query(value = selectByReceiveUserIdAndIsReceiveOrderBySendTimeDescStr, nativeQuery=true)
    List<Object[]> selectByReceiveUserIdAndIsReceiveOrderBySendTimeDesc(Long userId);
}
