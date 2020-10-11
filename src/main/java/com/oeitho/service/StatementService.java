package com.oeitho.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.oeitho.mapper.UpdateStatementMapper;
import com.oeitho.model.Statement;
import com.oeitho.model.dto.UpdateStatementListDTO;
import com.oeitho.repository.StatementRepository;

@ApplicationScoped
public class StatementService {
    
    @Inject
    StatementRepository repository;

    UpdateStatementMapper mapper = new UpdateStatementMapper();

    public Statement randomStatement() throws NotFoundException {
        List<Statement> allActiveStatements = repository.findActive();
        if (allActiveStatements.size() < 1) {
            throw new NotFoundException("No statement could be returned!");
        }
        Collections.shuffle(allActiveStatements);
        return allActiveStatements.get(0);
    }

    public Statement getStatement(Long statementId) throws NotFoundException {
        Optional<Statement> statement = repository.findByIdOptional(statementId);
        return statement
            .orElseThrow(NotFoundException::new);
    }

    public List<Statement> getAllStatements() throws NotFoundException {
        return repository.listAll();
    }

    @Transactional
    public void createStatement(Statement statement) {
        repository.persist(statement);
    }

    @Transactional
    public void updateStatements(UpdateStatementListDTO dto) {
        List<Statement> statements = mapper.dtoToStatement(dto);
        for (Statement statement: statements) {
            repository.getEntityManager().merge(statement);
        }
    }

}
