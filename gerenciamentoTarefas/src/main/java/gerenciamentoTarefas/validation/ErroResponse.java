package gerenciamentoTarefas.validation;

public class ErroResponse {
    
    private int status;
    private String campo;
    private String mensagem;

    public ErroResponse(int status, String campo, String mensagem) {
        this.status = status;
        this.campo = campo;
        this.mensagem = mensagem;
    }

    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getCampo() {
        return campo;
    }
    public void setCampo(String campo) {
        this.campo = campo;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    
}
