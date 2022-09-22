package co.edu.uniandes.dse.parcialejemplo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.parcialejemplo.dto.MedicoDTO;
import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.services.MedicoService;

/**
 * Clase que implementa el recurso "medicos".
 *
 * @author ISIS2603
 */
@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Busca y devuelve todos los médicos que existen en la aplicacion.
	 *
	 * @return JSONArray {@link MedicoDTO} - Los médicos encontrados en la
	 *         aplicación. Si no hay ninguno retorna una lista vacía.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<MedicoDTO> findAll() {
		List<MedicoEntity> medicos = medicoService.getMedicos();
		return modelMapper.map(medicos, new TypeToken<List<MedicoDTO>>() {
		}.getType());
	}
    
}
