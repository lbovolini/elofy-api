package com.github.lbovolini.elofy.exception;

import com.github.lbovolini.elofy.message.FormErrorMessage;
import com.github.lbovolini.elofy.message.InputError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

@Provider
public class NameAlreadyRegisteredMapper implements ExceptionMapper<NameAlreadyRegisteredException> {
    @Override
    public Response toResponse(NameAlreadyRegisteredException e) {
        List<InputError> inputErrorList = new ArrayList<>();
        inputErrorList.add(new InputError("name", e.getMessage()));
        FormErrorMessage formErrorMessage = new FormErrorMessage(inputErrorList);
        return Response.status(Response.Status.CONFLICT).entity(formErrorMessage).build();
    }
}
