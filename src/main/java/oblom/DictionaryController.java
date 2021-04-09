package oblom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;


@Controller
public class DictionaryController {
    @GetMapping(value = "/")
    public String startPage() {
        return "index";
    }
    @GetMapping(value = "/en")
    public String engDict(Map<String, Object> model){
        List<dictWordModel> resultSet = DataBaseIO.dataOutput("en");
        model.put("resultSet", resultSet);
        String label = "Английской словарь";
        model.put("label", label);
        return "dictView";
    }
    @GetMapping(value = "/num")
    public String numDict(Map<String, Object> model){
        List<dictWordModel> resultSet = DataBaseIO.dataOutput("num");
        model.put("resultSet", resultSet);
        String label = "Числовой словарь";
        model.put("label", label);
        return "dictView";
    }
    @GetMapping(value = "/addword")
    public String addWord(Map<String, Object> model){
        return "addWord";
    }
    @PostMapping(value = "/addword")
    public String addWordSubmit(@ModelAttribute("dictWordModel") dictWordModel word, ModelMap model){

        return "dictView";
    }
}