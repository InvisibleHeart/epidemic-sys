package com.myq.epidemic.setting.interfaces;

import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.setting.model.dto.TokenDTO;
import com.myq.epidemic.setting.model.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("epidemic-setting-service")
public interface UserInformationInterface {

    @PostMapping("/user/one")
    ResponseVO<TokenDTO> userSelectOne(@RequestBody TokenDTO param);

    @GetMapping("/user/info/{userName}")
    ResponseVO<TokenDTO> userSelectInfo(@PathVariable("userName") String userName);

    @PutMapping("/user/edit")
    ResponseVO userEdit(@RequestBody UserDTO param);

    @PostMapping("/user/add")
    ResponseVO userAdd(@RequestBody UserDTO param);

}