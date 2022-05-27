package com.myq.epidemic.setting.controller;

import com.myq.epidemic.setting.model.dto.MorbidityDTO;
import com.myq.epidemic.setting.model.dto.MorbidityPageDTO;
import com.myq.epidemic.setting.service.MorbidityService;
import com.myq.epidemic.common.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author 毛一钦
 * @Date 2022/2/21 17:12
 **/
@RestController
public class MorbidityController {

    @Autowired
    private MorbidityService morbidityService;

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 22:15
     * @Description morbidityPage
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/morbidity/selectByPage")
    public ResponseVO morbidityPage(@RequestBody MorbidityPageDTO param) {
        ResponseVO vo = this.morbidityService.selectByPage(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 9:21 
     * @Description morbidityAdd
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/morbidity/add")
    public ResponseVO morbidityAdd(@RequestBody MorbidityDTO param) {
        ResponseVO vo = this.morbidityService.insertOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 9:21 
     * @Description morbidityEdit
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PutMapping("/morbidity/edit")
    public ResponseVO morbidityEdit(@RequestBody MorbidityDTO param) {
        ResponseVO vo = this.morbidityService.updateOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/1 13:20
     * @Description morbidityDelete
     * @param id
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @DeleteMapping("/morbidity/delete")
    public ResponseVO morbidityDelete(String id) {
        ResponseVO vo = this.morbidityService.deleteOne(id);
        return vo;
    }

}
