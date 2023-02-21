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

        people.add(new Person(++countId, "Evgeny", "evgen@mail.ru", 20));
        people.add(new Person(++countId, "Art", "art@mail.ru", 20));
        people.add(new Person(++countId, "Nikita", "nekit@mail.ru", 20));
        people.add(new Person(++countId, "Erik", "erik@mail.ru", 20));
    }

    public List<Person> showAllPerson(){
        return people;
    }

    public Person showPersonById(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++countId);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdated = showPersonById(id);
        personToBeUpdated.setName(updatePerson.getName());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
