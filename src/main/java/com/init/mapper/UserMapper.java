package com.init.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.init.model.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * 用户数据库操作
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT COUNT(*) FROM user where user_password = #{userAccount}")
    int selectCount2(String userAccount);

}




