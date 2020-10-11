package com.oeitho.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.oeitho.model.Statement;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StatementRepository implements PanacheRepository<Statement> {
    
    public List<Statement> findActive() {
        return list("active", true);
    }

    public Optional<Statement> findByIdOptional(Long id) {
        return find("id", id).firstResultOptional();
    }

}
