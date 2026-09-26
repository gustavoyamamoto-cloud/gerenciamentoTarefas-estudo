package gerenciamentoTarefas.dto;

import java.time.LocalDate;

import gerenciamentoTarefas.entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class TarefaRequest {
    
    @NotBlank(message = "titulo obrigatorio")
    @Size(min = 3)
    private String titulo;

    @NotBlank(message = "Descrição obrigatoria")
    private String descricao;

    @NotNull(message = "Status obrigatorio")
    private Status status;

    @NotNull(message = "Data obrigatoria")
    @PastOrPresent(message = "Data deve ser passada ou presente")
    private LocalDate dataCriacao;

    public TarefaRequest() {}

    public TarefaRequest(String titulo, String descricao, Status status, LocalDate dataCriacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
 
    
}
