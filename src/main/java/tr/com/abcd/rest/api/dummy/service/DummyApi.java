package tr.com.abcd.rest.api.dummy.service;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tr.com.abcd.rest.api.dummy.model.Message;
import tr.com.abcd.rest.api.model.MkkResponse;
import tr.com.abcd.rest.api.model.ResponseBody;
import tr.com.abcd.rest.api.model.ResponseHeader;
import tr.com.abcd.rest.api.util.ApiResponseMessage;
import tr.com.abcd.rest.api.util.NotFoundException;


@Path("/dummy")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public  class DummyApi implements DummyApiService  {

    @POST
    @Path("/post")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
	@Override
	public Response post(Message message) throws NotFoundException {
    	try {
			ResponseHeader responseHeader = new ResponseHeader();
			responseHeader.setMessageId(UUID.randomUUID().toString());
			responseHeader.setReceiverMember("MKK");
			responseHeader.setSenderReference(message.getRequestHeader().getSenderReference());;
			
			ResponseBody responseBody = new ResponseBody();
			responseBody.setResponseCode("0000");
			responseBody.setResponseDesc("Success");
			
			
			MkkResponse mkResponse = new MkkResponse();
			mkResponse.setResponseHeader(responseHeader);
			mkResponse.setResponseBody(responseBody);
			
			return Response.ok().entity(mkResponse).build();
		} catch (Exception e) {
			return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage())).build();
		}

	}



    
}
