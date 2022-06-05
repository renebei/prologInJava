package gui;

import business.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {
    private JButton plus, minus, modulo, division, power, multiplication, squareRoot, fak, equals, AC, exit, cosinus, sinus, pi;
    private JButton numbers[];
    private JTextField res;
    private JPanel panel;

    private Command pl, mi, mo, di, po, mu, sq, f, cos, sin;
    private Command last;

    private double entry1;
    private double entry2;

    public Interface() {
        super("Prolog Calculator");
        this.numbers = new JButton[10];
        this.res = new JTextField(10);
        panel = new JPanel();
        initButtons();
        initCommands();

        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(750, 500);
        res.setFont(new Font("Arial", Font.PLAIN, 40));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == plus) {
            entry1();
            res.setText(null);
            last = pl;
        } else if (source == minus) {
            entry1();
            last = mi;
        } else if (source == multiplication) {
            entry1();
            last = mu;
        } else if (source == division) {
            entry1();
            last = di;
        } else if (source == power) {
            entry1();
            last = po;
        } else if (source == modulo) {
            entry1();
            last = mo;
        } else if (source == squareRoot) {
            entry1();
            last = sq;
        } else if(source == cosinus) {
            entry1();
            last = cos;
        } else if(source == sinus) {
            entry1();
            last = sin;
        } else if(source == pi) {
            res.setText(String.valueOf(Math.PI));
        } else if (source == AC) {
            entry1 = 0;
            entry2 = 0;
            res.setText(null);
        } else if (source == exit) {
            System.exit(0);
        } else if (source == equals) {
            if(!res.getText().equals(""))
                this.entry2 = Double.parseDouble(res.getText());
            else entry2 = 0;
            res.setText(last.execute(entry1, entry2).toString());
        } else {
            for (int i = 0; i < 10; i++) {
                if (source == numbers[i]) {
                    String t = res.getText();
                    t += i;
                    res.setText(t);
                }
            }
        }
    }

    private void initCommands() {
        pl = new Plus();
        mu = new Multiplication();
        mo = new Modulo();
        di = new Division();
        cos = new Cosinus();
        sin = new Sinus();
        po = new Power();
        sq = new SquareRoot();
        mi = new Minus();
    }

    private void initButtons() {
        for (int i = 0; i <= 9; i++) {
            numbers[i] = new JButton(i + "");
            numbers[i].setFont(new Font("Arial", Font.PLAIN, 40));
            panel.add(numbers[i]);
            numbers[i].addActionListener(this);
        }

        this.plus = new JButton("+");
        this.plus.addActionListener(this);
        this.plus.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(plus);

        this.minus = new JButton("-");
        this.minus.addActionListener(this);
        this.minus.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(minus);

        this.multiplication = new JButton("*");
        this.multiplication.addActionListener(this);
        this.multiplication.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(multiplication);

        this.division = new JButton("/");
        this.division.addActionListener(this);
        this.division.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(division);

        this.modulo = new JButton("%");
        this.modulo.addActionListener(this);
        this.modulo.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(modulo);

        this.power = new JButton("^");
        this.power.addActionListener(this);
        this.power.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(power);

        this.squareRoot = new JButton("√");
        this.squareRoot.addActionListener(this);
        this.squareRoot.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(squareRoot);

        this.cosinus = new JButton("cos");
        this.cosinus.addActionListener(this);
        this.cosinus.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(cosinus);

        this.sinus = new JButton("sin");
        this.sinus.addActionListener(this);
        this.sinus.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(sinus);

        this.pi = new JButton("π");
        this.pi.addActionListener(this);
        this.pi.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(pi);

        this.AC = new JButton("AC");
        this.AC.addActionListener(this);
        this.AC.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(AC);

        this.exit = new JButton("off");
        this.exit.addActionListener(this);
        this.exit.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(exit);

        this.equals = new JButton("=");
        this.equals.addActionListener(this);
        this.equals.setFont(new Font("Arial", Font.PLAIN, 40));
        this.panel.add(equals);

    }

    private void entry1() {
        this.entry1 = Double.parseDouble(res.getText());
        res.setText(null);
    }
}
