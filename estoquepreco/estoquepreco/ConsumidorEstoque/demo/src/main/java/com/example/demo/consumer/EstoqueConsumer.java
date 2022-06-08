package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import DTO.EstoqueDTO;
import constantes.RabbitmqConstantes;

@Component
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
	private void consumidor(EstoqueDTO estoqueDto) {
		
	}

}
