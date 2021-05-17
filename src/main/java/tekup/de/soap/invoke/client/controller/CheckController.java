package tekup.de.soap.invoke.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.soap.api.consume.whitetest.GetExamsRequest;
import de.tekup.loan.soap.api.consume.whitetest.GetExamsResponse;
import de.tekup.loan.soap.api.consume.whitetest.StudentRequest;
import de.tekup.loan.soap.api.consume.whitetest.WhiteTestResponse;
import tekup.de.soap.invoke.client.service.SoapClient;

@Controller
public class CheckController {
	@Autowired
	private SoapClient client;
	
	@GetMapping("/check/certif")
	public String studentForm(Model model) {
		StudentRequest request = new StudentRequest();
		model.addAttribute("request", request);
		return "request";
	}
	
	@PostMapping("/check/certif")
	public String studentCheck(@ModelAttribute("request") StudentRequest request, Model model) {
		//invoke de service web
		WhiteTestResponse response = client.getCertifStatus(request);
		model.addAttribute("response", response);
		return "response";
	}
	@GetMapping("/check/exams")
	public String examForm(Model model) {
		GetExamsRequest request = new GetExamsRequest();
		model.addAttribute("requestExam", request);
		return examCheck(request,model);
		//return "requestExam";
		
	}
	
	@PostMapping("/check/exams")
	public String examCheck(@ModelAttribute("request") GetExamsRequest request, Model model) {
		//invoke de service web
		GetExamsResponse response = client.getExamsStatus(request);
		model.addAttribute("responseExam", response);
		return "responseExam";
	}
	
	//Home page
	@GetMapping("/")
	public String home(Model model) {
		
		return "index";
	}
	
}
