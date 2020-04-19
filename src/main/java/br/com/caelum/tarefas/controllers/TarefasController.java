package br.com.caelum.tarefas.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.model.Tarefa;

@Controller
public class TarefasController {

	private JdbcTarefaDao dao;

	@Autowired
	public TarefasController(JdbcTarefaDao dao) throws SQLException {
		this.dao = dao;
	}

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result)
			throws SQLException {
		System.out.println("URL: adicionaTarefa ");
		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		dao.adiciona(tarefa);
		return "tarefa/adicionada";

	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) throws SQLException {
		System.out.println("URL: listaTarefas ");
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) throws SQLException {
		System.out.println("URL: removeTarefa ");
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) throws SQLException {
		System.out.println("URL: mostraTarefa ");
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) throws SQLException {
		System.out.println("URL: alteraTarefa ");
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping(value = "finalizaTarefa", method = RequestMethod.POST)
	public String finaliza(Long id, Model model) throws SQLException {
		System.out.println("URL: finaliza ");
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/dataFinalizada";
	}

}
