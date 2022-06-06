package program;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RejestracjaiLogowanie {
    private final JFrame frame;
    private final JTextField textFieldEmail;
    private final JLabel labelEmail;
    private final JTextField textFieldPassword;
    private final JLabel labelPassword;
    private final JButton buttonZapiszZaloguj;
    private JPanel panelGlowny;

    public RejestracjaiLogowanie(){
        frame = new JFrame("Logowanie");
        frame.setSize(300,250);
        textFieldEmail = new JTextField();
        labelEmail = new JLabel("Podaj email");
        textFieldPassword = new JTextField();
        labelPassword = new JLabel("Podaj haslo");
        buttonZapiszZaloguj = new JButton("Zaloguj/Zarejestruj");
        panelGlowny = new JPanel(new GridLayout(5,1,5,5));
        frame.setContentPane(panelGlowny);

        panelGlowny.add(labelEmail);
        panelGlowny.add(textFieldEmail);
        panelGlowny.add(labelPassword);
        panelGlowny.add(textFieldPassword);
        panelGlowny.add(buttonZapiszZaloguj);

        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
