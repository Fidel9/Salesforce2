package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;


import static org.testng.Assert.assertEquals;

@Log4j2
public class CarTest {

    @Test
    public void carTest(){
        log.info("Start test");
        Car car1 = CarFactory.get();
        car1.setMake("bmv");
        Car car2 = CarFactory.get();
        car2.setMake("bmv");

        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");


        assertEquals(car1, car2,"Avtomobili ne ravni ");
        log.info("End Test");
    }
}
