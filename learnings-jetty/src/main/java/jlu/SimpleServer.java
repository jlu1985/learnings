package jlu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class SimpleServer {

    public static void main(String[] args) throws Exception {
        Server server = null;

        try {
            server = new Server(8000);
            server.setHandler(new AbstractHandler() {

                @Override
                public void handle(String target, Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response)
                                throws IOException, ServletException {
                    response.setContentType("application/json; charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().println(
                            "[{\"name\":\"Eren\",\"id\":3},{\"name\":\"Lisa\",\"id\":5}]");
                    baseRequest.setHandled(true);
                }
            });
            server.start();

            HttpGet hGet = new HttpGet("http://localhost:8000");
            CloseableHttpClient hc = HttpClients.createDefault();
            String output = hc.execute(hGet, new ResponseHandler<String>() {

                @Override
                public String handleResponse(HttpResponse response)
                        throws ClientProtocolException, IOException {
                    String outStr = EntityUtils.toString(response.getEntity(),
                            StandardCharsets.UTF_8);
                    return outStr;
                }
            });

            System.out.println(output);
            hc.close();
            server.stop();
        } finally {
            server.stop();
        }
    }
}
