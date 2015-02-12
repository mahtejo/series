package models;

import javax.persistence.*;

/**
 * Created by M on 09/02/2015.
 */

@Entity(name = "Episodio")
public class Episodio {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private int numero;

    @Column
    private boolean assistido;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn
    Temporada temporada;

    public Episodio(String nome, Temporada temporada, int numero) throws Exception {
        setNome(nome);
        setTemporada(temporada);
        setNumero(numero);
        this.assistido = false;
    }

    public Episodio(){}

    public void setNome(String nome) throws Exception {
        if (nome.equals("")){
            throw new Exception("Por favor, digite um nome para o episódio.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }


    public boolean isAssistido() {
        return assistido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTemporada(Temporada temporada) throws Exception {
        if(temporada == null){
            throw new Exception("Insira uma temporada válida!");
        }
        this.temporada = temporada;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setNumero(int numero) throws Exception {
        if (numero < 0){
            throw new Exception("Um episódio não deve ser negativo!");
        }
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}


