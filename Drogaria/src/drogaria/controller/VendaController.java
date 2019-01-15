package drogaria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import drogaria.dao.ClienteDAO;
import drogaria.dao.RemedioDAO;
import drogaria.dao.VendaDAO;
import drogaria.models.Remedio;
import drogaria.models.Cliente;
import drogaria.models.Venda;

@Controller

public class VendaController {
	@RequestMapping("/Venda/formVenda")
	public ModelAndView form() {
		System.out.println("Chamou método form");
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> listaCliente = clienteDAO.getLista();
		RemedioDAO remedioDAO = new RemedioDAO();
		List<Remedio> listaRemedio = remedioDAO.getLista();
		ModelAndView model = new ModelAndView("Venda/formVenda");
		model.addObject("clientes", listaCliente);
		model.addObject("remedios", listaRemedio);
		return model;

	}
	
	@PostMapping("/Venda/formVenda")
	public String Adicionarvenda(Venda venda) {
		System.out.println(venda);
		VendaDAO vendaDAO = new VendaDAO();
				vendaDAO.inserir(venda);
		return "Venda/VendaEfetuada";
	}


	@GetMapping("/Venda/ListarVenda")
	public ModelAndView listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> listaVenda = vendaDAO.getLista();
		ModelAndView model = new ModelAndView("Venda/ListarVenda");
		model.addObject("vendas", listaVenda);
		return model;
	}


	//@RequestMapping("/Venda/Efetuada")
	public String devolucao(Venda venda) {
		System.out.println("Chamou o método efetuada");
		VendaDAO vendaDAO = new VendaDAO();
		System.out.println(venda);
		vendaDAO.efetuada(venda);
		
		return "redirect:../venda/ListarVenda";
	

	}
	@RequestMapping("/Venda/remover")
	public ModelAndView remover(Venda venda) {
		System.out.println("Chamou o metodo remover venda");
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.remover(venda);
		return listar();
	}


}
