package gerenciamentoTarefas.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalHandler {
    
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<?> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex){
        
        return ResponseEntity
                    .status(404)
                    .body(ex.getMessage());
    }


    // Trata erros de validação do @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroResponse>> tratarValidacoes  (MethodArgumentNotValidException ex){

        // Pega todos os erros de validação
        List<FieldError> erros = ex.getBindingResult()
                                .getFieldErrors();

        // Cria uma lista para guardar nossas respostas de erro
        List<ErroResponse> respostas = new ArrayList<>();
        
        // Percorre cada erro individualmente
        for(FieldError error : erros){

            // Cria um objeto com os dados do erro
            ErroResponse resposta = new ErroResponse(
                400,
                error.getField(),
                error.getDefaultMessage()
            );

            respostas.add(resposta);
        }

        // Retorna HTTP 400 + todos os erros
        return ResponseEntity
                    .status(400)
                    .body(respostas);
    }
}
