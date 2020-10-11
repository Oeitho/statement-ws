package com.oeitho.mapper;

import java.util.ArrayList;
import java.util.List;

import com.oeitho.model.Statement;
import com.oeitho.model.dto.UpdateStatementDTO;
import com.oeitho.model.dto.UpdateStatementListDTO;

public class UpdateStatementMapper {

    public List<Statement> dtoToStatement(UpdateStatementListDTO dto) {
        List<Statement> statements = new ArrayList<Statement>();
        for (UpdateStatementDTO updatedStatement: dto.getStatements()) {
            Statement statement = new Statement();
            statement.setId(updatedStatement.getId());
            statement.setAuthor(updatedStatement.getAuthor());
            statement.setClaim(updatedStatement.getClaim());
            statement.setExplanation(updatedStatement.getExplanation());
            statement.setValidity(updatedStatement.getValidity());
            statement.setActive(updatedStatement.getActive());
            statements.add(statement);
        }
        return statements;
    }

}
