package oblom;

import oblom.config.JDBCConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class DataBaseIO {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JDBCConfig.class);
    public static JdbcTemplate jdbcTemp = applicationContext.getBean(JdbcTemplate.class);
    public static List<dictWordModel> dataOutput(String dictionary){
        List<String> words = jdbcTemp.query("select key.key_word, value.value_word, dictionary from key, value, key_value_link where key_value_link.key_word = key.key_word and key_value_link.value_word = value.value_word and key.dictionary = '" + dictionary + "';", (resultSet, i) -> resultSet.getString("key_word")+"\t"+resultSet.getString("value_word")+"\t"+resultSet.getString("dictionary"));
        List<dictWordModel> output = new ArrayList<>();
        for(String word: words){
            String[] splittedWord = word.split("\t");
            output.add(new dictWordModel(splittedWord[0], splittedWord[1], splittedWord[2]));
        }
        return output;
    }
    public static boolean dataInput(String key, String value){
        jdbcTemp.execute("");
        return true;
    }
}
