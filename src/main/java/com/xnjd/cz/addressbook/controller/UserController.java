package com.xnjd.cz.addressbook.controller;

import com.xnjd.cz.addressbook.entity.User;
import com.xnjd.cz.addressbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static com.xnjd.cz.addressbook.constant.PageConstant.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Description: 进入登陆页面
     * @return
     */
    @GetMapping("/")
    public  String longIndex(){
        return LOGIN;
    }

    /**
     * @Description:    用户登陆
     * @param name
     * @param password
     * @param session
     * @param attributes
     * @return
     */
    @RequestMapping("/login")
    public String userlogin (@RequestParam String name,
                         @RequestParam String password,
                         HttpSession session,
                         RedirectAttributes attributes){
        // 判断用户名是否为空
        boolean checkName=(null==name||"".equals(name));
        // 判断密码是否为空
        boolean checkPassord=(null==password||"".equals(password));

        if(checkName||checkPassord){
            attributes.addFlashAttribute("nullNameAndPassword","用户名或密码不能为空");
            return REDIRECT;
        }

        // 在数据库中查找
        Map map = new HashMap();
        map.put("name",name);
        map.put("password",password);
        User user = userService.getUser(map);
        if (user == null || password == null){
            attributes.addFlashAttribute("message","用户名或者密码错误");
            return REDIRECT;
        }
        session.setAttribute("user" ,user);
        return INDEX;
    }

    /**
     * @Description: 用户注册信息
     * @param users
     * @param attributes
     * @return
     */
    @RequestMapping("/regist")
    public String register(User users,RedirectAttributes attributes){
        String name = users.getName();
        User user = userService.getName(name);
        if (user != null){
            attributes.addFlashAttribute("mess","该用户名已被注册，请重新注册");
            return REDIRECT;
        }
        userService.register(user);
        return INDEX;
    }

    /**
     * @Description:  进入注册页面
     * @param:
     * @return:String
     */
    @RequestMapping("/toRegist")
    public String insert() {
        return REGIST;
    }


    /**
     * 修改某人的信息
     * @param name
     */
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public User updateUserInfo(String name){
        return userService.updateUserInfo(name);
    }

    /**
     * 删除某人的信息
     * @param name
     */
    @RequestMapping("/deleteUserInfo")
    @ResponseBody
    public void deleteUserInfo(String name){
        userService.deleteUserInfo(name);
    }

    /**
     * 查询某人的信息
     * @param name
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(String name){
        return userService.getUserInfo(name);
    }

    /**
     * 新增联系人
     * @param user
     */
    @RequestMapping("/insertUserInfo")
    @ResponseBody
    public void insertUserInfo(User user){
        userService.insertUserInfo(user);
    }

}
