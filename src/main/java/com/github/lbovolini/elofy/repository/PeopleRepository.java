package com.github.lbovolini.elofy.repository;

import com.github.lbovolini.elofy.model.People;

import java.util.List;

public interface PeopleRepository {

    void delete(int id);

    People find(int id);

    List<People> findAll();

    People save(People people);

    void update(People people);

}
