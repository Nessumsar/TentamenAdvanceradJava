package se.ecutb.data;

import org.springframework.stereotype.Component;
import se.ecutb.model.Person;
import se.ecutb.model.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TodoRepositoryImpl implements TodoRepository{
    private List<Todo> todoData = new ArrayList<>();

    @Override
    public Todo persist(Todo todo) {
        if(todoData.stream().noneMatch(t -> todo.getTodoId() == t.getTodoId())){
            todoData.add(todo);
        }
        return todo;
    }

    @Override
    public Optional<Todo> findById(int todoId) {
        return todoData.stream()
                .filter(t -> t.getTodoId() == todoId)
                .findFirst();
    }

    @Override
    public List<Todo> findByTaskDescriptionContains(String taskDescription) {
        return todoData.stream().
                filter(t -> t.getTaskDescription().toLowerCase().contains(taskDescription.toLowerCase()))
                .collect(Collectors.toList());
    }


    @Override
    public List<Todo> findByDeadLineBefore(LocalDate endDate) {
        return todoData.stream()
                .filter(t -> t.getDeadLine().isBefore(endDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByDeadLineAfter(LocalDate startDate) {
        return todoData.stream()
                .filter(t -> t.getDeadLine().isAfter(startDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByDeadLineBetween(LocalDate start, LocalDate end) {
        return todoData.stream()
                .filter(t -> t.getDeadLine().isAfter(start))
                .filter(t -> t.getDeadLine().isBefore(end))
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByAssigneeId(int personId) {
        return todoData.stream()
                .filter(t -> t.getAssignee() != null)
                .filter(t -> t.getAssignee().getPersonId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findAllUnassignedTasks() {
        return todoData.stream()
                .filter(t -> t.getAssignee() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findAllAssignedTasks() {
        return todoData.stream()
                .filter(t -> t.getAssignee() != null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByDone(boolean isDone) {
        return todoData.stream()
                .filter(t -> t.isDone())
                .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findAll() {
        return todoData;
    }

    @Override
    public boolean delete(int todoId) throws IllegalArgumentException {
        if(todoData.stream().anyMatch(t -> t.getTodoId() == todoId)){
            todoData.remove(todoData.stream().filter(t -> t.getTodoId() == todoId).findFirst().get());
            return true;
        }else if(todoData.stream().noneMatch(t -> t.getTodoId() == todoId)){
            throw new IllegalArgumentException();
        }
        return false;
    }

    @Override
    public void clear() {

    }
}
