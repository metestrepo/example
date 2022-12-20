package tr.com.abcd.rest.api.dummy.service;

import javax.ws.rs.core.Response;

import tr.com.abcd.rest.api.model.RestMessage;
import tr.com.abcd.rest.api.util.NotFoundException;


public interface DummyApiService {
    public Response post(RestMessage body) throws NotFoundException;
}
