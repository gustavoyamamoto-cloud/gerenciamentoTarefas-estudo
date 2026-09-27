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
    public ResponseEntity<ErroResponse> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex){
        
        ErroResponse resposta = new ErroResponse(
                                404, 
                                "recurso", 
                                ex.getMessage());

        return ResponseEntity
                    .status(404)
                    .body(resposta);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroResponse>> tratarValidacoes  (MethodArgumentNotValidException ex){

        List<FieldError> erros = ex.getBindingResult()
                                .getFieldErrors();

        List<ErroResponse> respostas = new ArrayList<>();
        
        for(FieldError error : erros){

            ErroResponse resposta = new ErroResponse(
                400,
                error.getField(),
                error.getDefaultMessage()
            );

            respostas.add(resposta);
        }

        return ResponseEntity
                    .status(400)
                    .body(respostas);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratarErroGenerico(Exception ex){

        ErroResponse resposta = new ErroResponse(
                                500, 
                                "Erro", 
                                "Ocorreu um erro inesperado");

        return ResponseEntity
                        .status(500)
                        .body(resposta);
    }
}
