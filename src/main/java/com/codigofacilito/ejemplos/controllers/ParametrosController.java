package com.codigofacilito.ejemplos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.codigofacilito.ejemplos.models.Equipo;
import com.codigofacilito.ejemplos.models.Jugador;

@Controller
public class ParametrosController {

	@GetMapping("/parametros")
	public String parametros(@RequestParam(defaultValue = "") String valor, Model model) {
		model.addAttribute("titulo", "Parametros");
		model.addAttribute("parametro", valor);

		return "parametros";
	}

	@GetMapping("/equipos/{nombre}/{numero}")
	public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model) {

		Optional<Equipo> equipoOptional = getEquipos().stream()
				.filter(equipo -> nombre.toLowerCase().equals(equipo.getNombre().toLowerCase())).findFirst();

		if (equipoOptional.isPresent()) {
			Optional<Jugador> jugadorOptional = equipoOptional.get().getPlantilla().stream()
					.filter(jugador -> numero == jugador.getNumero()).findFirst();
			if(jugadorOptional.isPresent()) {
				model.addAttribute("juador",jugadorOptional.get());
			}
		}
		return "parametros";
	}

	private List<Equipo> getEquipos() {
		Equipo barcelona = new Equipo();
		barcelona.setNombre("Barcelona");
		barcelona.addJugador(new Jugador("Ter Stegen", 1));
		barcelona.addJugador(new Jugador("Araujo", 2));
		barcelona.addJugador(new Jugador("Busquets", 6));
		barcelona.addJugador(new Jugador("Messi", 10));

		Equipo realMadrid = new Equipo();
		realMadrid.setNombre("Real Madrid");
		realMadrid.addJugador(new Jugador("Vinicius", 1));
		realMadrid.addJugador(new Jugador("Benzema", 2));
		realMadrid.addJugador(new Jugador("Xhavi", 6));
		realMadrid.addJugador(new Jugador("Cristiano", 7));

		return List.of(barcelona, realMadrid);
	}
}
