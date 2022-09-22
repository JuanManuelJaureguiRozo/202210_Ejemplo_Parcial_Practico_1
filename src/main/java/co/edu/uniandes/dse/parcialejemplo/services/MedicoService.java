package co.edu.uniandes.dse.parcialejemplo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.MedicoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {

	@Autowired
	MedicoRepository medicoRepository;

	/**
	 * Devuelve todos los médicos que hay en la base de datos.
	 *
	 * @return Lista de entidades de tipo médico.
	 */
	@Transactional
	public List<MedicoEntity> getMedicos() {
		log.info("Inicia proceso de consultar todos los médicos");
		return medicoRepository.findAll();
	}

}
