package com.example.Rebeca.PrjEmpresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.Rebeca.PrjEmpresa.entities.Departamento;
import com.example.Rebeca.PrjEmpresa.entities.Funcionário;
import com.example.Rebeca.PrjEmpresa.repository.DepartamentoRepository;
import com.example.Rebeca.PrjEmpresa.repository.FuncionárioRepository;

@Service
public class FuncionárioService {
		
		private FuncionárioRepository FuncionárioRepository;
	

		@Autowired
		public FuncionárioService(FuncionárioRepository funcionárioRepository) {
		this.FuncionárioRepository = funcionárioRepository;
		}

		public Funcionário getFuncionárioByDepcodigo(Long Funcodigo) {
			return FuncionárioRepository.findById(Funcodigo).orElse(null);

		}

		public List<Funcionário> getAllFuncionário() {
			return FuncionárioRepository.findAll();
		}

		public Funcionário saveFuncionário(Funcionário funcionário) {
			return FuncionárioRepository.save(funcionário);
		}

		public void DeleteFuncionário(Long Funcodigo) {
			FuncionárioRepository.deleteById(Funcodigo);
		}

		// fazendo o update do livro com o optional
		public Departamento updateDepartamento(Long Funcodigo, Funcionário novoFuncionário) {
			CrudRepository<Departamento, Long> funcionárioRepository;
			Optional<Funcionário> FuncionárioOptional = FuncionárioRepository.findById(Funcodigo);
			if (FuncionárioOptional.isPresent()) {
				Funcionário FuncionárioExistente = FuncionárioOptional.get();
				FuncionárioExistente.setFunnome(novoFuncionário.getFunnome());
				return funcionárioRepository.save(FuncionárioExistente);
			} else {
				return null;
			}
		}

	}

	

