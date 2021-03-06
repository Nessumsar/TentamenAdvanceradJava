package se.ecutb.service;

import org.springframework.stereotype.Component;
import se.ecutb.dto.PersonDto;
import se.ecutb.dto.PersonDtoWithTodo;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PersonDtoConverionServiceImpl implements PersonDtoConversionService {
    @Override
    public PersonDto convertToPersonDto(Person person) {

        return new PersonDto(
              person.getPersonId(),
              person.getFirstName(),
              person.getLastName()
        );
    }

    @Override
    public PersonDtoWithTodo convertToPersonDtoWithTodo(Person person, List<Todo> assignedTodos) {
            TodoDtoConversionService asd = new TodoDtoConversionServiceImpl();
            PersonDtoWithTodo ret = new PersonDtoWithTodo(person.getPersonId(),
                    person.getFirstName(),
                    person.getLastName(),
                    assignedTodos.stream().map(todo -> asd.convertToDto(todo)).collect(Collectors.toList()));
            return ret;
        }
    }

