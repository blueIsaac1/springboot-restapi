package com.company.nomeprojeto.controller;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.facade.TarefasFACADE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping({"/tarefas", "/tarefas/"})
public class TarefaController {

    private static final Logger logger = LoggerFactory.getLogger(TarefaController.class);
    @Autowired
    private TarefasFACADE tarefasFACADE;

    @GetMapping({"/", ""})
    public String listTarefas(Model model) {
        logger.info("Entering listTarefas method");
        try {
            List<TarefaDTO> tarefas = tarefasFACADE.getAll();
            logger.info("Number of tarefas: {}", tarefas.size());
            model.addAttribute("tarefas", tarefas);
            logger.info("Model attribute added");
            logger.info("Returning view: tarefas/list");
            return "tarefas/list";
        } catch (Exception e) {
            logger.error("Error in listTarefas method", e);
            throw e;
        }
    }
    
    

    @GetMapping("/new")
    public String newTarefaForm(Model model) {
        model.addAttribute("tarefa", new TarefaDTO());
        return "tarefas/form";
    }

    @PostMapping
    public String createTarefa(@ModelAttribute TarefaDTO tarefa) {
        tarefasFACADE.create(tarefa);
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}/edit")
    public String editTarefaForm(@PathVariable Long id, Model model) {
        model.addAttribute("tarefa", tarefasFACADE.getById(id));
        return "tarefas/form";
    }

    @PostMapping("/{id}")
    public String updateTarefa(@PathVariable Long id, @ModelAttribute TarefaDTO tarefa) {
        tarefasFACADE.update(tarefa, id);
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}/delete")
    public String deleteTarefa(@PathVariable Long id) {
        tarefasFACADE.delete(id);
        return "redirect:/tarefas";
    }
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        logger.info("Test endpoint called");
        return "TarefaController is working!";
    }
}