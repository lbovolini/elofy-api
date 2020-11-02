package com.github.lbovolini.elofy.config;

import com.github.lbovolini.elofy.repository.PeopleRepository;
import com.github.lbovolini.elofy.repository.PeopleRepositoryImpl;
import com.github.lbovolini.elofy.service.PeopleService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class DependencyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        // Service
        bind(PeopleService.class).to(PeopleService.class);
        // Repository
        bind(PeopleRepositoryImpl.class).to(PeopleRepository.class);
    }
}
