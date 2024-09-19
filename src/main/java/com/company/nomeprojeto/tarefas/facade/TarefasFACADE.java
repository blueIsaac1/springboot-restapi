package com.company.nomeprojeto.tarefas.facade;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefasFACADE {
    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();

    public TarefaDTO create(TarefaDTO tarefaDTO) {
        Long proximoId = tarefas.keySet().size() + 1L;
        tarefaDTO.setId(proximoId);
        tarefas.put(proximoId, tarefaDTO);
        return tarefaDTO;
    }
    //
    public TarefaDTO update(TarefaDTO tarefaDTO, Long tarefaId) {
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }
    //
    public TarefaDTO getById(Long tarefaId) {
        return tarefas.get(tarefaId);
    }   
    //
    public List<TarefaDTO> getAll() {
        return new ArrayList<>(tarefas.values());
    }
    public String delete(Long tarefaId) {
        tarefas.remove(tarefaId);
        return "Tarefa deletada com sucesso";
    }
    //
    public List<TarefaDTO> createMultiple(List<TarefaDTO> tarefaDTOs) {
        List<TarefaDTO> createdTarefas = new ArrayList<>();
        for (TarefaDTO tarefaDTO : tarefaDTOs) {
            createdTarefas.add(create(tarefaDTO));
        }
        return createdTarefas;
    }
    //
    public List<TarefaDTO> updateMultiple(List<TarefaDTO> tarefaDTOs) {
        List<TarefaDTO> updatedTarefas = new ArrayList<>();
        for (TarefaDTO tarefaDTO : tarefaDTOs) {
            if (tarefaDTO.getId() != null && tarefas.containsKey(tarefaDTO.getId())) {
                updatedTarefas.add(update(tarefaDTO, tarefaDTO.getId()));
            }
        }
        return updatedTarefas;
    }
}
