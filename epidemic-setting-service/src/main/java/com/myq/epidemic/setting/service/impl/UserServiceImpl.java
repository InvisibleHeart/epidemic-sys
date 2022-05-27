package com.myq.epidemic.setting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myq.epidemic.setting.entity.User;
import com.myq.epidemic.setting.mapper.UserMapper;
import com.myq.epidemic.setting.model.dto.TokenDTO;
import com.myq.epidemic.setting.model.dto.UserDTO;
import com.myq.epidemic.setting.model.dto.UserPageDTO;
import com.myq.epidemic.setting.model.vo.UserPageVO;
import com.myq.epidemic.setting.service.UserService;
import com.myq.epidemic.common.enums.PageResponseEnum;
import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.common.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;


/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-02-08 16:14:28
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Cacheable(value = "user")
    public ResponseVO selectByPage(UserPageDTO dto) {
        User user = new User();
        try {
            user.setName(dto.getName());
            user.setSex(dto.getSex());
            user.setRole(dto.getRole());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        IPage<User> page = new Page<>(dto.getCurrent(), dto.getSize(), dto.getTotal());
        page = this.baseMapper.selectByPage(page, user);
        UserPageVO vo = new UserPageVO();
        try {
            vo.setCurrent(page.getCurrent())
                    .setSize(page.getSize())
                    .setTotal(page.getTotal())
                    .setPage(page.getPages())
                    .setRecords(page.getRecords());
        } catch (Exception e) {
            StringUtil.errorToString(e);
        }
        return ResponseVO.success(vo);
    }

    @Override
    @CacheEvict(value = "user")
    public ResponseVO insertOne(UserDTO dto) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", dto.getName())
                .or()
                .eq("email", dto.getEmail());
        List<User> userList = this.baseMapper.selectList(userQueryWrapper);
        if (userList.isEmpty()) {
            this.baseMapper.insert(dto);
            return ResponseVO.success(null);
        }
        return ResponseVO.newInstance(PageResponseEnum.PAGE_ERR,"录入有误,请重新录入",null);
    }

    @Override
    @CacheEvict(value = "user")
    public ResponseVO updateOne(UserDTO dto) {
        this.baseMapper.updateId(dto);
        return ResponseVO.success(null);
    }

    @Override
    @CacheEvict(value = "user")
    public ResponseVO deleteOne(String param) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", param);
        this.baseMapper.delete(userQueryWrapper);
        return ResponseVO.success(null);
    }

    @Override
    public TokenDTO selectOne(TokenDTO dto) {
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        lambda.eq(!StringUtil.isEmpty(dto.getUserName()), User::getUsername, dto.getUserName());
        User result = this.baseMapper.selectOne(lambda);
        dto.setUserName(result.getUsername());
        dto.setPassWord(result.getPassword());
        return dto;
    }

    @Override
    public TokenDTO selectInfo(String userName) {
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        lambda.eq(!StringUtil.isEmpty(userName), User::getUsername, userName);
        TokenDTO dto = new TokenDTO();
        User result = this.baseMapper.selectOne(lambda);
        BeanUtils.copyProperties(result, dto);
        dto.setUserName(result.getUsername());
        return dto;
    }


}
