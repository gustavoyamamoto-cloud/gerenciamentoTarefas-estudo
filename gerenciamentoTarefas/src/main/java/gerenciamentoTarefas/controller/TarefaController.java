package gerenciamentoTarefas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gerenciamentoTarefas.dto.TarefaResponse;
import gerenciamentoTarefas.service.TarefaService;

@RestController 
@RequestMapping("/tarefas")
public class TarefaController {
    
    public final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    
    @GetMapping 
    public List<TarefaResponse> listar(){
        return service.listar();
    }
}
