import entities.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        course.setTitle("Curso");
        course.setDescription("Descrição");
        course.setWorkload(0);

        Mentorship mentorship = new Mentorship();
        mentorship.setTitle("Título");
        mentorship.setDescription("Descrição");
        mentorship.setDate(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Título");
        bootcamp.setDescription("Descrição");
        bootcamp.getContents().add(course);
        bootcamp.getContents().add(mentorship);

        Dev dev = new Dev();
        dev.setName("Nome");
        dev.subscribeBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos:\n" + dev.getContentsSubscribed());
        dev.toProgress();
        dev.toProgress();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos:\n" + dev.getContentsSubscribed());
        System.out.println("-");
        System.out.println("Conteúdos Concluídos:\n" + dev.getContentsDone());
        System.out.println("XP:" + dev.calculateTotalXp());

    }
}

