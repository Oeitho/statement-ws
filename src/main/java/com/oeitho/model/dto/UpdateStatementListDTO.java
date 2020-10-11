package com.oeitho.model.dto;

import java.util.List;
import java.util.Objects;

public class UpdateStatementListDTO {
    
    private List<UpdateStatementDTO> statements;
    
    public UpdateStatementListDTO() {}

    public UpdateStatementListDTO(List<UpdateStatementDTO> statements) {
        this.statements = Objects.requireNonNull(statements);
    }

    public List<UpdateStatementDTO> getStatements() {
        return statements;
    }

    public void setStatements(List<UpdateStatementDTO> statements) {
        this.statements = statements;
    }

}
