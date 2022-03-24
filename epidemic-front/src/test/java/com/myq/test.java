package com.myq;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.entity.Patient;
import com.myq.epidemic.model.vo.PatientPageVO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic_sys.common.model.ResponseVO;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    public void test() {
        String result = HttpClientUtil.doGet(Route.ADDRESS + "/patient/selectOne?patientId=" + 2, null);
        ResponseVO vo = JSONObject.parseObject(result, ResponseVO.class);
        Patient patient = JSONObject.parseObject(vo.getData().toString(), Patient.class);
        System.out.println(patient);
    }

    @Test
    public void Test01() {
        PatientPageVO vo = new PatientPageVO();
        vo.setName("123")
                .setSource("321")
                .setSex(1)
                .setStatus(1)
                .setRegionId(1)
                .setCrowd(1)
                .setSize(10)
                .setCurrent(1);

        String result = HttpClientUtil.doPost(Route.ADDRESS + "/patient/selectPage", null, JSONObject.toJSONString(vo));
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);
        PatientPageVO pageVO = JSONObject.parseObject(responseVO.getData().toString(), PatientPageVO.class);
        System.out.println(pageVO.toString());
    }
}
