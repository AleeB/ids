package it.unicam.cs.ItalianWonder.services;

import it.unicam.cs.ItalianWonder.classes.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.ContestRepository;

import java.util.Optional;

@Service

public class ContestService {

    private final ContestRepository contestRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    public Optional<Contest> findById(Long id) {
        return contestRepository.findById(id);
    }

    public void save(Contest contest) {
        contestRepository.save(contest);
    }

    public void delete(Contest findC) {
        contestRepository.delete(findC);
    }
}
