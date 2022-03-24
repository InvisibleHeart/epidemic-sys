package com.myq.epidemic_sys.setting;


import com.myq.epidemic_sys.setting.interfaces.SimulationInterface;
import com.myq.epidemic_sys.setting.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyTest {

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
}
