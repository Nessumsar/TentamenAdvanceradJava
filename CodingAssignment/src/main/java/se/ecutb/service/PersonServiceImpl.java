package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.PersonRepository;
import se.ecutb.dto.PersonDto;
import se.ecutb.dto.PersonDtoWithTodo;
import se.ecutb.model.Address;
import se.ecutb.model.Person;

import java.util.List;
@Component
public class PersonServiceImpl implements PersonService {
    @Autowired private CreatePersonService createPersonService;
    @Autowired private PersonDtoConversionService personDtoConversionService;
    @Autowired private PersonRepository personRepository;

    @Override
    public Person createPerson(String firstName, String lastName, String email, Address address) {
        Person p = createPersonService.create(firstName, lastName, email, address);
        personRepository.findAll().add(p);
        return p;
    }

    @Override
    public List<PersonDto> findAll() {
        return null;
    }

    @Override
    public PersonDto findById(int personId) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Person findByEmail(String email) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<PersonDtoWithTodo> findPeopleWithAssignedTodos() {
        return null;
    }

    @Override
    public List<PersonDto> findAllPeopleWithNoTodos() {
        return null;
    }

    @Override
    public List<PersonDto> findPeopleByAddress(Address address) {
        return null;
    }

    @Override
    public List<PersonDto> findPeopleByCity(String city) {
        return null;
    }

    @Override
    public List<PersonDto> findByFullName(String fullName) {
        return null;
    }

    @Override
    public List<PersonDto> findByLastName(String lastName) {
        return null;
    }

    @Override
    public boolean deletePerson(int personId) throws IllegalArgumentException {
        return false;
    }
}
