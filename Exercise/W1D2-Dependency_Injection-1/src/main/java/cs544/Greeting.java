package cs544;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Greeting {
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Value("Hello World")
    private String greeting;
    public void sayHello()
    {
        System.out.println(greeting);
    }

}
