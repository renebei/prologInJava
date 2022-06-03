package business;

import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import java.util.Map;

public class Calculator {

    public void add(double a, double b) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("add(" + a + "," + b + "," + z + ")");
        Query add = new Query(term);
        for (Map<String, Term> map : add.allSolutions()) {
            System.out.println(map);
        }
        add.close();
    }

    public void power(double a, double b) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("power(" + a + "," + b + "," + z + ")");
        Query power = new Query(term);
        for (Map<String, Term> map : power.allSolutions()) {
            System.out.println(map);
        }
        power.close();
    }
}
