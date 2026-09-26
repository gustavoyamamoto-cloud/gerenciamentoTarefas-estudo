package gerenciamentoTarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gerenciamentoTarefas.dto.TarefaRequest;
import gerenciamentoTarefas.dto.TarefaResponse;
import gerenciamentoTarefas.entity.Tarefa;
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

    //Cadastrar
    public TarefaResponse cadastrar(TarefaRequest novaTarefa){

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(novaTarefa.getTitulo());
        tarefa.setDescricao(novaTarefa.getDescricao());
        tarefa.setStatus(novaTarefa.getStatus());
        tarefa.setDataCriacao(novaTarefa.getDataCriacao());

        repository.save(tarefa);

        return new TarefaResponse(
                                tarefa.getId(),
                                tarefa.getTitulo(),
                                tarefa.getDescricao(),
                                tarefa.getStatus(),
                                tarefa.getDataCriacao()
                    );

    }
}
