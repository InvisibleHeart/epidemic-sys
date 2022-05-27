package com.myq.epidemic.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.myq.epidemic.common.Route;
import com.myq.epidemic.entity.Region;
import com.myq.epidemic.entity.RegionItem;
import com.myq.epidemic.entity.RegionTabel;
import com.myq.epidemic.model.vo.RegionIndexVO;
import com.myq.epidemic.utils.HttpClientUtil;
import com.myq.epidemic.common.model.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class IndexController {

    private String prefix = "/user/";

    // 报备
    @RequestMapping("/reporting.html")
    public String loginHtml() {
        return prefix + "reporting";
    }

    // 首页
    @RequestMapping("/index.html")
    public String indexHtml (Model model) {
        String result = HttpClientUtil.doGet(Route.ADDRESS + "/region/index", null);
        ResponseVO responseVO = JSONObject.parseObject(result, ResponseVO.class);

        RegionIndexVO vo = JSONObject.parseObject(responseVO.getData().toString(), RegionIndexVO.class);

        List<Region> regionList = JSONObject.parseArray(JSONObject.toJSONString(vo.getRegionList()), Region.class);
        //  过滤 暂无地区的数据
        regionList = regionList.stream().filter(out -> out.getId() != -1).collect(Collectors.toList());

        List<RegionTabel> regionTabelList = new ArrayList<>();
        regionList.stream().forEach(dto -> {
            RegionTabel regionTabel = new RegionTabel();
            regionTabel.setName(dto.getName());
            regionTabelList.add(regionTabel);
        });

//        for (Region region : regionList) {
//            RegionTabel regionTabel = new RegionTabel();
//            regionTabel.setName(region.getName());
//            regionTabelList.add(regionTabel);
//        }

        List<RegionItem> regionItemList = JSONObject.parseArray(JSONObject.toJSONString(vo.getRegionItemList()), RegionItem.class);
        for (RegionItem regionItem : regionItemList) {
            for (RegionTabel regionTabel : regionTabelList) {
                if (regionItem.getName().equals(regionTabel.getName())) {
                    if (regionItem.getStatus() == 0) {
                        regionTabel.setPatient1(regionItem.getCount());
                    }
                    if (regionItem.getStatus() == 1) {
                        regionTabel.setPatient2(regionItem.getCount());
                    }
                    if (regionItem.getStatus() == 2) {
                        regionTabel.setPatient3(regionItem.getCount());
                    }
                    if (regionItem.getStatus() == 3) {
                        regionTabel.setPatient4(regionItem.getCount());
                    }
                    if (regionItem.getStatus() == 4) {
                        regionTabel.setPatient5(regionItem.getCount());
                    }
                    if (regionItem.getStatus() == 5) {
                        regionTabel.setPatient6(regionItem.getCount());
                    }
                }
            }
        }
        model.addAttribute("regionTabelList", regionTabelList);
        return prefix + "index";
    }

}
