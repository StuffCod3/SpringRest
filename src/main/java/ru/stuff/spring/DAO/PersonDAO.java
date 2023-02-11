package ru.stuff.spring.DAO;

import org.springframework.stereotype.Component;
import ru.stuff.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private List<Person> people;
    private int countId;

    public PersonDAO(){
        people = new ArrayList<>();

        people.add(new Person(++countId, "Evgeny"));
        people.add(new Person(++countId, "Art"));
        people.add(new Person(++countId, "Nikita"));
        people.add(new Person(++countId, "Erik"));
    }

    public List<Person> showAllPerson(){
        return people;
    }

    public Person showPersonById(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
