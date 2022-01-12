package tests;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CarFactory {
    static Faker faker = new Faker();

    public static Car get(){
        log.debug("Создается обьект Car");
        return Car.builder()
                .make(faker.color().name())
                .model(faker.dragonBall().character())
                .build();
    }
}
