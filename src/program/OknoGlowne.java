package program;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import listeners.FiszkiListener;
import listeners.QuizListener;
import listeners.StatystykiListener;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

/** 
 * Klasa przedstawia pocz¹tkowe okno aplikacji. Zosta³a napisana w Swing.
 * W oknie znajduj¹ siê 4 przyciski: 
 * Fiszki - tryb fiszki polega na zgadywaniu s³ów po angielsku albo po polsku
 * Quiz - quiz jêzyka angielskiego w formie pytañ ABCD jednokrotnego wyboru
 * Statystyki - statystyki u¿ytkownika, które mo¿na nastêpnie zapisaæ do pliku
 * "?" - pomoc
 */
public class OknoGlowne 
{
	private JFrame frame;
	private JPanel panel;
	private JButton przyciskFiszki;
	private JButton przyciskFiszkiNauka;
	private JButton przyciskQuiz;
	private JButton przyciskStatystyki;
	private JButton przyciskPomoc;
	private JLabel tekst;
	
	public JFrame getFrame() {
		return frame;
	}
	public JButton getPrzyciskFiszkiNauka() {
		return przyciskFiszkiNauka;
	}
	public void setPrzyciskFiszkiNauka(JButton przyciskFiszkiNauka) {
		this.przyciskFiszkiNauka = przyciskFiszkiNauka;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JButton getPrzyciskFiszki() {
		return przyciskFiszki;
	}
	public void setPrzyciskFiszki(JButton przyciskFiszki) {
		this.przyciskFiszki = przyciskFiszki;
	}
	public JButton getPrzyciskQuiz() {
		return przyciskQuiz;
	}
	public void setPrzyciskQuiz(JButton przyciskQuiz) {
		this.przyciskQuiz = przyciskQuiz;
	}
	public JButton getPrzyciskStatystyki() {
		return przyciskStatystyki;
	}
	public void setPrzyciskStatystyki(JButton przyciskStatystyki) {
		this.przyciskStatystyki = przyciskStatystyki;
	}
	public JButton getPrzyciskPomoc() {
		return przyciskPomoc;
	}
	public void setPrzyciskPomoc(JButton przyciskPomoc) {
		this.przyciskPomoc = przyciskPomoc;
	}
	public JLabel getTekst() {
		return tekst;
	}
	public void setTekst(JLabel tekst) {
		this.tekst = tekst;
	}
	
	public OknoGlowne()
	{
		frame = new JFrame("Aplikacja do nauki angielskiego");
		panel = new JPanel();
		frame.setSize(500, 300);
		frame.setContentPane(panel);
		frame.setLocationRelativeTo(null);

		panel.setLayout(new GridLayout(5, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel31 = new JPanel();
		JPanel panel32 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JLabel label1 = new JLabel("Nauka");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label2 = new JLabel("Testy");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.setLayout(new FlowLayout(FlowLayout.TRAILING));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setLayout(new GridLayout(1, 2, 20, 20));
		panel4.setLayout(new GridLayout(1, 2, 20, 20));
		panel5.setLayout(new GridLayout(1, 2, 20, 20));
		
		panel.setBackground(Kolory.Tlo);
		panel1.setBackground(Kolory.Tlo);
		panel2.setBackground(Kolory.Tlo);
		panel3.setBackground(Kolory.Tlo);
		panel4.setBackground(Kolory.Tlo);
		panel5.setBackground(Kolory.Tlo);
		//panel2.setPreferredSize(new Dimension(500,50));
		
		przyciskFiszki = new JButton("FISZKI - test");
		przyciskFiszki.setFont(new Font("Calibri", Font.BOLD, 18));	
		//przyciskFiszki.setBackground(null);
		przyciskQuiz = new JButton("QUIZ");
		przyciskQuiz.setFont(new Font("Calibri", Font.BOLD, 18));	
		przyciskStatystyki = new JButton("Statystyki");
		przyciskStatystyki.setFont(new Font("Calibri", Font.BOLD, 14));
		przyciskPomoc = new JButton("?");
		przyciskPomoc.setFont(new Font("Calibri", Font.BOLD, 26));	
		tekst = new JLabel("Æwicz swój angielski!");
		tekst.setFont(new Font("Calibri", Font.BOLD, 26));
		przyciskFiszkiNauka = new JButton("Fiszki - nauka");
		przyciskFiszkiNauka.setFont(new Font("Calibri", Font.BOLD, 18));
		
		panel1.add(przyciskStatystyki);
		panel2.add(tekst);
		panel3.add(label1);
		panel3.add(label2);
		panel4.add(przyciskFiszkiNauka);
		panel4.add(przyciskFiszki);
		panel5.add(new JLabel());
		panel5.add(przyciskQuiz);
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		
		przyciskFiszki.addActionListener(new FiszkiListener(this));
		przyciskQuiz.addActionListener(new QuizListener(this));
		przyciskStatystyki.addActionListener(new StatystykiListener(this));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void DezaktywujPrzyciski()
	{
		getPrzyciskStatystyki().setEnabled(false);
		getPrzyciskFiszki().setEnabled(false);
		getPrzyciskQuiz().setEnabled(false);
		getPrzyciskPomoc().setEnabled(false);
	}
	
	public void AktywujPrzyciski()
	{
		getPrzyciskStatystyki().setEnabled(true);
		getPrzyciskFiszki().setEnabled(true);
		getPrzyciskQuiz().setEnabled(true);
		getPrzyciskPomoc().setEnabled(true);
	}

	public void addFiszkiNaukaButtonListener(ActionListener al){
		przyciskFiszkiNauka.addActionListener(al);
	}
	
}
