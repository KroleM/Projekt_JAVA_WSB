package program;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OknoQuiz 
{
    private final JFrame frame;
    private final JTextArea tekstPytania;
    private final JTextField tekstOdpA;
    private final JTextField tekstOdpB;
    private final JTextField tekstOdpC;
    private final JTextField tekstOdpD;
    private final JButton buttonA;
    private final JButton buttonB;
    private final JButton buttonC;
    private final JButton buttonD;
    private final JButton startQuiz;
    private final JPanel panel;
    private OknoGlowne okno;
    private boolean czyStart;


    public OknoGlowne getOkno() {
		return okno;
	}
	public void setOkno(OknoGlowne okno) {
		this.okno = okno;
	}
	public JButton getStartQuiz() {
		return startQuiz;
	}
	public boolean isCzyStart() {
		return czyStart;
	}
	public void setCzyStart(boolean czyStart) {
		this.czyStart = czyStart;
	}
	
	public OknoQuiz(OknoGlowne okno)
    {
    	frame = new JFrame("QUIZ");
    	this.okno = okno;
		frame.setSize(600, 300);
		panel = new JPanel();
		frame.setContentPane(panel);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        //tekstPolecenia = new JTextArea("Po naciœniêciu przycisku <Start> zobaczysz 5 pytañ. Wybierz jedn¹ z odpowiedzi: A, B, C, D. Na odpowiedz na 10 sekund.");
        JOptionPane.showMessageDialog(null, "Po naciœniêciu przycisku <Start> zobaczysz 5 pytañ. Wybierz jedn¹ z odpowiedzi: A, B, C, D (mo¿esz u¿yæ klawiatury!). Na odpowiedz masz 10 sekund. Powodzenia :)");
        tekstPytania = new JTextArea("Tutaj pojawi siê treœæ pytania.");
        tekstPytania.setEditable(false);
        tekstOdpA = new JTextField(20);
        tekstOdpB = new JTextField(20);
        tekstOdpC = new JTextField(20);
        tekstOdpD = new JTextField(20);
        buttonA = new JButton(" A ");
        buttonB = new JButton(" B ");
        buttonC = new JButton(" C ");
        buttonD = new JButton(" D ");
        startQuiz = new JButton("START");
    	
        JPanel panelOdpowiedzi1 = new JPanel();
        JPanel panelOdpowiedzi2 = new JPanel();
		JPanel panelStart = new JPanel();
		panelOdpowiedzi1.setLayout(new FlowLayout());
		panelOdpowiedzi2.setLayout(new FlowLayout());
		panelStart.setLayout(new FlowLayout(FlowLayout.CENTER));
		//panel.add(pole1);
		panel.add(tekstPytania);
		panel.add(panelOdpowiedzi1);
		panel.add(panelOdpowiedzi2);
		panel.add(panelStart);
		
		panelOdpowiedzi1.add(buttonA);
		panelOdpowiedzi1.add(tekstOdpA);
		panelOdpowiedzi1.add(buttonB);
		panelOdpowiedzi1.add(tekstOdpB);
		panelOdpowiedzi2.add(buttonC);
		panelOdpowiedzi2.add(tekstOdpC);
		panelOdpowiedzi2.add(buttonD);
		panelOdpowiedzi2.add(tekstOdpD);
		panelStart.add(startQuiz);
		
		/**
		 * Ta metoda zamyka okno "QUIZ" i aktywuje z powrotem okno g³ówne
		 */
		frame.addWindowListener (new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
			public void windowClosed(WindowEvent e) {
				getOkno().getFrame().setVisible(true);
			}
		});
		frame.setVisible(true);
    }

}
