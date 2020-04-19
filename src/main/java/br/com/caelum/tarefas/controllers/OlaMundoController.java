package br.com.caelum.tarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring")
	public String execute(){
		System.out.println("Executando a lógica do Spring MVC");
		return "ok";
	}
	
}
