package ru.stuff.spring.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.stuff.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private int countId;

    public List<Person> showAllPerson(){
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person showPersonById(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)", person.getName(), person.getEmail(), person.getAge());
    }

    public void update(int id, Person updatePerson){
        jdbcTemplate.update("UPDATE Person SET name=?, email=?, age=? WHERE id=?", updatePerson.getName(), updatePerson.getEmail(), updatePerson.getAge(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
