package jlu.shop.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jlu.shop.domain.Customer;

@Path("/customers")
public class CustomerResource {

	private Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
	private AtomicInteger idCounter = new AtomicInteger();

	@POST
	@Consumes("application/xml")
	public Response createCustomer(InputStream is) {
		Customer customer = readCustomer(is);
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		System.out.println("Created customer" + customer.getId());

		return Response.created(URI.create("/customers/" + customer.getId())).build();
	}

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public StreamingOutput getCustomer(@PathParam("id") int id) {
		final Customer customer = customerDB.get(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return new StreamingOutput() {

			@Override
			public void write(OutputStream outputStream) throws IOException, WebApplicationException {
				outputCustomer(outputStream, customer);
			}
		};

	}

	@PUT
	@Path("{id}")
	@Consumes("application/xml")
	public void updateCustomer(@PathParam("id") int id, InputStream is) {
		Customer update = readCustomer(is);
		Customer current = customerDB.get(id);
		if (current == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		current.setFirstname(update.getFirstname());
		current.setLastname(update.getLastname());
		current.setStreet(update.getStreet());
		current.setState(update.getState());
		current.setZip(update.getZip());
		current.setCountry(update.getCountry());
	}

	protected void outputCustomer(OutputStream os, Customer cust) throws IOException {
		PrintStream writer = new PrintStream(os);
		writer.println("<customer id=\"" + cust.getId() + "\">");
		writer.println("  <first-name>" + cust.getFirstname() + "</first-name>");
		writer.println("  <last-name>" + cust.getLastname() + "</last-name>");
		writer.println("  <street>" + cust.getStreet() + "</street>");
		writer.println("  <state>" + cust.getState() + "</state>");
		writer.println("  <zip>" + cust.getZip() + "</zip>");
		writer.println("  <country>" + cust.getCountry() + "</country>");
		writer.println("</customer>");
	}

	protected Customer readCustomer(InputStream is) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(is);
			Element root = doc.getDocumentElement();

			Customer cust = new Customer();
			if (root.getAttribute("id") != null && !root.getAttribute("id").trim().equals("")) {
				cust.setId(Integer.valueOf(root.getAttribute("od")));
			}
			NodeList nodes = root.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node element = (Node) nodes.item(i);
				if (element.getNodeName().equals("first-name")) {
					cust.setFirstname(element.getTextContent());
				} else if (element.getNodeName().equals("last-name")) {
					cust.setLastname(element.getTextContent());
				} else if (element.getNodeName().equals("street")) {
					cust.setLastname(element.getTextContent());
				} else if (element.getNodeName().equals("city")) {
					cust.setLastname(element.getTextContent());
					cust.setLastname(element.getTextContent());
				} else if (element.getNodeName().equals("state")) {
					cust.setLastname(element.getTextContent());
				} else if (element.getNodeName().equals("zip")) {
					cust.setLastname(element.getTextContent());
				} else if (element.getNodeName().equals("country")) {
					cust.setLastname(element.getTextContent());
				}
			}
			return cust;
		} catch (Exception e) {
			throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
		}
	}
}
