package apirest.maven.cadpessoas.repository;

import apirest.maven.cadpessoas.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByCpf(String cpf);
}
