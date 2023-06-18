package visitor;

public class VisitedCommonEmployee implements Visited {

    private Double salary;

    VisitedCommonEmployee(Double salary){
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public void acceptVisit(Visitor visitor) {
        visitor.visit(this);
    }
}
