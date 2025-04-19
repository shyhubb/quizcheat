package quizcheat.backend.dto.request;

public class PointRequest {
    private int credit;
    private String name;
    private double diligence;
    private double test;
    private double exam1;
    private double exam2;
    private double exam3;
    private double finalexam;

    public PointRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PointRequest(int credit, String name, double diligence, double test, double exam1, double exam2,
            double exam3, double finalexam) {
        this.credit = credit;
        this.name = name;
        this.diligence = diligence;
        this.test = test;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
        this.finalexam = finalexam;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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

}
