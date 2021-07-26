package apirest.maven.cadpessoas.service;

import apirest.maven.cadpessoas.dto.request.PersonDTO;
import apirest.maven.cadpessoas.dto.response.MessageResponseDTO;
import apirest.maven.cadpessoas.entity.Person;
import apirest.maven.cadpessoas.mapper.PersonMapper;
import apirest.maven.cadpessoas.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        /*
        Person personToSave = Person.builder()
        .firstName(personDTO.getFirstName())
        .lastName(personDTO.getLastName()).build();
         */

        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
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
