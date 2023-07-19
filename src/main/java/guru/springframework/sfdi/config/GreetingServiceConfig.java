package guru.springframework.sfdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfdi.services.*;
import org.springframework.context.annotation.*;

// SPRING JAVA CONFIGURATION

@ImportResource("classpath:sfdi-config.xml") //XML CONFIGURATION
@Configuration
public class GreetingServiceConfig {


    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"EN","default"})
    @Bean
    I18nEnglishService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishService(englishGreetingRepository);
    }

    @Profile("ES")
    @Bean("i18nService")
    I18nSpanishService i18nSpanishService(){
        return new I18nSpanishService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }


}
