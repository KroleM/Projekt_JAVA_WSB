package program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

    public OknoNauka(){
        frame = new JFrame("Nauka");
        frame.setSize(500, 400);
        panel = new JPanel();
        frame.setContentPane(panel);
        panel.setLayout(new GridLayout(4,2,10,10));
        labelWordPl = new JLabel("Słowo pl");
        labelWordEn = new JLabel("Słowo ang");
        textFieldWordPl = new JTextField();
        textFieldWordEn = new JTextField();
        buttonNext = new JButton("Next");
        buttonAdd = new JButton("Add");
        buttonSave = new JButton("Save");
        panel.add(labelWordPl);
        panel.add(labelWordEn);
        panel.add(textFieldWordPl);
        panel.add(textFieldWordEn);
        panel.add(buttonNext);
        panel.add(buttonAdd);
        panel.add(buttonSave);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);

    }

    public void wyswietlFiszke(ParaSlow p){
        textFieldWordPl.setText(p.getSlowoPolskie());
        textFieldWordEn.setText(p.getSlowoAngielskie());
        textFieldWordPl.setEnabled(false);
        textFieldWordEn.setEnabled(false);
    }
    public ParaSlow aktualnaFiszka(){
        return new ParaSlow(textFieldWordPl.getText(), textFieldWordEn.getText());
    }

    public void wyczyscPola(){
        textFieldWordPl.setText("");
        textFieldWordEn.setText("");
        textFieldWordPl.setEnabled(true);
        textFieldWordEn.setEnabled(true);
    }

    public void addNextButtonListener(ActionListener al){
        buttonNext.addActionListener(al);
    }

    public void addAddButtonListener(ActionListener al){
        buttonAdd.addActionListener(al);
    }

    public void addSaveButtonListener(ActionListener al){
        buttonSave.addActionListener(al);
    }

}
