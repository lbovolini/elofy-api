package com.github.lbovolini.elofy.service;

import com.github.lbovolini.elofy.model.People;
import com.github.lbovolini.elofy.repository.PeopleRepository;

import javax.inject.Inject;
import java.util.List;

public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Inject
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void delete(int id) {
        this.peopleRepository.delete(id);
    }

    public People find(int id) {
        return this.peopleRepository.find(id);
    }

    public List<People> findAll() {
        return this.peopleRepository.findAll();
    }

    public void save(People people) {
        this.peopleRepository.save(people);
    }

    public void update(People people) {
        this.peopleRepository.update(people);
    }
}
