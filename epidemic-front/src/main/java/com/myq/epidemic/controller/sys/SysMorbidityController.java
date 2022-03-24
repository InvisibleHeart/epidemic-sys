package com.myq.epidemic.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.entity.Morbidity;
import com.myq.epidemic.entity.Patient;
import com.myq.epidemic.model.vo.MorbidityPageVO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic_sys.common.model.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/morbidity")
public class SysMorbidityController {

    private String prefix = "/sys/";

    // 发病管理
    @RequestMapping("/manage.html")
    public String manageHtml (@RequestParam("patientId") int patientId, Model model) {
        String result = HttpClientUtil.doGet(Route.ADDRESS
                + "/patient/selectOne"
                + "?patientId="
                + patientId, null);
        ResponseVO vo = JSONObject.parseObject(result, ResponseVO.class);
        model.addAttribute("patient", vo.getData());
        return prefix + "morbidity";
    }

    // 分页数据
    @ResponseBody
    @RequestMapping("/data")
    public RespResult data (@RequestParam("page") int page,
                            @RequestParam("limit") int limit,
                            @RequestParam(value = "patientId", required = false, defaultValue = "") String patientId,
                            @RequestParam(value = "creatDate", required = false, defaultValue = "") String creatDate,
                            @RequestParam(value = "remarks", required = false, defaultValue = "") String remarks,
                            @RequestParam(value = "situationCon", required = false, defaultValue = "") String situationCon) {

        MorbidityPageVO vo = new MorbidityPageVO();
        try {
            vo.setCurrent(page)
                    .setSize(limit)
                    .setCreatDate(creatDate)
                    .setRemarks(remarks)
                    .setSituationCon(situationCon)
                    .setPatientId(patientId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String resultVo = HttpClientUtil.doPost(Route.ADDRESS + "/morbidity/selectByPage", null, JSONObject.toJSONString(vo));
        ResponseVO responseVO = JSONObject.parseObject(resultVo, ResponseVO.class);
        MorbidityPageVO pageVO = JSONObject.parseObject(responseVO.getData().toString(), MorbidityPageVO.class);

        RespResult respResult = new RespResult();
        respResult.success(pageVO.getRecords(), pageVO.getTotal());
        return respResult;
    }

    // 添加
    @ResponseBody
    @RequestMapping("/add")
    public RespResult add (@RequestBody Morbidity morbidity) {
        String resultVo = HttpClientUtil.doPost(Route.ADDRESS + "/morbidity/add", null, JSONObject.toJSONString(morbidity));
        ResponseVO responseVO = JSONObject.parseObject(resultVo, ResponseVO.class);

        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

    // 编辑
    @ResponseBody
    @RequestMapping("/edit")
    public RespResult edit (@RequestBody Morbidity morbidity) {
        String resultVo = HttpClientUtil.doPut(Route.ADDRESS + "/morbidity/edit", null, JSONObject.toJSONString(morbidity));
        ResponseVO responseVO = JSONObject.parseObject(resultVo, ResponseVO.class);

        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

    // 删除
    @ResponseBody
    @RequestMapping("/delete")
    public RespResult delete (@RequestBody String id) {
        String resultVo = HttpClientUtil.doDelete(Route.ADDRESS + "/morbidity/delete"
                + "?id="
                + id, null);
        ResponseVO responseVO = JSONObject.parseObject(resultVo, ResponseVO.class);

        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

}
