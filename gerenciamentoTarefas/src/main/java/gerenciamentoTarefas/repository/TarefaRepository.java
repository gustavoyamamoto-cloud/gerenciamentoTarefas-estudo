package gerenciamentoTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gerenciamentoTarefas.entity.Tarefa;

@Repository 
public interface TarefaRepository extends JpaRepository<Long, Tarefa>{
    
}
