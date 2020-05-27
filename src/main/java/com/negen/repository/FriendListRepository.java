package com.negen.repository;

import com.negen.entity.FriendList;
import com.negen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendListRepository extends JpaRepository<FriendList, Long> {

    String isFriendStr = "SELECT COUNT(1) FROM tb_friend_list WHERE (friend_user_id=?1 AND user_id=?2) " +
            "OR (friend_user_id=?2 AND user_id=?1) AND is_delete=0";
    @Query(value = isFriendStr, nativeQuery = true)
    int isFriend(Long sendUserId, Long receiveUserId);

    /**
     * 获取好友用户信息
     */
    String selectAllFriendByUserIdStr = "SELECT\n" +
            "    `tb_user`.`id`\n" +
            "    , `tb_user`.`avatar`\n" +
            "    , `tb_user`.`is_online`\n" +
            "    , `tb_user`.`sex`\n" +
            "    , `tb_user`.`password`\n" +
            "    , `tb_user`.`user_name`\n" +
            "    , `tb_friend_list`.`friend_nick_name`\n" +
            "FROM\n" +
            "    `db_chat`.`tb_friend_list`\n" +
            "    INNER JOIN `db_chat`.`tb_user` \n" +
            "        ON (`tb_friend_list`.`friend_user_id` = `tb_user`.`id`)\n" +
            "WHERE tb_friend_list.user_id = ?1";
    @Query(value = selectAllFriendByUserIdStr, nativeQuery = true)
    List<Object[]> selectAllFriendByUserId(Long userId);

    /**
     * 获取非好友用户信息
     */
    String selectAllUnFirendByUserIdStr = "SELECT " +
            "    `tb_user`.`id`\n" +
            "    , `tb_user`.`avatar`\n" +
            "    , `tb_user`.`is_online`\n" +
            "    , `tb_user`.`sex`\n" +
            "    , `tb_user`.`password`\n" +
            "    , `tb_user`.`user_name`\n" + " FROM tb_user WHERE id NOT IN (SELECT friend_user_id FROM tb_friend_list WHERE user_id=?1 AND is_delete=FALSE)  AND id != ?1";
    @Query(value = selectAllUnFirendByUserIdStr, nativeQuery = true)
    List<Object[]> selectAllUnFirendByUserId(Long userId);

    /**
     * 删除好友关系
     */
    String deleteFriendStr = "UPDATE tb_friend_list SET is_delete=0 WHERE (user_id=?1 AND friend_user_id=?2) OR (user_id=?2 AND friend_user_id=?1)";
    @Query(value = deleteFriendStr, nativeQuery = true)
    Integer deleteFriend(Long sendUserId, Long receiveUserId);
}
