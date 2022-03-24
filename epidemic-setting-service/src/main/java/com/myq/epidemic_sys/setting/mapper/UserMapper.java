package com.myq.epidemic_sys.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.myq.epidemic_sys.setting.entity.User;
import org.apache.ibatis.annotations.Param;


/**
 * @Author 毛一钦
 * @Date 2022/2/8 16:17
 * @Description
 **/
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectByPage(IPage<User> obj, @Param("param") User user);

}
