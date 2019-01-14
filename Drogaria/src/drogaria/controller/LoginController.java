package drogaria.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import drogaria.dao.ClienteDAO;
import drogaria.models.Cliente;

@Controller
public class LoginController {
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Cliente cliente, HttpSession session) {
		if (new ClienteDAO() .existeCliente(cliente)) {
			session.setAttribute("usuarioLogado", cliente);
			return "menu";
		}
		return "redirect:loginForm";
	}
}
