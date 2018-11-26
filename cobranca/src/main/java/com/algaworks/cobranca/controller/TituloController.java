package com.algaworks.cobranca.controller;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@ModelAttribute(name="listaStatusTitulo")
	public List<StatusTitulo> statusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		// TODO: Salvar no banco de dados
		titulos.save(titulo);
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Salvo com sucesso!");
		
		return mv;
	}
	
	@RequestMapping  
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView("PesquisaTitulo");
		Double inicio =  (double) (System.currentTimeMillis());
		
		Double fim = (double) System.currentTimeMillis();
		DecimalFormat df = new DecimalFormat("#0.00");
		mv.addObject("mensagemCaption", "Foram retornado(s) " + 0 + " resultado(s) (" + df.format((fim - inicio) / 100) + " segundos)");
		
		return mv;
	}
}
