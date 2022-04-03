package entities;

public class Course extends Content{

    private int workload;

    @Override
    public double calculateXp() {
        return STANDARD_XP * workload;
    }

    public Course() {
    }


    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitle() + '\'' +
                ", descricao='" + getDescription() + '\'' +
                ", workload=" + workload +
                '}';
    }
}
