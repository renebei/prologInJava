package main;

import business.Calculator;
import org.jpl7.Atom;
import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;

import java.util.Scanner;

public class Dialog {
    private Scanner scan;
    private Calculator calc;

    public Dialog() {
        JPL.init();
        Query q1 = new Query(
                "consult"
                , new Term[]{new Atom("lib/calc.pl")});
        System.out.println("consult " + q1.hasSolution());
        q1.close();
        this.calc = new Calculator();
        this.scan = new Scanner(System.in);
    }

    public void dialog() {
        output();
        switch (userInput()) {
            case 1:
                System.out.println("First number?: ");
                double a = scan.nextInt();
                System.out.println("Second number?: ");
                double b = scan.nextInt();
                calc.add(a, b);
                break;
            case 2:
                System.out.println("First number?: ");
                double c = scan.nextInt();
                System.out.println("Second number?: ");
                double d = scan.nextInt();
                calc.power(c, d);
                break;
        }
    }

    private int userInput() {
        return scan.nextInt();
    }

    private void output() {
        System.out.println("choose operation");
        System.out.print("(1) add" + "\n" +
                "(2) power" + "\n");
    }
}
