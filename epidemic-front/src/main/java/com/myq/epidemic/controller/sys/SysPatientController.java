package com.myq.epidemic.controller.sys;


import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.entity.Patient;
import com.myq.epidemic.entity.Region;
import com.myq.epidemic.model.vo.PatientPageVO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic.common.model.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
@RequestMapping("/sys/patient")
public class SysPatientController {

    private String prefix = "/sys/";

    // 患者管理
    @RequestMapping("/manage.html")
    public String manageHtml (Model model) {
        String result = HttpClientUtil.doGet(Route.ADDRESS + "/region/queryAll", null);
        ResponseVO<List> vo = JSONObject.parseObject(result, ResponseVO.class);
        List<Region> regionList = vo.getData();
        model.addAttribute("regionList", regionList);
        return prefix + "patient";
    }

    // 分页数据
    @ResponseBody
    @RequestMapping("/data")
    public RespResult data (@RequestParam("page") int page,
                            @RequestParam("limit") int limit,
                            @RequestParam(value = "name", required = false, defaultValue = "") String name,
                            @RequestParam(value = "source", required = false, defaultValue = "") String source,
                            @RequestParam(value = "sex", required = false) Integer sex,
                            @RequestParam(value = "status", required = false) Integer status,
                            @RequestParam(value = "regionId", required = false) Integer regionId,
                            @RequestParam(value = "crowd", required = false) Integer crowd) {

        PatientPageVO vo = new PatientPageVO();
        try {
            vo.setName(name)
              .setSource(source)
              .setSex(sex)
              .setStatus(status)
              .setRegionId(regionId)
              .setCrowd(crowd)
              .setSize(limit)
              .setCurrent(page);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = HttpClientUtil.doPost(Route.ADDRESS + "/patient/selectPage", null, JSONObject.toJSONString(vo));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        PatientPageVO pageVO = JSONObject.parseObject(responseVO.getData().toString(), PatientPageVO.class);

        RespResult respResult = new RespResult();
        respResult.success(pageVO.getRecords(), pageVO.getTotal());
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

    // 添加
    @ResponseBody
    @RequestMapping("/add")
    public RespResult add (@RequestBody Patient patient) {
        String result = HttpClientUtil.doPost(Route.ADDRESS + "/patient/add", null, JSONObject.toJSONString(patient));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage() == null ? null : responseVO.getMessage());
//        patient.setUpdateDate(new Date());
//        patientMapper.insertSelective(patient);
//        // 地区人数 + 1
//        regionMapper.updateAddCount(patient.getRegionId());
        // TODO: 2022/2/23  完善前端返回报文
        return respResult;
    }

    // 编辑
    @ResponseBody
    @RequestMapping("/edit")
    public RespResult edit (@RequestBody Patient patient) {
        String result = HttpClientUtil.doPut(Route.ADDRESS + "/patient/edit", null, JSONObject.toJSONString(patient));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage());
//        patientMapper.updateByPrimaryKeySelective(patient);
        return respResult;
    }

    // 删除
    @ResponseBody
    @RequestMapping("/delete")
    public RespResult delete (@RequestBody String id) {
        String result = HttpClientUtil.doDelete(Route.ADDRESS + "/patient/delete"
                + "?id="
                + id, null);
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage() == null ? null : responseVO.getMessage() );
//        patientMapper.deleteByPrimaryKey(patient.getId());
        // 地区人数 - 1
//        regionMapper.updateDelCount(patient.getRegionId());
        return respResult;
    }

}
