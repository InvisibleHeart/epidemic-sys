package com.myq.epidemic_sys.setting.controller;


import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.model.dto.UserDTO;
import com.myq.epidemic_sys.setting.model.dto.UserPageDTO;
import com.myq.epidemic_sys.setting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 毛一钦
 * @Date 2022/3/1 20:39
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/selectPage")
    public ResponseVO userSelectPage(@RequestBody UserPageDTO param) {
        ResponseVO vo = this.userService.selectByPage(param);
        return vo;
    }

    @PostMapping("/user/add")
    public ResponseVO userAdd(@RequestBody UserDTO param) {
        ResponseVO vo = this.userService.insertOne(param);
        return vo;
    }

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

}
