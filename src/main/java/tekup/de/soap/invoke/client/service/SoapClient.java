package tekup.de.soap.invoke.client.service;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.xml.sax.InputSource;

import de.tekup.loan.soap.api.consume.whitetest.GetExamsRequest;
import de.tekup.loan.soap.api.consume.whitetest.GetExamsResponse;
import de.tekup.loan.soap.api.consume.whitetest.Student;
import de.tekup.loan.soap.api.consume.whitetest.StudentRequest;
import de.tekup.loan.soap.api.consume.whitetest.WhiteTestResponse;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

@Service
public class SoapClient {
	
	private WebServiceTemplate serviceTemplate;
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	public WhiteTestResponse getCertifStatus(StudentRequest request)  {
		/*
		//marshalling login.java object
		JAXBContext contextMarshall = JAXBContext.newInstance(StudentRequest.class);
		Marshaller marshaller = contextMarshall.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		java.io.StringWriter input = new StringWriter();
		marshaller.marshal(request, input);
		
		//prepare output 
		StreamSource source = new StreamSource(new StringReader(input.toString()));
		ByteArrayOutputStream bytArrayOutputStream = new ByteArrayOutputStream();
		StreamResult result = new StreamResult(bytArrayOutputStream);
		

		//call ws soap
		serviceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/ws", source, result);
		String reply = new String(bytArrayOutputStream.toByteArray());
		WhiteTestResponse response=parseXMLtoWhiteTestService(reply);
		*/
		/****************/
		serviceTemplate = new WebServiceTemplate(marshaller);
		
		 WhiteTestResponse response = ( WhiteTestResponse)serviceTemplate.
				marshalSendAndReceive("http://localhost:8080/ws", request);
		
		return response;
	}
	public GetExamsResponse getExamsStatus(GetExamsRequest request) {
		serviceTemplate = new WebServiceTemplate(marshaller);
		
		 GetExamsResponse response = (GetExamsResponse)serviceTemplate.
				marshalSendAndReceive("http://localhost:8080/ws", request);
		
		return response;
	}



}