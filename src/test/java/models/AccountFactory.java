package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import tests.Car;

@Log4j2
public class AccountFactory {
    static Faker faker = new Faker();

    public static Account get(){
        log.debug("Создается обьект Account");
        return Account.builder()
                .accountName(faker.name().name())
                .webSite("www.onliner.by")
                .type("Investor")
                .description("new account description.")
                .phone(faker.phoneNumber().cellPhone())
                .employees("1")
                .industry("Apparel")
                .build();
    }
}
