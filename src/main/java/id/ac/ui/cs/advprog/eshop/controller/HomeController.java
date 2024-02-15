package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/")
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "HomePage"; // This corresponds to the name of your HTML file without the extension
    }
}
