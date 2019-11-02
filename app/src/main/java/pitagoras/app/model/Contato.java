package pitagoras.app.model;

public class Contato {

    private String nome;
    private String mensagem;
    private String horas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public Contato(String nome, String mensagem, String horas) {
        this.nome = nome;
        this.mensagem = mensagem;
        this.horas = horas;
    }
}
