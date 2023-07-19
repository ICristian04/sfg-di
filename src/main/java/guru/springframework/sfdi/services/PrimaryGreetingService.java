package guru.springframework.sfdi.services;


public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - From PRIMARY Bean";
    }
}
