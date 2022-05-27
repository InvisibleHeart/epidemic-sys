package com.myq.epidemic.setting.controller;

import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.setting.model.dto.RegionDTO;
import com.myq.epidemic.setting.model.dto.RegionPageDTO;
import com.myq.epidemic.setting.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @Author 毛一钦
 * @Date 2022/2/22 19:39
 **/
@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    /**
     * @Author 毛一钦
     * @Date 2022/2/22 19:45
     * @Description queryAll
     * @param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @GetMapping("/region/queryAll")
    public ResponseVO queryAll() {
        ResponseVO vo = this.regionService.queryAll();
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 20:35 
     * @Description regionSelectPage
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/region/selectPage")
    public ResponseVO regionSelectPage(@RequestBody RegionPageDTO param) {
        ResponseVO vo = this.regionService.selectPage(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 21:57
     * @Description regionAdd
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/region/add")
    public ResponseVO regionAdd(@RequestBody RegionDTO param) {
        ResponseVO vo = this.regionService.insertOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 22:06
     * @Description regionEdit
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PutMapping("/region/edit")
    public ResponseVO regionEdit(@RequestBody RegionDTO param) {
        ResponseVO vo = this.regionService.updateOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 22:16
     * @Description regionDelete
     * @param id
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @DeleteMapping("/region/delete")
    public ResponseVO regionDelete(String id) {
        ResponseVO vo = this.regionService.deleteOne(id);
        return vo;
    }

    @GetMapping("/region/index")
    public ResponseVO regionIndex() {
        ResponseVO vo = this.regionService.indexOne();
        return vo;
    }
}
