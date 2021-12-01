import br.com.paulorjuniorp.abstracaobootcamp.dominio.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Curso curso = new Curso();
        curso.setTitulo("Java e Orientação a Objetos");
        curso.setDescricao("Fundamentos para o aprendizado de Java e do paradigma de Orientação a Objetos");
        curso.setCargaHoraria(80);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aplicando Java e Orientação a Objetos na prática");
        mentoria.setDescricao("Um dos fundamentos mais importantes no aprendizado é a aplicação do conhecimento adquirido");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcampJava = new Bootcamp();
        bootcampJava.setNome("Formação Java para iniciantes");
        bootcampJava.setDescricao("Bootcamp voltado para você que deseja se tornar um desenvolvedor Java");
        Set<Conteudo> conteudos = new LinkedHashSet<>();
        conteudos.add(curso);
        conteudos.add(mentoria);
        bootcampJava.setConteudos(conteudos);

        Dev dev = new Dev();
        dev.setNome("Courtney Laplante");
        dev.setConteudosInscrito(conteudos);
        dev.inscreverBootcamp(bootcampJava);
        dev.progredir();
        System.out.println("Xp: " + dev.calcularXPGanho());
    }
}
