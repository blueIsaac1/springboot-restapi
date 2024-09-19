package com.company.nomeprojeto.config;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.facade.TarefasFACADE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private TarefasFACADE tarefasFACADE;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            TarefaDTO tarefa1 = new TarefaDTO();
            tarefa1.setTitulo("Comprar leite");
            tarefa1.setDescricao("Ir ao supermercado e comprar leite");
            tarefasFACADE.create(tarefa1);

            TarefaDTO tarefa2 = new TarefaDTO();
            tarefa2.setTitulo("Estudar Spring Boot");
            tarefa2.setDescricao("Revisar conceitos de Spring Boot e fazer exercícios");
            tarefasFACADE.create(tarefa2);

            logger.info("Dados iniciais carregados. Número de tarefas: {}", tarefasFACADE.getAll().size());
        };
    }
}