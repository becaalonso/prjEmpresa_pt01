package com.example.Rebeca.PrjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tbFuncionário")
public class Funcionário {

	
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long Funcodigo;

			@NotNull
			@NotBlank
			private String Funnome;

			@NotNull
			@NotBlank
			@DateTimeFormat(pattern = "dd/MM/yyyy")
			   private LocalDate funnascimento;
			private String Funnascimento;
			
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long Funsalario;
			
			public Funcionário() {
				
			}
			
			public Funcionário(Long Funcodigo, Long Funsalario , String Funnome, String descricao, String Funnascimento) {
				super();
				this.Funcodigo = Funcodigo;
		        this.Funnome = Funnome;
				this.Funnascimento = Funnascimento;
				this.Funsalario = Funsalario;
			}



			public Long getFuncodigo() {
				return Funcodigo;
			}

			public void setId(Long Funcodigo) {
				this.Funcodigo = Funcodigo;
			}

			public String getFunnome() {
				return Funnome;
			}

			public void setFunnome(String Funnome) {
				this.Funnome = Funnome;
			}

			public String getFunnascimento() {
				return Funnascimento;
			}

			public void setDescricao(String descricao) {
				this.Funnascimento = descricao;
			}
			
			public Long getFunsalario() {
				return Funsalario;
			}

			public void setFunsalario(Long Funsalario) {
				this.Funsalario = Funsalario;
			}
			

		}

		
	

