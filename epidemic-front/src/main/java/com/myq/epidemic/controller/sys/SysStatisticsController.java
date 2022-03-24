package com.myq.epidemic.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.RespResult;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.model.vo.StatisticsInfectionDegreeVO;
import com.myq.epidemic.model.vo.StatisticsVO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic_sys.common.model.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/statistics")
public class SysStatisticsController {

    private String prefix = "/sys/";

    // 统计图表
    @RequestMapping("/manage.html")
    public String statisticsHtml () {
        return prefix + "statistics";
    }

    // 统计数据 - 人群
    @ResponseBody
    @RequestMapping("/crowd/data")
    public RespResult crowdData () {

        String result = HttpClientUtil.doGet(Route.ADDRESS + "/statistics/selectByCrowdStatistics", null);
        ResponseVO vo = JSONObject.parseObject(result, ResponseVO.class);
        // 饼图数据
        List<StatisticsVO> statisticsList = JSONObject.parseArray(vo.getData().toString(), StatisticsVO.class);
        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();

        for (StatisticsVO statistics : statisticsList) {
            if (statistics.getName().equals("0")) {
                statistics.setName("儿童");
            }
            if (statistics.getName().equals("1")) {
                statistics.setName("少年");
            }
            if (statistics.getName().equals("2")) {
                statistics.setName("青年");
            }
            if (statistics.getName().equals("3")) {
                statistics.setName("中年");
            }
            if (statistics.getName().equals("4")) {
                statistics.setName("老年");
            }
            nameList.add(statistics.getName());
            valueList.add(statistics.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 统计数据 - 地区
    @ResponseBody
    @RequestMapping("/region/data")
    public RespResult regionData () {
        String result = HttpClientUtil.doGet(Route.ADDRESS + "/statistics/selectByRegionStatistics", null);
        ResponseVO vo = JSONObject.parseObject(result, ResponseVO.class);
        // 饼图数据
        List<StatisticsVO> statisticsList = JSONObject.parseArray(vo.getData().toString(), StatisticsVO.class);

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();

        for (StatisticsVO statistics : statisticsList) {
            nameList.add(statistics.getName());
            valueList.add(statistics.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 统计数据 - 感染程度
    @ResponseBody
    @RequestMapping("/status/data")
    public RespResult statusData () {
        String result = HttpClientUtil.doGet(Route.ADDRESS + "/statistics/selectByStatusStatistics", null);
        ResponseVO vo = JSONObject.parseObject(result, ResponseVO.class);
        // 饼图数据
        List<StatisticsVO> statisticsList = JSONObject.parseArray(vo.getData().toString(), StatisticsVO.class);

        // 柱图数据
        List<String> nameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();

        for (StatisticsVO statistics : statisticsList) {
            if (statistics.getName().equals("0")) {
                statistics.setName("密切接触者");
            }
            if (statistics.getName().equals("1")) {
                statistics.setName("受感染者");
            }
            if (statistics.getName().equals("2")) {
                statistics.setName("危重症病人");
            }
            if (statistics.getName().equals("3")) {
                statistics.setName("死亡者");
            }
            if (statistics.getName().equals("4")) {
                statistics.setName("治愈者");
            }
            if (statistics.getName().equals("5")) {
                statistics.setName("正常");
            }
            nameList.add(statistics.getName());
            valueList.add(statistics.getValue());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("statisticsList", statisticsList);
        data.put("nameList", nameList);
        data.put("valueList", valueList);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

    // 统计数据 - 感染程度对比
    @ResponseBody
    @RequestMapping("/status/data2")
    public RespResult statusData2 () {
        String result = HttpClientUtil.doGet(Route.ADDRESS + "/statistics/infectionDegree", null);
        ResponseVO vo = JSONObject.parseObject(result, ResponseVO.class);
        StatisticsInfectionDegreeVO parseObject =
                JSONObject.parseObject(vo.getData().toString(), StatisticsInfectionDegreeVO.class);
        // 日期数据
        List<String> dateList = parseObject.getDateList();
        // 初始化感染程度数据
        String datas [][] = new String[dateList.size()][7];
        for (int i=0; i<datas.length; i++) {
            for (int k=0; k<datas[i].length; k++) {
                datas[i][k] = "0";
            }
        }
        // 日期对应下标map
        Map<String, Integer> dateMap = new HashMap<>();
        for (int i = 0; i<dateList.size(); i++) {
            datas[i][6] = dateList.get(i);
            dateMap.put(dateList.get(i), i);
        }
        List<StatisticsVO> statisticsList =
                JSONObject.parseArray(parseObject.getStatisticsList().toString(), StatisticsVO.class);
        for (StatisticsVO statistics : statisticsList) {
            int index = dateMap.get(statistics.getDate());
            if (statistics.getName().equals("0")) {
                datas[index][0] = statistics.getValue().toString();
            }
            if (statistics.getName().equals("1")) {
                datas[index][1] = statistics.getValue().toString();
            }
            if (statistics.getName().equals("2")) {
                datas[index][2] = statistics.getValue().toString();
            }
            if (statistics.getName().equals("3")) {
                datas[index][3] = statistics.getValue().toString();
            }
            if (statistics.getName().equals("4")) {
                datas[index][4] = statistics.getValue().toString();
            }
            if (statistics.getName().equals("5")) {
                datas[index][5] = statistics.getValue().toString();
            }
        }

        List<Integer> data1 = new ArrayList<>(); // 密切接触者
        List<Integer> data2 = new ArrayList<>(); // 受感染者
        List<Integer> data3 = new ArrayList<>(); // 危重症病人
        List<Integer> data4 = new ArrayList<>(); // 死亡者
        List<Integer> data5 = new ArrayList<>(); // 治愈者
        List<Integer> data6 = new ArrayList<>(); // 正常

        for (int i=0; i<datas.length; i++) {
            for (int k=0; k<datas[i].length - 1; k++) {
                if (k == 0) {
                    data1.add(Integer.valueOf(datas[i][k]));
                }
                if (k == 1) {
                    data2.add(Integer.valueOf(datas[i][k]));
                }
                if (k == 2) {
                    data3.add(Integer.valueOf(datas[i][k]));
                }
                if (k == 3) {
                    data4.add(Integer.valueOf(datas[i][k]));
                }
                if (k == 4) {
                    data5.add(Integer.valueOf(datas[i][k]));
                }
                if (k == 5) {
                    data6.add(Integer.valueOf(datas[i][k]));
                }
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("dateList", dateList);
        data.put("data1", data1);
        data.put("data2", data2);
        data.put("data3", data3);
        data.put("data4", data4);
        data.put("data5", data5);
        data.put("data6", data6);

        RespResult respResult = new RespResult();
        respResult.success(data);
        return respResult;
    }

}
