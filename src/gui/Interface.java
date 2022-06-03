package gui;

import business.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {
    private JButton plus, minus, modulo, division, power, multiplication, squareRoot, fak, equals, AC;
    private JButton numbers[];
    private JTextField res;
    private JPanel panel;

    private Command pl, mi, mo, di, po, mu, sq, f;
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
        setSize(600, 600);
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
        } else if (source == fak) {
            entry1();
            last = f;
        } else if (source == AC) {
            entry1 = 0;
            entry2 = 0;
            res.setText(null);
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
        f = new Factorial();
        po = new Power();
        sq = new SquareRoot();
        mi = new Minus();
    }

    private void initButtons() {
        for (int i = 0; i <= 9; i++) {
            numbers[i] = new JButton(i + "");
            panel.add(numbers[i]);
            numbers[i].addActionListener(this);
        }

        this.plus = new JButton("+");
        this.plus.addActionListener(this);
        this.panel.add(plus);

        this.minus = new JButton("-");
        this.minus.addActionListener(this);
        this.panel.add(minus);

        this.multiplication = new JButton("*");
        this.multiplication.addActionListener(this);
        this.panel.add(multiplication);

        this.division = new JButton("/");
        this.division.addActionListener(this);
        this.panel.add(division);

        this.modulo = new JButton("%");
        this.modulo.addActionListener(this);
        this.panel.add(modulo);

        this.power = new JButton("^");
        this.power.addActionListener(this);
        this.panel.add(power);

        this.squareRoot = new JButton("√");
        this.squareRoot.addActionListener(this);
        this.panel.add(squareRoot);

        this.fak = new JButton("!");
        this.fak.addActionListener(this);
        this.panel.add(fak);

        this.equals = new JButton("=");
        this.equals.addActionListener(this);
        this.panel.add(equals);

        this.AC = new JButton("AC");
        this.AC.addActionListener(this);
        this.panel.add(AC);

    }

    private void entry1() {
        this.entry1 = Double.parseDouble(res.getText());
        res.setText(null);
    }
}
