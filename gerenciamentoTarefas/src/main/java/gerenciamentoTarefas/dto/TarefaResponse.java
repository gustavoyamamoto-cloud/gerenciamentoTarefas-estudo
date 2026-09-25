package gerenciamentoTarefas.dto;

import java.time.LocalDate;

import ch.qos.logback.core.status.Status;

public class TarefaResponse {
    
    private Long id;
    private String titulo;
    private String descricao;
    private Status status;
    private LocalDate dataCriacao;

    public TarefaResponse(Long id, String titulo, String descricao, Status status, LocalDate dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
