package com.hyzz.mapper;

import com.hyzz.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<User> {
    @Select("SELECT u.* FROM tb_user u JOIN tb_user_certification uc ON u.id = uc.uid WHERE uc.idcard = #{keys} OR uc.realname = #{keys}")
    User selectUserByUsernameOrIdCard(@Param("keys") String keys);

    @Update("UPDATE tb_user SET ${statusName} = #{status} WHERE id = #{id}")
    int changeUserStatusById(@Param(value = "statusName") String statusName,@Param(value = "status") Integer status,@Param(value = "id") Integer id);
}
