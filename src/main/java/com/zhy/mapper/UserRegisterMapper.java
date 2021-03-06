package com.zhy.mapper;

import com.zhy.model.register.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author: zhangocean
 * @Date: Created in 12:26 2018/1/26
 * Describe: 处理用户登录注册的数据库操作信息
 */
@Repository
@Mapper
public interface UserRegisterMapper {

    @Insert("insert into user(phone, username, password, gender, obey) " +
            "values(#{phone}, #{username}, #{password}, #{gender}, #{obey})")
    int insert(User user);

    @Update("update user set username=#{username},gender=#{gender},company=#{company},profession=#{profession},introduce=#{introduce} where phone=#{phone}")
    void updateUserInfo(User user);

    @Insert("insert into user_role(User_id, Role_id) values (#{userId}, #{roleId})")
    void insertRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);

    @Select("select * from user where phone=#{phone}")
    User selectByPhone(@Param("phone") String phone);

    @Select("select * from user where phone=#{phone} and password=#{password}")
    User selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    @Select("select u.id from user u where phone=#{phone}")
    int selectUserIdByPhone(@Param("phone") String phone);

    @Select("select username from user where phone=#{phone}")
    String getUserNameByPhone(@Param("phone") String phone);

    @Select("select phone from user where username=#{userName}")
    String getPhoneByUserName(@Param("userName") String userName);

    @Select("select * from user where phone=#{phone}")
    User getUserInfoByPhone(@Param("phone") String phone);
}
