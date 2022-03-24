package com.myq.epidemic_sys.setting.controller;


import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.model.dto.PatientDTO;
import com.myq.epidemic_sys.setting.model.dto.PatientPageDTO;
import com.myq.epidemic_sys.setting.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 毛一钦
 * @Date 2022/2/14 15:37
 **/
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * @Author 毛一钦
     * @Date 2022/2/22 19:46
     * @Description patientSelectOne
     * @param patientId
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @GetMapping("/patient/selectOne")
    public ResponseVO patientSelectOne(String patientId) {
        ResponseVO vo = patientService.selectOne(patientId);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/23 21:19
     * @Description patientPage
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/patient/selectPage")
    public ResponseVO patientPage(@RequestBody PatientPageDTO param) {
        ResponseVO vo = this.patientService.selecetPage(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/25 15:20
     * @Description patienAdd
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PostMapping("/patient/add")
    public ResponseVO patienAdd(@RequestBody PatientDTO param) {
        ResponseVO vo = this.patientService.insertOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 21:33 
     * @Description patientEdit
     * @param param
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @PutMapping("/patient/edit")
    public ResponseVO patientEdit(@RequestBody PatientDTO param) {
        ResponseVO vo = this.patientService.updateOne(param);
        return vo;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/2/27 21:36
     * @Description patientDelete
     * @param id
     * @return com.myq.epidemic_sys.common.model.ResponseVO
     **/
    @DeleteMapping("/patient/delete")
    public ResponseVO patientDelete(String id) {
        ResponseVO vo = this.patientService.deleteOne(id);
        return vo;
    }

}
