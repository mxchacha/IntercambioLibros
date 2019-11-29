package com.example.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyecto.models.entities.DetalleIntercambio;
import com.example.proyecto.models.service.IDetalleIntercambioService;


public class DetalleIntercambioController {

	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private  IDetalleIntercambioService service;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		DetalleIntercambio detalle = new DetalleIntercambio();
		model.addAttribute("Detalle Intercambio", detalle); //El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo Detalle de Intercambio");
		return "detalle/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		DetalleIntercambio detalle= service.findById(id);
		model.addAttribute("Detalle Intercambio", detalle);
		model.addAttribute("title", "Detalle de Intercambio");
		return "detalle/card";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo eliminarse"); //El model sirve para la misma vista no si se cambia de vista
			ex.getStackTrace();
		}
		return "redirect:/detalle/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String updatelibroa(@PathVariable(value="id") Integer id, Model model) {
		DetalleIntercambio detalle = service.findById(id);
		model.addAttribute("Detalle Intercambio", detalle);
		model.addAttribute("title", "Actualizar Detalle de Intercambio: " + detalle.getTituloLibroa());
		return "detalle/form";
	}
	
	@GetMapping(value="/update/{id}")
	public String updatelibrob(@PathVariable(value="id") Integer id, Model model) {
		DetalleIntercambio detalle = service.findById(id);
		model.addAttribute("Detalle Intercambio", detalle);
		model.addAttribute("title", "Actualizar Detalle de Intercambio: " + detalle.getTituloLibrob());
		return "detalle/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<DetalleIntercambio> list = service.findAll();
		model.addAttribute("tittle", "Listado de detalle de Intercambio");
		model.addAttribute("list", list);
		return "detalle/list";
	}
	
	@PostMapping(value="/save")
	public String save(DetalleIntercambio detalle, Model model, RedirectAttributes flash) {
		try {
			service.save(detalle); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/detalle/list";
	}
}
