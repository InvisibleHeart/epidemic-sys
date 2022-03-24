package com.myq.epidemic_sys.setting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myq.epidemic_sys.common.enums.PageResponseEnum;
import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.common.utils.StringUtil;
import com.myq.epidemic_sys.setting.entity.User;
import com.myq.epidemic_sys.setting.mapper.UserMapper;
import com.myq.epidemic_sys.setting.model.dto.UserDTO;
import com.myq.epidemic_sys.setting.model.dto.UserPageDTO;
import com.myq.epidemic_sys.setting.model.vo.UserPageVO;
import com.myq.epidemic_sys.setting.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.annotations.Cacheable;

import java.time.LocalDateTime;
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
        // TODO: 2022/3/2 校验一下
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", dto.getId());
        this.baseMapper.update(dto, userQueryWrapper);
        return null;
    }

    @Override
    @CacheEvict(value = "user")
    public ResponseVO deleteOne(String param) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", param);
        this.baseMapper.delete(userQueryWrapper);
        return ResponseVO.success(null);
    }


}
