package kontrolltoo.kontrolltoo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
class KontrollController{
    KontrolltooAnalytics analytics = new KontrolltooAnalytics();
    KontrollResponses response = new KontrollResponses();


    @GetMapping("/test")
    public KontrollResponses Sample(@RequestParam(defaultValue = "World!") String name){
        response.setMessage("Kuidas kasi kaeb");
        return response;
    }

    @GetMapping("/split")
    public String[] split_words(){
        
        return analytics.split_words_into_pieces(response.getMessage());
    }

    @GetMapping("/lowercase")
    public String[] lower_case(){
        return analytics.turn_words_to_lowercase(response.getMessage().split(" "));
    }

    @GetMapping("/count")
    public int count_words(){
        int number = analytics.count_words_greater_than_four(response.getMessage().split(" "));
        return number;
    }
}