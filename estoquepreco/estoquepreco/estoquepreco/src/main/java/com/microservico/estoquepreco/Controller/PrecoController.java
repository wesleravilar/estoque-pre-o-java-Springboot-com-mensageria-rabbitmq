package com.microservico.estoquepreco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.PrecoDTO;
import com.microservico.estoquepreco.Service.RabbitmqService;
import constantes.RabbitmqConstantes;

@RestController
@RequestMapping(value= "preco")
public class PrecoController {
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	@PutMapping
	private ResponseEntity alteraPreco(@RequestBody PrecoDTO precoDto) {
	 this.rabbitmqService.enviamensagem(RabbitmqConstantes.FILA_PRECO, precoDto);
	 return new ResponseEntity(HttpStatus.OK);
	}
}
