package com.ranking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ranking.model.Posto;
import com.ranking.repository.PostoRepository;

@Controller
public class PostoController {
	
	@Autowired
	private PostoRepository postoRepo;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		List<Posto> postosRanking = postoRepo.findAllByOrderByPrecoGasolinaAsc();
		
		mv.addObject("postosRankingList", postosRanking);
		
		return mv;
	}
	
	@RequestMapping("/postos/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroPosto");
		mv.addObject(new Posto());
		return mv;
	}
	
	@RequestMapping("/postos")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("listagem");
		List<Posto> postos = postoRepo.findAll();
		mv.addObject("postosList", postos);
		return mv;
	}
	
	@RequestMapping(value="/postos", method=RequestMethod.POST)
	public String salva(@Validated Posto posto, Errors errors, RedirectAttributes attributes) {
		
		if (errors.hasErrors()) {
			return "cadastroPosto";
		}
		
		postoRepo.save(posto);
		attributes.addFlashAttribute("mensagem", "Posto salvo com sucesso!");
		return "redirect:/postos/novo";
		
	}
	
	@RequestMapping("/postos/{id}")
	public ModelAndView edicao(@PathVariable("id") Posto posto) {
		ModelAndView mv = new ModelAndView("cadastroPosto");
		
		mv.addObject(posto);
		
		return mv;
	}
	
	@RequestMapping(value="/postos/{id}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		postoRepo.delete(id);
		attributes.addFlashAttribute("mensagem", "Registro excluído com sucesso!");
		return "redirect:/postos";
	}
	
	
	
	
	
	
}






