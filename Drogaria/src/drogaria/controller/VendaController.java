/*package drogaria.controller;

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
import drogaria.models.Usuario;
import drogaria.models.Venda;

@Controller

public class VendaController {
	@RequestMapping("/Venda/formVenda")
	public ModelAndView form() {
		System.out.println("Chamou método form");
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Usuario> listaCliente = clienteDAO.getLista();
		RemedioDAO remedioDAO = new RemedioDAO();
		List<Remedio> listaRemedio = remedioDAO.getLista();
		ModelAndView model = new ModelAndView("venda/formEmp");
		model.addObject("usuario", listaCliente);
		model.addObject("remedio", listaRemedio);
		return model;

	}
	
	@PostMapping("/Venda/formVenda")
	public String Adicionarvenda(Venda venda) {
		System.out.println(venda);
		VendaDAO vendaDAO = new VendaDAO();
				vendaDAO.inserir(venda);
		return "Venda/VendaEfetuada";
	}


	@GetMapping("/Venda/ListarVendas")
	public ModelAndView listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> listaVenda = vendaDAO.getLista();
		ModelAndView model = new ModelAndView("Venda/ListarVendas");
		model.addObject("venda", listaVenda);
		return model;
	}


	//@RequestMapping("/Venda/Efetuada")
	public String devolucao(Venda venda) {
		System.out.println("Chamou o método efetuada");
		VendaDAO vendaDAO = new VendaDAO();
		System.out.println(venda);
		vendaDAO.efetuada(venda);
		
		return "redirect:../venda/ListarVendas";
	

	}
	@RequestMapping("/Venda/remover")
	public ModelAndView remover(Venda venda) {
		System.out.println("Chamou o metodo remover venda");
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.remover(venda);
		return listar();
	}

}
*/