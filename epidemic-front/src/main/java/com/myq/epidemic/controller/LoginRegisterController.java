package com.myq.epidemic.controller;

import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.constant.SessionConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginRegisterController {

    // 注册
    @RequestMapping("/register.html")
    public String registerHtml () {
        return "/register";
    }

    // 登录
    @RequestMapping("/login.html")
    public String loginHtml() {
        return "/login";
    }

//    // 注册
//    @ResponseBody
//    @RequestMapping("/register")
//    public RespResult register(@RequestBody User user){
//        RespResult respResult = new RespResult();
//        Example example = new Example(User.class);
//        example.createCriteria().andEqualTo("username", user.getUsername());
//        User u = userMapper.selectOneByExample(example);
//        if (u == null) {
//            userMapper.insertSelective(user);
//        } else {
//            respResult.error("注册失败：该用户名已注册");
//        }
//        return respResult;
//    }
//
//    // 登录
//    @ResponseBody
//    @RequestMapping("/login")
//    public RespResult login(@RequestBody User user, HttpSession session){
//        RespResult respResult = new RespResult();
//        Example example = new Example(User.class);
//        example.createCriteria().andEqualTo("username", user.getUsername());
//        User u = userMapper.selectOneByExample(example);
//        if (u == null) {
//            respResult.error("登陆失败：用户名不存在");
//        } else {
//            if (!u.getPassword().equals(user.getPassword())) {
//                respResult.error("登陆失败：密码错误");
//            } else {
//                respResult.setData(u);
//                session.setAttribute(SessionConstant.KEY_USER, u);
//            }
//        }
//        return respResult;
//    }

    // 登出
    @RequestMapping("/login.out")
    public String loginOut(HttpSession session) {
        session.removeAttribute(SessionConstant.KEY_USER);
        return "/login";
    }
}
