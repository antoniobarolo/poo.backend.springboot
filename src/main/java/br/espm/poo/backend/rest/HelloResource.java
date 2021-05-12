package br.espm.poo.backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.espm.poo.backend.datatype.MessageBean;

@RestController
public class HelloResource {

	@RequestMapping(path = "/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping(path = "/html")
	public String html() {
		return "<h1 style='color:red'>Hello World!</h1>";
	}
	
	
	@RequestMapping(path = "/mensagem")
	public MessageBean message() {
		MessageBean m = new MessageBean();
		m.setMessage("Bom dia");
		return m;
	}
}
