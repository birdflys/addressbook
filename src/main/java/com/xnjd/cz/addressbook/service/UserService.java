package com.xnjd.cz.addressbook.service;

import com.xnjd.cz.addressbook.entity.User;
import com.xnjd.cz.addressbook.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @Description:  通过 name,password 查询数据是否存在该 user
     * @return
     */
    public User getUser(Map map){
        User user = userMapper.getUser(map);
        System.out.println(" user 的值为： " + user);
        return user;
    }

    /**
     * @Description: 注册
     * @param user
     */
    public void register(User user){
        userMapper.insert(user);
    }

    /**
     * @Description: 通过用户名进行查找
     * @param name
     * @return
     */
    public User getName(String name){
        return userMapper.getName(name);
    }

    /**
     * @Description: 新增联系人
     * @param user
     */
    public void insertUserInfo (User user){
        userMapper.insertUserInfo(user);
    }
    /**
     * @Description: 查询某人的信息
     * @param name
     * @return
     */
    public User getUserInfo(String name){
        return userMapper.getUserInfo(name);
    }

    /**
     * @Description: 修改某人的信息
     * @param name
     * @return
     */
    public User updateUserInfo(String name){
        return userMapper.updateUserInfo(name);
    }

    /**
     * @Description: 删除某人的信息
     * @param name
     */
    public void deleteUserInfo (String name){
        userMapper.deleteUserInfo(name);
    }
}
