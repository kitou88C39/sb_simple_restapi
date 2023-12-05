package simple_spring_restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @RequestMapping(method = RequestMethod.GET)
    public String getTodoItems() {
        return "get todo items";

    }

}
