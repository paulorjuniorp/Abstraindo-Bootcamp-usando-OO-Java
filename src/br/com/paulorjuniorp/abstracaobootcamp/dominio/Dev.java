package br.com.paulorjuniorp.abstracaobootcamp.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscrito = new LinkedHashSet<>();
    private Set<Conteudo> conteudosFinalizado = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscrito.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscrito.stream().findFirst();
        if (conteudo.isPresent()){
            this.conteudosFinalizado.add(conteudo.get());
            this.conteudosInscrito.remove(conteudo.get());
        }else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularXPGanho(){
        return this.conteudosFinalizado.stream().mapToDouble(conteudo -> conteudo.calcularXP()).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscrito() {
        return conteudosInscrito;
    }

    public void setConteudosInscrito(Set<Conteudo> conteudosInscrito) {
        this.conteudosInscrito = conteudosInscrito;
    }

    public Set<Conteudo> getConteudosFinalizado() {
        return conteudosFinalizado;
    }

    public void setConteudosFinalizado(Set<Conteudo> conteudosFinalizado) {
        this.conteudosFinalizado = conteudosFinalizado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscrito, dev.conteudosInscrito) && Objects.equals(conteudosFinalizado, dev.conteudosFinalizado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscrito, conteudosFinalizado);
    }
}
