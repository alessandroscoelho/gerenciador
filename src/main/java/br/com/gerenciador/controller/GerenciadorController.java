package br.com.gerenciador.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.gerenciador.domain.Todo;
import br.com.gerenciador.service.TodoService;

@RestController
@RequestMapping(value = "/gerenciador")
public class GerenciadorController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		 Todo obj = todoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listOpen() {
		List<Todo> list = todoService.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
}
