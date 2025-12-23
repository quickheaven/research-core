package ca.quickheaven.urldecoderencoder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/home/{name}")
    public String home(Map model, @PathVariable String name) {
        model.put("name", name);
        return "home";
    }
}
