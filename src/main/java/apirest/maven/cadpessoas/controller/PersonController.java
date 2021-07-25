package apirest.maven.cadpessoas.controller;

import apirest.maven.cadpessoas.dto.MessageResponseDTO;
import apirest.maven.cadpessoas.entity.Person;
import apirest.maven.cadpessoas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping()
    public String getBook() {
        return "HELLO API";
    }

    @Autowired
    public PersonController(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
