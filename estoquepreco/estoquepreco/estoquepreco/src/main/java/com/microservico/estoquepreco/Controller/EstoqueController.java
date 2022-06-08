package com.microservico.estoquepreco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.EstoqueDTO;
import com.microservico.estoquepreco.Service.RabbitmqService;
import constantes.RabbitmqConstantes;

@RestController
@RequestMapping(value= "estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDto) {
	this.rabbitmqService.enviamensagem(RabbitmqConstantes.FILA_ESTOQUE, estoqueDto);
	 return new ResponseEntity(HttpStatus.OK);
	}
}
