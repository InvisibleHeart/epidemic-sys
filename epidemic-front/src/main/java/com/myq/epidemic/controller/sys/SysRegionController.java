package com.myq.epidemic.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.entity.Region;
import com.myq.epidemic.model.vo.RegionPageVO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic.common.model.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/sys/region")
public class SysRegionController {

    private String prefix = "/sys/";

    // 地区管理
    @RequestMapping("/manage.html")
    public String manageHtml () {
        return prefix + "region";
    }

    // 分页数据
    @ResponseBody
    @RequestMapping("/data")
    public RespResult data (@RequestParam("page") int page,
                            @RequestParam("limit") int limit,
                            @RequestParam(value = "name", required = false, defaultValue = "") String name) {
//        Example example = new Example(Region.class);
//        if (!name.equals("")) {
//            example.createCriteria().andLike("name", "%" + name + "%");
//        }
//        PageHelper.startPage(page, limit).setOrderBy("id desc");
//        PageInfo<Region> pageInfo = new PageInfo<>(regionMapper.selectByExample(example));
        RegionPageVO vo = new RegionPageVO();
        try {
            vo.setCurrent(page)
                    .setSize(limit)
                    .setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = HttpClientUtil.doPost(Route.ADDRESS + "/region/selectPage", null, JSONObject.toJSONString(vo));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        RegionPageVO pageVO = JSONObject.parseObject(responseVO.getData().toString(), RegionPageVO.class);

        RespResult respResult = new RespResult();
        respResult.success(pageVO.getRecords(), pageVO.getTotal());
        return respResult;
    }

    // 添加
    @ResponseBody
    @RequestMapping("/add")
    public RespResult add (@RequestBody Region region) {
        String result = HttpClientUtil.doPost(Route.ADDRESS + "/region/add", null, JSONObject.toJSONString(region));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
//        regionMapper.insertSelective(region);
        return new RespResult();
    }

    // 编辑
    @ResponseBody
    @RequestMapping("/edit")
    public RespResult edit (@RequestBody Region region) {
        String result = HttpClientUtil.doPut(Route.ADDRESS + "/region/edit", null, JSONObject.toJSONString(region));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
//        regionMapper.updateByPrimaryKeySelective(region);
        return new RespResult();
    }

    // 删除
    @ResponseBody
    @RequestMapping("/delete")
    public RespResult delete (@RequestBody String id) {
        String result = HttpClientUtil.doDelete(Route.ADDRESS + "/region/delete"
                + "?id="
                + id, null);
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
//        regionMapper.deleteByPrimaryKey(id);
        return new RespResult();
    }


}
