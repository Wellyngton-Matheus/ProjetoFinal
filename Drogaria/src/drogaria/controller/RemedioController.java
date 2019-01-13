package drogaria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import drogaria.dao.RemedioDAO;
import drogaria.models.Remedio;

@RequestMapping("/Remedio")
@Controller
public class RemedioController {
		@RequestMapping("/AddRemedio")
		public String form() {
			System.out.println("Chamou o form do Remedio");
			return "Remedio/AddRemedio";
		}

		@PostMapping("/executarCadastro")
		public String adicionar(Remedio remedio) {
			System.out.println(remedio);
			RemedioDAO remedioDAO = new RemedioDAO();
			remedioDAO.inserir(remedio);
			return "Remedio/RemedioCadastrado";
		}

		@GetMapping("/ListarRemedio")
		public ModelAndView listar() {
			RemedioDAO remedioDAO = new RemedioDAO();
			List<Remedio> lista = remedioDAO.getLista();
			ModelAndView model = new ModelAndView("Remedio/ListarRemedio");
			model.addObject("remedio", lista);
			return model;
		}

		@RequestMapping("remover")
		public ModelAndView remover(Remedio remedio) {
			System.out.println("Chamou o metodo remover Remedio");
			RemedioDAO remedioDAO = new RemedioDAO();
			remedioDAO.remover(remedio);
			return listar();
		}

	}

