package drogaria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import drogaria.dao.ClienteDAO;
import drogaria.models.Usuario;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o formulario do cadastrar o cliente");
		return "Cliente/form";
	}

	@PostMapping("/executarCadastro")
	public String adicionar(Usuario usuario) {
		System.out.println(usuario);
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(usuario);
		return "Cliente/ClienteCadastrado";
	}

	@GetMapping("/ListarCliente")
	public ModelAndView listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Usuario> lista = clienteDAO.getLista();
		ModelAndView model = new ModelAndView("Cliente/ListarCliente");
		model.addObject("usuario", lista);
		return model;
	}

	@RequestMapping("remover")
	public ModelAndView remover(Usuario cliente) {
		System.out.println("Chamou o metodo remover cliente");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.remover(cliente);
		return listar();
	}

}
