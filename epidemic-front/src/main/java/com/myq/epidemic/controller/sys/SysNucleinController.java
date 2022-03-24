package com.myq.epidemic.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.entity.Nuclein;
import com.myq.epidemic.entity.Patient;
import com.myq.epidemic.model.vo.NucleinPageVO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic_sys.common.model.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/sys/nuclein")
public class SysNucleinController {

    private String prefix = "/sys/";

    // 核酸管理
    @RequestMapping("/manage.html")
    public String manageHtml (@RequestParam("patientId") String patientId, Model model) {
        String result = HttpClientUtil.doGet(Route.ADDRESS
                + "/patient/selectOne"
                + "?patientId="
                + patientId, null);
        ResponseVO vo = JSONObject.parseObject(result, ResponseVO.class);
        model.addAttribute("patient", vo.getData());
        return prefix + "nuclein";
    }

    // 分页数据
    @ResponseBody
    @RequestMapping("/data")
    public RespResult data (@RequestParam("page") int page,
                            @RequestParam("limit") int limit,
                            @RequestParam(value = "patientId", required = false, defaultValue = "") String patientId,
                            @RequestParam(value = "remarks", required = false, defaultValue = "") String remarks,
                            @RequestParam(value = "nucleinDate", required = false, defaultValue = "") String nucleinDate,
                            @RequestParam(value = "result", required = false) Integer result) {
//        Example example = new Example(Nuclein.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!nucleinDate.equals("")) {
//            criteria.andEqualTo("nucleinDate", nucleinDate);
//        }
//        if (result != null) {
//            criteria.andEqualTo("result", result);
//        }
//        if (!remarks.equals("")) {
//            criteria.andLike("remarks", "%" + remarks + "%");
//        }
//        PageHelper.startPage(page, limit).setOrderBy("id desc");
//        PageInfo<Nuclein> pageInfo = new PageInfo<>(nucleinMapper.selectByExample(example));
        NucleinPageVO vo = new NucleinPageVO();
        try {
            vo.setCurrent(page)
                    .setSize(limit)
                    .setRemarks(remarks)
                    .setNucleinDate(nucleinDate)
                    .setResult(result)
                    .setPatientId(Integer.valueOf(patientId));
        } catch (Exception e) {

        }
        String resultVo = HttpClientUtil.doPost(Route.ADDRESS + "/nuclein/selectPage", null, JSONObject.toJSONString(vo));
        ResponseVO responseVO = JSONObject.parseObject(resultVo, ResponseVO.class);
        NucleinPageVO pageVO = JSONObject.parseObject(responseVO.getData().toString(), NucleinPageVO.class);

        RespResult respResult = new RespResult();
        respResult.success(pageVO.getRecords(), pageVO.getTotal());
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

    // 添加
    @ResponseBody
    @RequestMapping("/add")
    public RespResult add (@RequestBody Nuclein nuclein) {
        String vo = HttpClientUtil.doPost(Route.ADDRESS + "/nuclein/add", null, JSONObject.toJSONString(nuclein));
        ResponseVO responseVO = JSONObject.parseObject(vo, ResponseVO.class);
//        nucleinMapper.insertSelective(nuclein);
        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

    // 编辑
    @ResponseBody
    @RequestMapping("/edit")
    public RespResult edit (@RequestBody Nuclein nuclein) {
        String vo = HttpClientUtil.doPut(Route.ADDRESS + "/nuclein/edit", null, JSONObject.toJSONString(nuclein));
        ResponseVO responseVO = JSONObject.parseObject(vo, ResponseVO.class);
//        nucleinMapper.updateByPrimaryKeySelective(nuclein);
        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

    // 删除
    @ResponseBody
    @RequestMapping("/delete")
    public RespResult delete (@RequestBody String id) {
        String vo = HttpClientUtil.doDelete(Route.ADDRESS + "/nuclein/delete"
                + "?id="
                + id, null);
        ResponseVO responseVO = JSONObject.parseObject(vo, ResponseVO.class);
//        nucleinMapper.deleteByPrimaryKey(id);
        RespResult respResult = new RespResult();
        respResult.setErrorMessage(responseVO.getMessage());
        return respResult;
    }

}
