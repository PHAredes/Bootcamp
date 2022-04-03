package entities;

import java.util.*;

public class Dev {
    private String name;
    private Set<Content> contentsSubscribed = new LinkedHashSet<>();
    private Set<Content> contentsDone = new LinkedHashSet<>();

    public void subscribeBootcamp(Bootcamp bootcamp){
        this.contentsSubscribed.addAll(bootcamp.getContents());
        bootcamp.getDevsSubscribers().add(this);
    }

    public void toProgress() {
        Optional<Content> content = this.contentsSubscribed.stream().findFirst();
        if(content.isPresent()) {
            this.contentsDone.add(content.get());
            this.contentsSubscribed.remove(content.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calculateTotalXp() {
        Iterator<Content> iterator = this.contentsDone.iterator();
        double sum = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calculateXp();
            sum += next;
        }
        return sum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getContentsSubscribed() {
        return contentsSubscribed;
    }

    public void setContentsSubscribed(Set<Content> contentsSubscribed) {
        this.contentsSubscribed = contentsSubscribed;
    }

    public Set<Content> getContentsDone() {
        return contentsDone;
    }

    public void setContentsDone(Set<Content> contentsDone) {
        this.contentsDone = contentsDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(contentsSubscribed, dev.contentsSubscribed) 
        && Objects.equals(contentsDone, dev.contentsDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contentsSubscribed, contentsDone);
    }
}
