package com.myq.epidemic_sys.setting.controller;


import com.myq.epidemic_sys.common.model.ResponseVO;
import com.myq.epidemic_sys.setting.model.dto.ForecastParamDTO;
import com.myq.epidemic_sys.setting.service.PatientService;
import com.myq.epidemic_sys.setting.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author 毛一钦
 * @Date 2022/3/1 19:24n
 **/
@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/statistics/selectByCrowdStatistics")
    public ResponseVO statisticsSelectByCrowdStatistics() {
        ResponseVO vo = this.patientService.selectListByCrowdStatistics();
        return vo;
    }

    @GetMapping("/statistics/selectByRegionStatistics")
    public ResponseVO statisticsSelectByRegionStatistics() {
        ResponseVO vo = this.patientService.selectListByRegionStatistics();
        return vo;
    }

    @GetMapping("/statistics/selectByStatusStatistics")
    public ResponseVO statisticsSelectByStatusStatistics() {
        ResponseVO vo = this.patientService.selectListByStatusStatistics();
        return vo;
    }

    @GetMapping("/statistics/infectionDegree")
    public ResponseVO statisticsInfectionDegree() {
        ResponseVO vo = this.patientService.statisticsInfectionDegree();
        return vo;
    }

    @GetMapping("/statistics/forecast")
    public ResponseVO diseasePrediction() {
        ResponseVO vo = this.statisticsService.diseasePrediction();
        return vo;
    }

    @PostMapping("/statistics/forecast")
    public ResponseVO diseasePrediction(@RequestBody ForecastParamDTO param) {
        ResponseVO vo = this.statisticsService.diseasePrediction(param);
        return vo;
    }
}
