package gerenciamentoTarefas.service;

import org.springframework.stereotype.Service;

import gerenciamentoTarefas.repository.TarefaRepository;

@Service 
public class TarefaService {

    public final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    
}
