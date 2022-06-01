package program;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

/** 
 * Klasa przedstawia pocz�tkowe okno aplikacji. Zosta�a napisana w Swing.
 * W oknie znajduj� si� 4 przyciski: 
 * Fiszki - tryb fiszki polega na zgadywaniu s��w po angielsku albo po polsku
 * Quiz - quiz j�zyka angielskiego w formie pyta� ABCD jednokrotnego wyboru
 * Statystyki - statystyki u�ytkownika, kt�re mo�na nast�pnie zapisa� do pliku
 * "?" - pomoc
 */
public class OknoGlowne 
{
	private JFrame frame;
	private JPanel panel;
	private JButton przyciskFiszki;
	private JButton przyciskQuiz;
	private JButton przyciskStatystyki;
	private JButton przyciskPomoc;
	private JLabel tekst;
	
	public JFrame getFrame() {
		return frame;
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
		panel.setBackground(new Color(235, 246, 255));
		frame.setSize(500, 300);
		frame.setContentPane(panel);

		panel.setLayout(new GridLayout(4, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.TRAILING));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel3.setLayout(new GridLayout(1, 2, 20, 20));
		panel4.setLayout(new FlowLayout(FlowLayout.TRAILING));
		panel1.setBackground(new Color(235, 246, 255));
		panel2.setBackground(new Color(235, 246, 255));
		panel3.setBackground(new Color(235, 246, 255));
		panel4.setBackground(new Color(235, 246, 255));
		
		przyciskFiszki = new JButton("FISZKI");
		przyciskFiszki.setFont(new Font("Calibri", Font.BOLD, 18));	
		//przyciskFiszki.setBackground(null);
		przyciskQuiz = new JButton("QUIZ");
		przyciskQuiz.setFont(new Font("Calibri", Font.BOLD, 18));	
		przyciskStatystyki = new JButton("Statystyki");
		przyciskStatystyki.setFont(new Font("Calibri", Font.BOLD, 14));	
		przyciskPomoc = new JButton("?");
		przyciskPomoc.setFont(new Font("Calibri", Font.BOLD, 26));	
		tekst = new JLabel("�wicz sw�j angielski!");
		tekst.setFont(new Font("Calibri", Font.BOLD, 26));
		
		panel1.add(przyciskStatystyki);
		panel2.add(tekst);
		panel3.add(przyciskFiszki);
		panel3.add(przyciskQuiz);
		panel4.add(przyciskPomoc);
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
