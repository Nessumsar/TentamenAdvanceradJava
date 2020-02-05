package se.ecutb.data;

import org.springframework.stereotype.Component;

@Component
public class IdSequencersImpl implements IdSequencers {
    private int personId;
    private int todoId;

    @Override
    public int nextPersonId() {
        personId++;
        return personId;
    }

    @Override
    public int nextTodoId() {
        todoId++;
        return todoId;
    }

    @Override
    public void clearPersonId() {
        personId =0;
    }

    @Override
    public void clearTodoId() {
        todoId =0;
    }
}
