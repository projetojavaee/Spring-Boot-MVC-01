package curso.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import curso.springboot.repository.TelefoneRepository;

@Controller
public class TelefoneController {
	
	
	@Autowired
	private TelefoneRepository telefoneRepository; //LIGA  CLASSE AO REPOSITORY

}
