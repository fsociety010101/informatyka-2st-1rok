package visitor;

public interface Visited {

    void acceptVisit(Visitor visitor);

    Double getSalary();
}
