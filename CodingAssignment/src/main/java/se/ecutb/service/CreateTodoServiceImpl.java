package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencersImpl;
import se.ecutb.model.AbstractTodoFactory;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;

@Component
public class CreateTodoServiceImpl extends AbstractTodoFactory implements CreateTodoService {
    @Autowired
   IdSequencersImpl ids = new IdSequencersImpl();

    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine, Person assignee) throws IllegalArgumentException {
        if (assignee != null){
            return createTodoItem(ids.nextTodoId(), taskDescription, deadLine, assignee);
        }
        return createTodo(taskDescription, deadLine);
    }
    @Override
    public Todo createTodo(String taskDescription, LocalDate deadLine) throws IllegalArgumentException {
        if(taskDescription != null && deadLine != null) {
            return createTodoItem(ids.nextTodoId(), taskDescription, deadLine);
        }
        throw new IllegalArgumentException();
    }
}
