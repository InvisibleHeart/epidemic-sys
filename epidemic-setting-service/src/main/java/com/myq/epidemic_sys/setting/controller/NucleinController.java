package com.myq.epidemic_sys.setting.controller;


import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.model.dto.NucleinDTO;
import com.myq.epidemic_sys.setting.model.dto.NucleinPageDTO;
import com.myq.epidemic_sys.setting.service.NucleinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 毛一钦
 * @Date 2022/2/28 17:16
 **/
@RestController
public class NucleinController {

    @Autowired
    private NucleinService nucleinService;

    /**
     * @Author 毛一钦
     * @Date 2022/3/6 16:14
     * @Description nucleinSelectOne
     * @param id
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @GetMapping("/nuclein/selectOne")
    public ResponseVO nucleinSelectOne(String id) {
        ResponseVO vo = this.nucleinService.selectOne(id);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 17:41
     * @Description nucleinSelectPage
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/nuclein/selectPage")
    public ResponseVO nucleinSelectPage(@RequestBody NucleinPageDTO param) {
        ResponseVO vo = this.nucleinService.selectByPage(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 17:51
     * @Description nucleinAdd
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/nuclein/add")
    public ResponseVO nucleinAdd(@RequestBody NucleinDTO param) {
        ResponseVO vo = this.nucleinService.insertOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 17:52
     * @Description nucleinEdit
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PutMapping("/nuclein/edit")
    public ResponseVO nucleinEdit(@RequestBody NucleinDTO param) {
        ResponseVO vo = this.nucleinService.updateOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/28 22:00
     * @Description nucleinDelete
     * @param id
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @DeleteMapping("/nuclein/delete")
    public ResponseVO nucleinDelete(String id) {
        ResponseVO vo = this.nucleinService.deleteOne(id);
        return vo;
    }
}
