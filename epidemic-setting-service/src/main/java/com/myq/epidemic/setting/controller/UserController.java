package com.myq.epidemic.setting.controller;


import com.myq.epidemic.setting.interfaces.UserInformationInterface;
import com.myq.epidemic.setting.model.dto.TokenDTO;
import com.myq.epidemic.setting.service.UserService;
import com.myq.epidemic.setting.model.dto.UserDTO;
import com.myq.epidemic.setting.model.dto.UserPageDTO;
import com.myq.epidemic.common.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author 毛一钦
 * @Date 2022/3/1 20:39
 **/
@RestController
public class UserController implements UserInformationInterface {

    @Autowired
    private UserService userService;

    @PostMapping("/user/selectPage")
    public ResponseVO userSelectPage(@RequestBody UserPageDTO param) {
        ResponseVO vo = this.userService.selectByPage(param);
        return vo;
    }

    @Override
    @PostMapping("/user/add")
    public ResponseVO userAdd(@RequestBody UserDTO param) {
        ResponseVO vo = this.userService.insertOne(param);
        return vo;
    }

    @Override
    @PutMapping("/user/edit")
    public ResponseVO userEdit(@RequestBody UserDTO param) {
        ResponseVO vo = this.userService.updateOne(param);
        return vo;
    }

    @DeleteMapping("/user/delete")
    public ResponseVO userDelete(String id) {
        ResponseVO vo = this.userService.deleteOne(id);
        return vo;
    }

    @Override
    @PostMapping("/user/one")
    public ResponseVO<TokenDTO> userSelectOne(@RequestBody TokenDTO param) {
        TokenDTO token = this.userService.selectOne(param);
        return ResponseVO.success(token);
    }

    @Override
    @GetMapping("/user/info/{userName}")
    public ResponseVO<TokenDTO> userSelectInfo(@PathVariable("userName") String userName) {
        TokenDTO info = this.userService.selectInfo(userName);
        return ResponseVO.success(info);
    }
}
