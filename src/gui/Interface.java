package gui;

import business.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {
    private JButton plus, minus, modulo, division, power, multiplication, squareRoot, fak, EC, AC;
    private JButton numbers[];
    private JTextField res;
    private Calculator calc;
    private JPanel panel;

    public Interface() {
        super("Prolog Calculator");
        this.numbers = new JButton[10];
        this.calc = new Calculator();
        this.res = new JTextField(10);
        initButtons();

        setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);
        add(res, BorderLayout.NORTH);
        setVisible(true);
        setSize(600, 600);
    }

    private void initButtons() {
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

        this.EC = new JButton("EC");
        this.EC.addActionListener(this);
        this.panel.add(EC);

        this.AC = new JButton("AC");
        this.AC.addActionListener(this);
        this.panel.add(AC);

        for (int i = 0; i <= 9; i++) {
            numbers[i] = new JButton(i + "");
            panel.add(numbers[i]);
            numbers[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == plus) {
            calc.add(3, 3);
        } else if (source == minus) {
            calc.minus(3, 3);
        } else if (source == multiplication) {
            calc.multiplication(3, 3);
        } else if (source == division) {
            calc.division(3, 3);
        } else if (source == power) {
            calc.power(3, 3);
        } else if (source == modulo) {
            calc.modulo(3, 3);
        } else if (source == squareRoot) {
            calc.squareRoot(3);
        } else if (source == fak) {
            calc.fak(3);
        } else if (source == AC) {
            res.setText(null);
        } else if(source == EC) {
            res.setText(null);
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
}
