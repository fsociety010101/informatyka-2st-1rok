package visitor;

public class VisitedAdministration implements Visited {
    private Double salary;
    private Double awardPercent;

    VisitedAdministration(Double salary, Double awardPercent){
        this.salary = salary;
        this.awardPercent = awardPercent;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAwardPercent() {
        return awardPercent;
    }

    @Override
    public void acceptVisit(Visitor visitor) {
        visitor.visit(this);
    }
}
