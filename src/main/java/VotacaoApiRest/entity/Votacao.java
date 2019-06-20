package VotacaoApiRest.entity;

import java.util.Calendar;
import java.util.Date;

public class Votacao {

    private Long id;
    private String nomeRestaurante;
    private Date dataVotacao;
    private String nomeProfissional;
    private Integer voto;
    private String descricao;

    public Votacao() {
        Calendar calendar = Calendar.getInstance();
        this.dataVotacao = calendar.getTime();
        this.voto = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public Date getDataVotacao() {
        return dataVotacao;
    }

    public void setDataVotacao(Date dataVotacao) {
        this.dataVotacao = dataVotacao;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
