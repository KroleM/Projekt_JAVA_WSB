package program;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import listeners.JezykCheckListener;
import listeners.StartFiszkiListener;

/**
 * Okno do rozwi�zywania i wprowadzania fiszek
 * Jego otwarcie powoduje zablokowanie przycisk�w w oknie g��wnym
 * Zamkni�cie okna fiszek powoduje odblokowanie przycisk�w w oknie g��wnym
 * Zamkni�cie okna fiszek NIE powoduje zamkni�cia ca�ego programu
 */
public class OknoFiszki extends JFrame
{
	private JTextField fiszkaAngielska;
	private JTextField fiszkaPolska;
	private OknoGlowne okno;
	private JCheckBox polski;
	private JCheckBox angielski;
	private JButton start;
	private JButton wprowadzanie;
	private static ArrayList<ParaSlow> paraSlow;
	static {
		paraSlow = new ArrayList<>(List.of(
				new ParaSlow("rower", "bicycle"), 
				new ParaSlow("siode�ko", "saddle"), 
				new ParaSlow("widelec", "fork"),
				new ParaSlow("opona", "tyre"),
				new ParaSlow("zapi�cie", "lock")
				//new ParaSlow("rama", "frame"),
				//new ParaSlow("piasta", "hub"),
				//new ParaSlow("hamulec", "brake"),
				//new ParaSlow("amortyzator", "shock absorber"),
				//new ParaSlow("kierownica", "handlebar"),
				//new ParaSlow("przerzutka", "gear"),
				//new ParaSlow("�ancuch", "chain"),
				//new ParaSlow("z�batka", "sprocket"),
				//new ParaSlow("d�tka", "tube"),
				//new ParaSlow("szprycha", "spoke")
				));
	}

	public JTextField getFiszkaAngielska() {
		return fiszkaAngielska;
	}
	public void setFiszkaAngielska(JTextField fiszkaAngielska) {
		this.fiszkaAngielska = fiszkaAngielska;
	}
	public JTextField getFiszkaPolska() {
		return fiszkaPolska;
	}
	public void setFiszkaPolska(JTextField fiszkaPolska) {
		this.fiszkaPolska = fiszkaPolska;
	}
	public OknoGlowne getOkno() {
		return okno;
	}
	public void setOkno(OknoGlowne okno) {
		this.okno = okno;
	}
	public JCheckBox getPolski() {
		return polski;
	}
	public void setPolski(JCheckBox polski) {
		this.polski = polski;
	}
	public JCheckBox getAngielski() {
		return angielski;
	}
	public void setAngielski(JCheckBox angielski) {
		this.angielski = angielski;
	}
	public JButton getStart() {
		return start;
	}
	public void setStart(JButton start) {
		this.start = start;
	}
	public JButton getWprowadzanie() {
		return wprowadzanie;
	}
	public void setWprowadzanie(JButton wprowadzanie) {
		this.wprowadzanie = wprowadzanie;
	}
	public static ArrayList<ParaSlow> getParaSlow() {
		return paraSlow;
	}
	public static void setParaSlow(ArrayList<ParaSlow> paraSlow) {
		OknoFiszki.paraSlow = paraSlow;
	}
	
	public OknoFiszki(OknoGlowne okno)
	{
		super("Fiszki");
		this.setOkno(okno);
		setSize(500, 300);
		JPanel panelGlowny = new JPanel(new GridLayout(5, 1, 10, 10));
		panelGlowny.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setContentPane(panelGlowny);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel4.setLayout(new FlowLayout());
		panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		fiszkaPolska = new JTextField(15);
		fiszkaAngielska = new JTextField(15);
		polski = new JCheckBox("polski");
		angielski = new JCheckBox("angielski");
		start = new JButton("START");
		wprowadzanie = new JButton("Wprowadzanie");
		
		JLabel fiszki = new JLabel("FISZKI");
		fiszki.setFont(new Font("Calibri", Font.BOLD, 26));
		
		panel1.add(fiszki);
		panel2.add(polski);
		panel2.add(angielski);
		panel3.add(start);
		panel4.add(new JLabel("POLSKI"));
		panel4.add(fiszkaPolska);
		panel4.add(new JLabel("ANGIELSKI"));
		panel4.add(fiszkaAngielska);
		panel5.add(wprowadzanie);
		
		panelGlowny.add(panel1);
		panelGlowny.add(panel2);
		panelGlowny.add(panel3);
		panelGlowny.add(panel4);
		panelGlowny.add(panel5);
		
		polski.addActionListener(new JezykCheckListener(polski, angielski, fiszkaPolska, fiszkaAngielska));
		angielski.addActionListener(new JezykCheckListener(angielski, polski, fiszkaAngielska, fiszkaPolska));
		start.addActionListener(new StartFiszkiListener(this));
		

		//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		/**
		 * Ta metoda zamyka okno "Fiszki" i aktywuje z powrotem przyciski w oknie g��wnym
		 */
		addWindowListener (new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			public void windowClosed(WindowEvent e) {
				getOkno().AktywujPrzyciski();
			}
		});
		setVisible(true);
	}
		
}
