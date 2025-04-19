package quizcheat.backend.dto.response;

public class PointDetailResponse {
    private String name;
    private int credit;
    private double diligence;
    private double test;
    private double exam1;
    private double exam2;
    private double exam3;
    private double finalexam;
    private double avgpoint;

    public PointDetailResponse(String name, int credit, double diligence, double test, double exam1, double exam2,
            double exam3,
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getAvgpoint() {
        return avgpoint;
    }

    public void setAvgpoint(double avgpoint) {
        this.avgpoint = avgpoint;
    }

}
