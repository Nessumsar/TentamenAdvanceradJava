package se.ecutb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.data.IdSequencers;
import se.ecutb.model.*;



@Component
public class CreatePersonServiceImpl extends AbstractPersonFactory implements CreatePersonService {

    @Autowired
    private IdSequencers ids;
    @Override
    public Person create(String firstName, String lastName, String email) throws IllegalArgumentException {
        return createNewPerson(ids.nextPersonId(), firstName, lastName, email, null);
    }
    @Override
    public Person create(String firstName, String lastName, String email, Address address) throws IllegalArgumentException {
        return createNewPerson(ids.nextPersonId(), firstName, lastName, email, address);
    }

}
