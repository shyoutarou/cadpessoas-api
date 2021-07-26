package apirest.maven.cadpessoas.service;

import apirest.maven.cadpessoas.dto.MessageResponseDTO;
import apirest.maven.cadpessoas.entity.Person;
import apirest.maven.cadpessoas.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
    //private final PersonMapper personMapper = PersonMapper.INSTANCE;


    /*
        public ResponseEntity<PersonDto> createPerson(PersonForm personForm, UriComponentsBuilder uriComponentsBuilder) {
        Person savedPerson = personForm.convert();
        personRepository.save(savedPerson);

        URI uri = uriComponentsBuilder.path("/api/v1/people/{id}")
                .buildAndExpand(savedPerson.getId())
                .toUri();

        return ResponseEntity.created(uri)
                .body(new PersonDto(savedPerson));
    }

    public List<PersonDto> listAll() {
        List<Person> list = personRepository.findAll();
        return PersonDto.converter(list);
    }

    public ResponseEntity<PersonDto> finbyId(Long id) {
        Optional<Person> personById = personRepository.findById(id);
        return personById.map(person -> ResponseEntity.ok(new PersonDto(person)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<PersonDto> deleteById(Long id) {
        Optional<Person> personById = personRepository.findById(id);
        if(personById.isPresent()) {
            personRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PersonDto> findByCpf(String cpf) {
        Person byCpf = personRepository.findByCpf(cpf);
        Person personByCpf = personRepository.findByCpf(cpf);
        if (personByCpf != null) {
            return ResponseEntity.ok(new PersonDto(personByCpf));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PersonDto> updateById(Long id, UpdatePersonForm personForm) {
        Optional<Person> personById = personRepository.findById(id);
        if (personById.isPresent()) {
            Person person = personById.get();
            person.setFirstName(personForm.getFirstName());
            person.setLastName(personForm.getLastName());
            person.setPhones(personForm.getPhones());

            return ResponseEntity.ok(new PersonDto(personById.get()));
        }
        return ResponseEntity.notFound().build();
    }

     */


}
