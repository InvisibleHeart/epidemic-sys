package com.myq.epidemic_sys.setting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.entity.User;
import com.myq.epidemic_sys.setting.model.dto.UserDTO;
import com.myq.epidemic_sys.setting.model.dto.UserPageDTO;
import com.myq.epidemic_sys.setting.model.vo.UserPageVO;

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

}
