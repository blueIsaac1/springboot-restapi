package com.company.nomeprojeto.tarefas.api;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.facade.TarefasFACADE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI{
    @Autowired
    private TarefasFACADE tarefasFACADE;
    //
    @PostMapping // metodo post para criar uma nova tarefa
    @ResponseBody // @ResponseBody indica que o metodo retorna um corpo de resposta
    public TarefaDTO create(@RequestBody TarefaDTO tarefaDTO){ // @RequestBody para capturar o corpo da requisicao
        return tarefasFACADE.create(tarefaDTO);
    }
    //
    @PutMapping("/{tarefaId}")  // metodo put para atualizar uma tarefa existente
    @ResponseBody
    public TarefaDTO update(@PathVariable("tarefaId") Long tarefaId, @RequestBody TarefaDTO tarefaDTO){ // @PathVariable para capturar o ID da tarefa a ser atualizada
        return tarefasFACADE.update(tarefaDTO, tarefaId);
    }
    //
    @GetMapping // metodo get que retorna todas as tarefas
    @ResponseBody
    public List<TarefaDTO> getAll(){
        return tarefasFACADE.getAll();
    }
    //
    @GetMapping("/{tarefaId}") // metodo get para obter uma tarefa por ID
    @ResponseBody
    public TarefaDTO getById(@PathVariable("tarefaId") Long tarefaId){
        return tarefasFACADE.getById(tarefaId);
    }
    //
    @DeleteMapping("/{taredaId}") // metodo delete para deletar uma tarefa por ID
    @ResponseBody
    public String delete(@PathVariable("tarefaId") Long tarefaId){
        return tarefasFACADE.delete(tarefaId);
    }
}
