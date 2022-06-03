import org.jpl7.Atom;
import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;

public class Main {

    public static void main(String[] args) {
        JPL.init(); // Initialisierung
        Query q1 = new Query( // consult("graph.pl").
                "consult" // Standard-Praedikat zum Laden
                , new Term[] { new Atom("lib/xpceTest.pl") }); // Datei
        System.out.println("consult " + q1.hasSolution());
        q1.close();

    }

    public static void Automat() {
        Query q2 = new Query( // vonNach(a, a).
                "akzeptiert([a, b, a, a, b, b])");
        System.out.println("akzeptiert " + q2.hasSolution());
        q2.close();
    }
}
