package quizcheat.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Point {

    @Id
    private Long id;
    private String name;
    private int credit;
    private double diligence;
    private double test;
    private double exam1;
    private double exam2;
    private double exam3;
    private double finalexam;

    private double avgpoint;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;

    public Point() {
    }

    public Point(String name, int credit, double diligence, double test, double exam1, double exam2, double exam3,
            double finalexam, double avgpoint) {
        this.name = name;
        this.credit = credit;
        this.diligence = diligence;
        this.test = test;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
        this.finalexam = finalexam;
        this.avgpoint = avgpoint;
    }

    public void genFinalAvgPonit() {
        switch (this.credit) {
            case 2:
                this.avgpoint = (this.diligence * 0.05) + ((this.exam1 + this.exam2) / 2) * 0.3 + (test * 0.15)
                        + finalexam * 0.5;
                break;
            case 3:
                this.avgpoint = (this.diligence * 0.05) + ((this.exam1 + this.exam2 + this.exam3) / 3) * 0.3
                        + (test * 0.15) + finalexam * 0.5;
                break;
            default:
                return;
        }
    }

    @Override
    public String toString() {
        return "Point [id=" + id + ", credit=" + credit + ", diligence=" + diligence + ", test=" + test + ", exam1="
                + exam1 + ", exam2=" + exam2 + ", exam3=" + exam3 + ", finalexam=" + finalexam + ", avgpoint="
                + avgpoint + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDiligence() {
        return diligence;
    }

    public void setDiligence(double diligence) {
        this.diligence = diligence;
    }

    public double getTest() {
        return test;
    }

    public void setTest(double test) {
        this.test = test;
    }

    public double getExam1() {
        return exam1;
    }

    public void setExam1(double exam1) {
        this.exam1 = exam1;
    }

    public double getExam2() {
        return exam2;
    }

    public void setExam2(double exam2) {
        this.exam2 = exam2;
    }

    public double getExam3() {
        return exam3;
    }

    public void setExam3(double exam3) {
        this.exam3 = exam3;
    }

    public double getFinalexam() {
        return finalexam;
    }

    public void setFinalexam(double finalexam) {
        this.finalexam = finalexam;
    }

    public double getAvgpoint() {
        return avgpoint;
    }

    public void setAvgpoint(double avgpoint) {
        this.avgpoint = avgpoint;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
