package com.myq.forecast.seir.utils;

import com.myq.epidemic_sys.common.model.dto.ParamDTO;
import com.myq.forecast.seir.io.Output;
import com.myq.forecast.seir.io.PropertiesReader;
import com.myq.forecast.seir.ode.OdeProperties;
import com.myq.forecast.seir.population.SeirRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ClassUtils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.myq.forecast.seir.ode.OdeEquations.*;

/**
 * @Author 毛一钦
 * @Date 2022/3/15 21:26
 * @Description     SEIR传播模型主方法（单例模式 双重验证）
 **/
public class ForecastUtil {
    private static volatile ForecastUtil INSTANCE = null;

    private static int t0;
    private static int tMax;

    private static OdeProperties props;
    private static SeirRecord population;

    private static final Logger LOGGER = LogManager.getLogger(ForecastUtil.class);
    /**
     * 结果集
     **/
    private Map<Integer, SeirRecord> records = new HashMap<>();

    /**
     * @Author 毛一钦
     * @Date 2022/3/18 14:31
     * @Description ForecastUtil    无参构造
     * @param
     * @return
     **/
    private ForecastUtil() {
        //  根目录地址
        final String CLASSPATH = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);
        //  读取配置
        PropertiesReader reader = new PropertiesReader(CLASSPATH + "odeProperties.json", CLASSPATH + "properties.json");

        t0 = reader.getT0();
        tMax = reader.gettMax();

        props = reader.getOdeProperties();
        population = reader.getInitialPopulation();

        LOGGER.info(CLASSPATH);
        LOGGER.info("{}   {}   {}   {}   {}", t0, population.getS(),
                population.getE(),
                population.getI(),
                population.getR());
    }

    //  双重验证
    public static ForecastUtil getInstance() {

        //第一次校验singleton是否为空
        if (INSTANCE == null) {
            synchronized (ForecastUtil.class) {
                //第二次校验singleton是否为空
                if (INSTANCE == null) {
                    INSTANCE = new ForecastUtil();
                }
            }
        }
        return INSTANCE;
    }

    public void run() {
//        //  读取配置
//        PropertiesReader reader = new PropertiesReader(CLASSPATH + "odeProperties.json", CLASSPATH + "properties.json");
//
//        t0 = reader.getT0();
//        tMax = reader.gettMax();
//
//        props = reader.getOdeProperties();
//        population = reader.getInitialPopulation();
//
//        //  LOGGER.info(CLASSPATH);
//        LOGGER.info("{}   {}   {}   {}   {}", t0, population.getS(),
//                                                            population.getE(),
//                                                            population.getI(),
//                                                            population.getR());
        //  根据公式运算
        calculate(tMax, props, population);

        //  Output.INSTANCE.printSeirCSV(records, CLASSPATH + "SEIR.csv");
        List list = Output.INSTANCE.printSeirList(records);
        System.out.println(list);


    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/18 14:32
     * @Description calculate   SEIR公式运算
     * @param tMax
     * @param props
     * @param pop
     * @return void
     **/
    private void calculate(int tMax, OdeProperties props, SeirRecord pop) {

        for (int t = 0; t < tMax; t++) {

            records.put(t, pop);

            double dsDt = calculateDsDt(props, pop);
            double deDt = calculateDeDt(props, pop);
            double diDt = calculateDiDt(props, pop);
            double drDt = calculateDrDt(props, pop);

            double n = pop.getN();
            double s = pop.getS() + dsDt;
            double e = pop.getE() + deDt;
            double i = pop.getI() + diDt;
            double r = pop.getR() + drDt;

            //  LOGGER.info("{}   {}   {}   {}   {}   {}", t + 1, s, e, i, r, n);

            pop = new SeirRecord(t, n, s, e, i, r);

        }
    }

    public Map getRecords() {
        return this.records;
    }

    /**
     * @Author 毛一钦
     * @Date 2022/3/18 13:14
     * @Description getResult   返回预测结果
     * @param
     * @return java.util.List
     **/
    public List getResult(ParamDTO param) {
        //  重载配置
        if (param != null) {
            t0 = param.getT0();
            tMax = param.getTMax();

            props = new OdeProperties(param.getGamma(),
                    param.getSigma(),
                    param.getBeta(),
                    param.getMu(),
                    param.getNu());

            population = new SeirRecord(t0, param.getN(), param.getS(), param.getE(), param.getI(), 0);

        }

        //  LOGGER.info(CLASSPATH);
        LOGGER.info("{}   {}   {}   {}   {}", t0, population.getS(),
                population.getE(),
                population.getI(),
                population.getR());

        //  根据公式运算
        calculate(tMax, props, population);

        return Output.INSTANCE.printSeirList(records);
    }

}
