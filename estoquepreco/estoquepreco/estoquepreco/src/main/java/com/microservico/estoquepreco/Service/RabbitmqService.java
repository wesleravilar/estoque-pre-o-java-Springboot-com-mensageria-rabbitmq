package com.microservico.estoquepreco.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitmqService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	// serializa e desserializa objetos java em jason
	@Autowired
	private ObjectMapper objectMapper;
	
	public void enviamensagem(String nomeFila, Object mensagem) {
	 try {
	  String mensagemJson = this.objectMapper.writeValueAsString(mensagem);
	  this.rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	}
}
