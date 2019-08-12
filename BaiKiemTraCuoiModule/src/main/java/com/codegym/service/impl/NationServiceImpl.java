package com.codegym.service.impl;

import com.codegym.model.Nation;
import com.codegym.repository.NationRepository;
import com.codegym.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;

public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;
    @Override
    public Iterable<Nation> showAll() {
        return nationRepository.findAll();
    }
}
