package mmhttp.server;

import mmhttp.protocol.Response;
import mmhttp.protocol.Request;
import mmhttp.protocol.SimpleResponse;


public class UnauthorizedResponder implements Responder
{
	public Response makeResponse(Server server, Request request) throws Exception
	{
		SimpleResponse response = new SimpleResponse(401);
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + server.realm + "\"");

		response.setContent("<html><head><title>Unauthorized</title></head><body>Unauthorized</body></html>");

		return response;
	}
}