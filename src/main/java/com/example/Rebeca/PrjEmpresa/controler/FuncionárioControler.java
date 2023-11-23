package com.example.Rebeca.PrjEmpresa.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rebeca.PrjEmpresa.entities.Departamento;
import com.example.Rebeca.PrjEmpresa.entities.Funcionário;
import com.example.Rebeca.PrjEmpresa.service.DepartamentoService;
import com.example.Rebeca.PrjEmpresa.service.FuncionárioService;

@RestController
@RequestMapping("/funcionário")
public class FuncionárioControler {



			private FuncionárioService funcionárioService = null;

			@Autowired
			public void LivroController(FuncionárioService funcionárioService) {
				this.funcionárioService = funcionárioService;
			}

			@PostMapping
			public Funcionário createclient(@RequestBody Funcionário funcionário) {
				return funcionárioService.saveFuncionário(funcionário);

			}

			@GetMapping("/{Funcodigo}")
			public ResponseEntity<Funcionário> getFuncionário(@PathVariable Long Funcodigo) {
				Funcionário funcionário = funcionárioService.getFuncionárioByFuncodigo(Funcodigo);
				if (funcionário != null) {
					return ResponseEntity.ok(funcionário);
				} else {
					return ResponseEntity.notFound().build();
				}

			}

			@GetMapping("/home")
			public String paginaInicial() {
				return "index";
			}

			@DeleteMapping("/{Funcodigo}")
			public void deleteiddepartamento(@PathVariable Long id) {
				funcionárioService.DeleteFuncionário(id);
			}

			// Utilizando o ResponseEntity e RequestEntity
			@GetMapping
			public ResponseEntity<List<Funcionário>> getAllDepartamento(RequestEntity<Void> requestEntity) {
				String method = requestEntity.getMethod().name();
				String contentType = requestEntity.getHeaders().getContentType().toString();
				List<Funcionário> funcionário = funcionárioService.getAllFuncionário();
				return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
						.body(funcionário);
			}

			@PutMapping("/{Depcodigo}")
			public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
				return funcionárioService.updateFuncionário(id, funcionário);
			}

		
	}


	

