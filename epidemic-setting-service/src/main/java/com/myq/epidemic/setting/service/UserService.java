package com.myq.epidemic.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myq.epidemic.setting.entity.User;
import com.myq.epidemic.setting.model.dto.TokenDTO;
import com.myq.epidemic.setting.model.dto.UserDTO;
import com.myq.epidemic.setting.model.dto.UserPageDTO;
import com.myq.epidemic.common.model.ResponseVO;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 16:14:28
 */
public interface UserService extends IService<User> {

    ResponseVO selectByPage(UserPageDTO dto);

    ResponseVO insertOne(UserDTO dto);

    ResponseVO updateOne(UserDTO dto);

    ResponseVO deleteOne(String param);

    TokenDTO selectOne(TokenDTO dto);

    TokenDTO selectInfo(String userName);
}
