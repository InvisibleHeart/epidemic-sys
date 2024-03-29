package com.myq.epidemic.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.constant.SessionConstant;
import com.myq.epidemic.entity.User;
import com.myq.epidemic.model.vo.UserPageVO;
import com.myq.epidemic.model.vo.UserVO;
import com.myq.epidemic.setting.interfaces.UserInformationInterface;
import com.myq.epidemic.setting.model.dto.TokenDTO;
import com.myq.epidemic.setting.model.dto.UserDTO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic.common.model.ResponseVO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    private String prefix = "/sys/";

    @Autowired
    private UserInformationInterface userInformationInterface;

    // 用户管理
    @RequestMapping("/manage.html")
    public String manageHtml () {
        return prefix + "user";
    }

    // 分页数据
    @ResponseBody
    @RequestMapping("/data")
    public RespResult manageData (@RequestParam("page") int page,
                                  @RequestParam("limit") int limit,
                                  @RequestParam(value = "name", required = false, defaultValue = "") String name,
                                  @RequestParam(value = "sex", required = false) Integer sex,
                                  @RequestParam(value = "role", required = false) Integer role) {
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (sex != null) {
//            criteria.andEqualTo("sex", sex);
//        }
//        if (role != null) {
//            criteria.andEqualTo("role", role);
//        }
//        if (!name.equals("")) {
//            criteria.andLike("name", "%" + name + "%");
//        }
//        PageHelper.startPage(page, limit).setOrderBy("id desc");
//        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectByExample(example));
        UserPageVO vo = new UserPageVO();
        try {
            vo.setCurrent(page)
                    .setSize(limit)
                    .setName(name)
                    .setSex(sex)
                    .setRole(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = HttpClientUtil.doPost(Route.ADDRESS + "/user/selectPage", null, JSONObject.toJSONString(vo));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        UserPageVO pageVO = JSONObject.parseObject(responseVO.getData().toString(), UserPageVO.class);

        RespResult respResult = new RespResult();
        respResult.success(pageVO.getRecords(), pageVO.getTotal());
        return respResult;
    }

    // 添加
    @ResponseBody
    @RequestMapping("/add")
    public RespResult add (@RequestBody User user) {

        RespResult respResult = new RespResult();
        String result = HttpClientUtil.doPost(Route.ADDRESS + "/user/add", null, JSONObject.toJSONString(user));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        respResult.setErrorMessage(responseVO.getMessage());
//        Example example = new Example(User.class);
//        example.createCriteria().andEqualTo("username", user.getUsername());
//        User u = userMapper.selectOneByExample(example);
//        if (u == null) {
//            userMapper.insertSelective(u);
//        } else {
//            respResult.error("操作失败：用户名已存在");
//        }
        return respResult;
    }

    // 编辑
    @ResponseBody
    @RequestMapping("/edit")
    public RespResult edit (@RequestBody User user) {
        String result = HttpClientUtil.doPut(Route.ADDRESS + "/user/edit", null, JSONObject.toJSONString(user));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
//        userMapper.updateByPrimaryKeySelective(user);
        return new RespResult();
    }

    // 删除
    @ResponseBody
    @RequestMapping("/delete")
    public RespResult delete (@RequestBody String id) {
        String result = HttpClientUtil.doDelete(Route.ADDRESS + "/user/delete"
                + "?id="
                + id, null);
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
//        userMapper.deleteByPrimaryKey(id);
        return new RespResult();
    }

    // 个人资料
    @RequestMapping("/personal.html")
    public ModelAndView personalHtml () {
        ResponseVO<TokenDTO> vo = this.userInformationInterface
                .userSelectInfo(String.valueOf(SecurityUtils.getSubject().getPrincipal()));
        ModelAndView vm = new ModelAndView();
        UserVO result = new UserVO();
        BeanUtils.copyProperties(vo.getData(), result);
        result.setSex((vo.getData().getSex() == 0) ? "女":"男");
        vm.addObject("user", result);
        vm.setViewName(prefix + "personal");
        return vm;
    }

    // 修改个人资料
    @ResponseBody
    @RequestMapping("/edit/personal")
    public RespResult editPersonal(@RequestBody User user) {
        RespResult respResult = new RespResult();
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        ResponseVO vo = this.userInformationInterface.userEdit(dto);
        //  退出登陆
        SecurityUtils.getSubject().logout();
        respResult.setErrorMessage(vo.getMessage());
        return respResult;
    }

}
