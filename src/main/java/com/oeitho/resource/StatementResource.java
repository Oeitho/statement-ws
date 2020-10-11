package com.oeitho.resource;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oeitho.model.Statement;
import com.oeitho.model.dto.UpdateStatementListDTO;
import com.oeitho.service.StatementService;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/statement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatementResource {

    @Inject
    StatementService statementService;

    @GET
    public Response randomStatement() {
        Statement statement;
        try {
            statement = statementService.randomStatement();
            return Response
                .status(Response.Status.OK)
                .entity(statement)
                .build();
        } catch (NotFoundException exception) {
            return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .build();
        }
    }

    @Path("/{statementId}")
    @GET
    public Response getStatement(@PathParam Long statementId) {
        try {
            Statement statement = statementService.getStatement(statementId);
            return Response
                .status(Response.Status.OK)
                .entity(statement)
                .build();
        } catch (NotFoundException exception) {
            return Response
                .status(Response.Status.NOT_FOUND)
                .build();
        }
    }

    @Path("/all")
    @GET
    public Response allStatements() {
        List<Statement> statements;
        try {
            statements = statementService.getAllStatements();
            return Response
                .status(Response.Status.OK)
                .entity(statements)
                .build();
        } catch (NotFoundException exception) {
            return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .build();
        }
    }

    @POST
    public Response createStatement(Statement statement) {
        statementService.createStatement(statement);
        return Response
            .status(Response.Status.OK)
            .build();
    }

    @PUT
    public Response updateStatement(UpdateStatementListDTO dto) {
        statementService.updateStatements(dto);
        return Response
            .status(Response.Status.OK)
            .build();
    }
}