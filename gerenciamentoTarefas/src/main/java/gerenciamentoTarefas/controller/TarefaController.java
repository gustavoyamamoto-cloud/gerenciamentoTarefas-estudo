package gerenciamentoTarefas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gerenciamentoTarefas.service.TarefaService;

@RestController 
@RequestMapping("/tarefas")
public class TarefaController {
    
    public final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    
}
