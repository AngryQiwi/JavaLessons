package oblom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DictConfig {
    @Bean
    public ValueModel value(){
        return new ValueModel();
    }
    @Bean
    public DictionaryIO dictionaryEnToRu(){
        return new DictionaryIO();
    }

}
