package gerenciamentoTarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gerenciamentoTarefas.dto.TarefaResponse;
import gerenciamentoTarefas.repository.TarefaRepository;

@Service 
public class TarefaService {

    public final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    
    //Listar
    public List<TarefaResponse> listar(){
        return repository.findAll()
                            .stream()
                            .map(t -> new TarefaResponse(
                                t.getId(),
                                t.getTitulo(),
                                t.getDescricao(),
                                t.getStatus(),
                                t.getDataCriacao())
                            )
                            .toList();
    }
}
