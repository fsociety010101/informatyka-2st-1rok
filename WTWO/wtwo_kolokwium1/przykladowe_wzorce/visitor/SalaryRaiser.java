package visitor;

public class SalaryRaiser implements Visitor {
    Double newMinimalSalary;

    SalaryRaiser(Double newMinimalSalary){
        this.newMinimalSalary = newMinimalSalary;
    }


    @Override
    public void visit(VisitedAdministration v) {
        Double salary = v.getSalary();
        Double awardPercent = v.getAwardPercent();

        if (salary < this.newMinimalSalary) {
            salary = this.newMinimalSalary + awardPercent*this.newMinimalSalary;
        } else {
            salary = salary + (awardPercent + salary/(this.newMinimalSalary*100))*this.newMinimalSalary;
        }
        v.setSalary(salary);
    }

    @Override
    public void visit(VisitedCommonEmployee v) {
        if (v.getSalary() < this.newMinimalSalary) {
            v.setSalary(this.newMinimalSalary);
        }
    }
}
