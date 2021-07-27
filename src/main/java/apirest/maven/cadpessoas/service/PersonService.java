package apirest.maven.cadpessoas.service;

import apirest.maven.cadpessoas.dto.request.PersonDTO;
import apirest.maven.cadpessoas.dto.response.MessageResponseDTO;
import apirest.maven.cadpessoas.entity.Person;
import apirest.maven.cadpessoas.exception.PersonNotFoundException;
import apirest.maven.cadpessoas.mapper.PersonMapper;
import apirest.maven.cadpessoas.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    /*
    public PersonService(PersonRepository personRepository)
    {
    this.personRepository = personRepository;
    }
    */


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

    public PersonDTO findById(long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        /*
            // Para não repetir o código foi criado o metodo verifyIfExists
            Optional<Person> optionalperson = personRepository.findById(id);
            if(optionalperson.isEmpty())
            {
                throw new PersonNotFoundException(id);
            }
         */


        return personMapper.toDTO(person);
    }

    public void delete(long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponse(updatedPerson.getId(), "Update person with ID ");
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse( savedPerson.getId(), "Person successfully updated with ID ");

        return messageResponse;
    }

    private Person verifyIfExists(long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}
