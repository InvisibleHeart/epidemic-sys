package com.myq.forecast.seir;

import com.myq.epidemic.setting.interfaces.SimulationInterface;
import com.myq.forecast.seir.utils.ForecastUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyTest {

    @Autowired
    private SimulationInterface simulationInterface;

    @Test
    public void test() {
        System.out.println(ForecastUtil.getInstance().getResult(null));
        System.out.println(ForecastUtil.getInstance().getRecords());
    }

    @Test
    public void test1() {
        List simulation = simulationInterface.simulation();
        System.out.println(simulation);
    }


}


