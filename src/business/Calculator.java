package business;

import org.jpl7.*;

import javax.swing.*;
import java.util.Map;

public class Calculator {

    public Calculator() {
        JPL.init();
        Query q1 = new Query(
                "consult"
                , new Term[]{new Atom("lib/calc.pl")});
        System.out.println("consult " + q1.hasSolution());
        q1.close();
    }

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
    public void minus(double a, double b) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("minus(" + a + "," + b + "," + z + ")");
        Query minus = new Query(term);
        for (Map<String, Term> map : minus.allSolutions()) {
            System.out.println(map);
        }
        minus.close();
    }
    public void multiplication(double a, double b) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("multiplication(" + a + "," + b + "," + z + ")");
        Query multiplication = new Query(term);
        for (Map<String, Term> map : multiplication.allSolutions()) {
            System.out.println(map);
        }
        multiplication.close();
    }

    public void division(double a, double b) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("division(" + a + "," + b + "," + z + ")");
        Query division = new Query(term);
        for (Map<String, Term> map : division.allSolutions()) {
            System.out.println(map);
        }
        division.close();
    }
    public void modulo(int a, int b) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("modulo(" + a + "," + b + "," + z + ")");
        Query modulo = new Query(term);
        for (Map<String, Term> map : modulo.allSolutions()) {
            System.out.println(map);
        }
        modulo.close();
    }

    public void squareRoot(double a) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("squareRoot(" + a + "," + z + ")");
        Query squareRoot = new Query(term);
        for (Map<String, Term> map : squareRoot.allSolutions()) {
            System.out.println(map);
        }
        squareRoot.close();
    }

    public void fak(double a) {
        Variable z = new Variable("Z");
        Term term = Term.textToTerm("fak(" + a + "," + z + ")");
        Query squareRoot = new Query(term);
        for (Map<String, Term> map : squareRoot.allSolutions()) {
            System.out.println(map);
        }
        squareRoot.close();
    }
}
