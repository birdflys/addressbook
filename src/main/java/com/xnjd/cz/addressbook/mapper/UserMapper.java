package com.xnjd.cz.addressbook.mapper;

import com.xnjd.cz.addressbook.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    /**
     * @Description:用户登陆
     * @return  User
     */
    User getUser(Map map);

    /**
     * @Description: 通过用户名进行查找
     * @param name
     * @return
     */
    User getName(String name);


    /**
     * 注册
     * @param user
     */
    void insert (User user);

    /**
     * 新增联系人
     * @param user
     */
    void insertUserInfo (User user);

    /**
     * 查询某人的信息
     * @param name
     * @return
     */
    User getUserInfo (String name);

    /**
     * 修改某人的信息
     * @param name
     * @return
     */
    User updateUserInfo (String name);

    /**
     * 删除某人的信息
     * @param name
     */
    void deleteUserInfo (String name);

}
