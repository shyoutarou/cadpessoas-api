package apirest.maven.cadpessoas.controller;

import apirest.maven.cadpessoas.dto.MessageResponseDTO;
import apirest.maven.cadpessoas.entity.Person;
import apirest.maven.cadpessoas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping()
    public String getBook() {
        return "HELLO API";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
            return this.personService.createPerson(person);
    }
}
