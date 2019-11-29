package com.example.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyecto.models.entities.Libro;
import com.example.proyecto.models.service.ILibroService;

@Controller
@RequestMapping(value="/libro")
public class LibroController {
	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private  ILibroService service;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Libro libro= new Libro();
		model.addAttribute("libro", libro); //El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo libro");
		return "libro/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Libro libro = service.findById(id);
		model.addAttribute("libro", libro);
		model.addAttribute("title", "Detalle de libro");
		return "libro/card";
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
		return "redirect:/libro/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Libro libro= service.findById(id);
		model.addAttribute("libro", libro);
		model.addAttribute("title", "Actualizar título del libro: " + libro.getTitulo());
		return "libro/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Libro> list = service.findAll();
		model.addAttribute("tittle", "Listado de libros");
		model.addAttribute("list", list);
		return "libro/list";
	}
	
	@PostMapping(value="/save")
	public String save(@Valid Libro libro, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(libro.getIdlibro() == null) {
					model.addAttribute("title","Registro de un nuevo Libro");					
				}
				else {
					model.addAttribute("tittle","Actualizando el registro de " 
							+ libro.getTitulo());
				}
				return"libro/form";
		}
			service.save(libro); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
			
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/libro/list";
	}

}
