package main.java.com.example.todo_list_project.controller.Routes;

@Controller
public class RoutesController {
    
    @GetMapping("/")
    public String homePage() {
        return "index";
    }
}
