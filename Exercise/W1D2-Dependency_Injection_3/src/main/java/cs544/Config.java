package cs544;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cs544")
public class Config {
    @Bean
    public Amazon amazon()
    {
        return  new Amazon();
    }
    @Bean
    public EBooks eBooks()
    {
        return  new EBooks();
    }
    @Bean
    public BarnesAndNoble barnesAndNoble()
    {
        return  new BarnesAndNoble();
    }
    @Bean
    public Borders borders()
    {
        return  new Borders();
    }
}
