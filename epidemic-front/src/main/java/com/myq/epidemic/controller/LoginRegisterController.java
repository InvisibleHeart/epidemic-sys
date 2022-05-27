package com.myq.epidemic.controller;

import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.constant.SessionConstant;
import com.myq.epidemic.entity.User;
import com.myq.epidemic.setting.interfaces.UserInformationInterface;
import com.myq.epidemic.setting.model.dto.TokenDTO;
import com.myq.epidemic.setting.model.dto.UserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginRegisterController {

    @Autowired
    private UserInformationInterface userInformationInterface;

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

    // 注册
    @ResponseBody
    @PostMapping("/register")
    public RespResult register(@RequestBody User user){
        RespResult respResult = new RespResult();
        UserDTO dto = new UserDTO();
        try {
            BeanUtils.copyProperties(user, dto);
            TokenDTO tokenDTO = new TokenDTO();
            tokenDTO.setUserName(user.getUsername());
            tokenDTO.setPassWord(user.getPassword());
            ResponseVO<TokenDTO> vo = userInformationInterface.userSelectOne(tokenDTO);
            if (vo.getData() != null) {
                respResult.error("注册失败：该用户名已注册");
                return respResult;
            }
            userInformationInterface.userAdd(dto);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return respResult;
    }

    // 登录
    @ResponseBody
    @RequestMapping("/login")
    public RespResult login(@RequestBody TokenDTO token){
        RespResult respResult = new RespResult();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(token.getUserName(), token.getPassWord()));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            respResult.error(e.getMessage());
        }
        return respResult;
    }

    // 登出
    @RequestMapping("/login.out")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";
    }
}
