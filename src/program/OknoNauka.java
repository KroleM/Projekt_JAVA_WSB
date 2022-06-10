package program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class OknoNauka {

    private final JFrame frame;
    private final JLabel labelWordPl;
    private final JLabel labelWordEn;
    private final JTextField textFieldWordPl;
    private final JTextField textFieldWordEn;
    private final JButton buttonNext;
    private final JButton buttonAdd;
    private final JButton buttonSave;
    private final JPanel panel;
    private final JButton wczytajFiszki;
    private final JButton zapiszFiszki;

    public OknoNauka() {
        frame = new JFrame("Nauka");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        frame.setContentPane(panel);
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        labelWordPl = new JLabel("S³owo polskie (PL)");
        labelWordPl.setHorizontalAlignment(SwingConstants.CENTER);
        labelWordEn = new JLabel("S³owo angielskie (EN)");
        labelWordEn.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldWordPl = new JTextField();
        textFieldWordPl.setFont(new Font("Calibri", Font.BOLD, 18));
        textFieldWordPl.setHorizontalAlignment(JTextField.CENTER);
        textFieldWordPl.setDisabledTextColor(Color.BLACK);
        textFieldWordEn = new JTextField();
        textFieldWordEn.setHorizontalAlignment(JTextField.CENTER);
        textFieldWordEn.setFont(new Font("Calibri", Font.BOLD, 18));
        textFieldWordEn.setDisabledTextColor(Color.BLACK);
        buttonNext = new JButton("Nastêpna fiszka");
        buttonAdd = new JButton("Tryb dodawania");
        buttonSave = new JButton("Zapisz");
        wczytajFiszki = new JButton("Wczytaj z pliku");
        zapiszFiszki = new JButton("Zapisz do pliku");
        
        JPanel panel1 = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel panel2 = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel panel3 = new JPanel(new GridLayout(1, 3, 10, 10));
        JPanel panel4 = new JPanel(new GridLayout(1, 2, 10, 10));
        
        panel.setBackground(Kolory.Tlo);
        panel1.setBackground(Kolory.Tlo);
        panel2.setBackground(Kolory.Tlo);
        panel3.setBackground(Kolory.Tlo);
        panel4.setBackground(Kolory.Tlo);
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        
        panel1.add(labelWordPl);
        panel1.add(labelWordEn);
        panel2.add(textFieldWordPl);
        panel2.add(textFieldWordEn);
        panel3.add(buttonNext);
        panel3.add(buttonAdd);
        panel3.add(buttonSave);
        panel4.add(wczytajFiszki);
        panel4.add(zapiszFiszki);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    public void wyswietlFiszke(ParaSlow p) {
        textFieldWordPl.setText(p.getSlowoPolskie());
        textFieldWordEn.setText(p.getSlowoAngielskie());
        textFieldWordPl.setEnabled(false);
        textFieldWordEn.setEnabled(false);
    }

    public ParaSlow aktualnaFiszka() {

        String firstWord = textFieldWordPl.getText();
        String secondWord = textFieldWordEn.getText();

        if (Objects.equals(firstWord, "") || Objects.equals(firstWord, null)) {
            JOptionPane.showMessageDialog(null, "Podaj polskie slowo");
        } else if (Objects.equals(secondWord, "") || Objects.equals(secondWord, null)) {
            JOptionPane.showMessageDialog(null, "Podaj angielskie slowo");
        }

        return new ParaSlow(firstWord, secondWord);
    }

    public void wyczyscPola() {
        textFieldWordPl.setText("");
        textFieldWordEn.setText("");
        textFieldWordPl.setEnabled(true);
        textFieldWordEn.setEnabled(true);
    }


    public void addNextButtonListener(ActionListener al) {
        buttonNext.addActionListener(al);
    }

    public void addAddButtonListener(ActionListener al) {
        buttonAdd.addActionListener(al);
    }

    public void addSaveButtonListener(ActionListener al) {
        buttonSave.addActionListener(al);
    }

    public void addWczytajFiszkiListener(ActionListener al){
        wczytajFiszki.addActionListener(al);
    }

    public void addZapiszFiszkiListener(ActionListener al){
        zapiszFiszki.addActionListener(al);
    }

}
