package apirest.maven.cadpessoas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @GetMapping()
    public String getBook() {
        return "HELLO API";
    }
}
