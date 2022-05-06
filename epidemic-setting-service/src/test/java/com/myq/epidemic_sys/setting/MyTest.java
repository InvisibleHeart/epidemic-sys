package com.myq.epidemic_sys.setting;


import com.myq.epidemic_sys.setting.entity.Reporting;
import com.myq.epidemic_sys.setting.interfaces.SimulationInterface;
import com.myq.epidemic_sys.setting.mapper.ReportingMapper;
import com.myq.epidemic_sys.setting.service.ReportingService;
import com.myq.epidemic_sys.setting.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
public class MyTest {

    @Autowired
    private ReportingService reportingService;

    @Autowired
    private ReportingMapper reportingMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() {
        System.out.println("aaaa");
    }

    @Autowired
    private TestService testService;

    @Autowired(required = false)
    private SimulationInterface simulationInterface;

    @Test
    public void test1() {
        String s = testService.test1();
        System.out.println(s);
    }

    @Test
    public void test2() {
        List simulation = simulationInterface.simulation();

        System.out.println(simulation);
    }

    @Test void test3() {
        Reporting dto = new Reporting();
        dto.setUserName("毛vg");
        dto.setSex(true);
        dto.setAddress("aaabbbba");

        Query query = new Query(Criteria.where("userName").is("毛一钦"));
        Reporting insert = this.reportingMapper.insert(dto);
        System.out.println(insert);
        List<Reporting> all = this.reportingMapper.findAll();
        all.forEach(System.out::println);

    }

    @Test void test4() {
        Reporting dto = new Reporting();
        dto.setUserName("毛一钦");
        dto.setSex(true);
        dto.setAddress("aaaa");

        Reporting insert = this.mongoTemplate.insert(dto);
        System.out.println(insert);
    }
}
