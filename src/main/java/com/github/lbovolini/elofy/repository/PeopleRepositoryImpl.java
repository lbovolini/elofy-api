package com.github.lbovolini.elofy.repository;

import com.github.lbovolini.elofy.model.People;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepositoryImpl extends BaseRepository<People> implements PeopleRepository {
    @Override
    public void delete(int id) {
        String query = "DELETE FROM People WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        executeDelete(query, parameters);
    }

    @Override
    public People find(int id) {
        String query = "SELECT p FROM People p WHERE id = ?1";

        List parameters = new ArrayList();
        parameters.add(id);

        return (People)executeSingle(query, parameters);
    }

    @Override
    public List<People> findAll() {
        String query = "SELECT p FROM People p";

        return (List<People>)execute(query);
    }

    @Override
    public People save(People people) {
        return super.save(people);
    }

    @Override
    public void update(People people) {
        super.update(people);
    }
}
