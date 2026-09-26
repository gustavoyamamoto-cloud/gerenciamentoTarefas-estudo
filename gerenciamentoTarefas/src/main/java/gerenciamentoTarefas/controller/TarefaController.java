package gerenciamentoTarefas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gerenciamentoTarefas.dto.TarefaRequest;
import gerenciamentoTarefas.dto.TarefaResponse;
import gerenciamentoTarefas.service.TarefaService;
import jakarta.validation.Valid;

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

    @PostMapping
    public TarefaResponse cadastrar(@Valid @RequestBody TarefaRequest novaTarefa){
        return service.cadastrar(novaTarefa);
    } 

    @GetMapping("/{id}")
    public TarefaResponse buscar(@PathVariable Long id){
        return service.buscar(id);
    }

}
