package program;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OknoStatystyki 
{
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel label1;
    private final JLabel label2;
    private final JTextArea poleFiszki;
    private final JTextArea poleQuiz;
    private final JTextField wynikFiszki;
    private final JTextField wynikQuiz;
    private OknoGlowne okno;
       
    public OknoGlowne getOkno() {
		return okno;
	}
	public void setOkno(OknoGlowne okno) {
		this.okno = okno;
	}

	public OknoStatystyki(OknoGlowne okno)
    {
    	frame = new JFrame("Statystyki");
    	this.okno = okno;
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		frame.setContentPane(panel);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        
        JPanel panelGora = new JPanel(new BorderLayout());
        JPanel panelDol = new JPanel(new BorderLayout());
        JPanel panelFiszki = new JPanel();
        JPanel panelQuiz = new JPanel();

        label1 = new JLabel("Fiszki - wyniki");
        label2 = new JLabel("Quiz - wyniki");
        poleFiszki = new JTextArea(5, 30);
        poleQuiz = new JTextArea(5, 30);
        wynikFiszki = new JTextField(30);
        wynikQuiz = new JTextField(30);
        JScrollPane scroll1 = new JScrollPane(poleFiszki);
        JScrollPane scroll2 = new JScrollPane(poleQuiz);
        
        poleFiszki.setEditable(false);
        poleQuiz.setEditable(false);
        wynikFiszki.setEditable(false);
        wynikQuiz.setEditable(false);
        
        panel.setBackground(Kolory.Tlo);
        panelGora.setBackground(Kolory.Tlo);
        panelDol.setBackground(Kolory.Tlo);
        panelFiszki.setBackground(Kolory.Tlo);
        panelQuiz.setBackground(Kolory.Tlo);
        
        panel.add(panelGora);
    	panel.add(panelDol);
    	panelGora.add(label1, BorderLayout.WEST);
    	panelGora.add(panelFiszki, BorderLayout.CENTER);
    	panelDol.add(label2, BorderLayout.WEST);
    	panelDol.add(panelQuiz, BorderLayout.CENTER);
    	panelFiszki.add(scroll1);
    	panelFiszki.add(wynikFiszki);
    	panelQuiz.add(scroll2);
    	panelQuiz.add(wynikQuiz);
    	
        aktualizujFiszki();
        aktualizujQuiz();
        
        zamknijOkno();
    }
    
	/**
	 * Zamykanie okna "Statystyki"
	 *  Ta metoda zamyka okno Statystyki, wysy?a sygna? do w?tku o zako?czeniu i aktywuje z powrotem okno g??wne.
	 */
	private void zamknijOkno()
	{
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
	
	private void aktualizujFiszki()
	{
		if(!Statystyki.RozegraneFiszki.isEmpty())
		{
			for(int i=1; i <= Statystyki.WynikFiszek.size(); i++)
				poleFiszki.append("Partia fiszek nr " + i + ": " + Statystyki.WynikFiszek.get(i-1) + "/" + Statystyki.RozegraneFiszki.get(i-1) + " pkt.\n");
			wynikFiszki.setText("Wszystkie zdobyte punkty: " + Statystyki.CalkowityWynik(Statystyki.WynikFiszek) + "/" + Statystyki.CalkowityWynik(Statystyki.RozegraneFiszki) + " pkt.");	
		}
	}
	private void aktualizujQuiz()
	{
		if(!Statystyki.RozegraneFiszki.isEmpty())
		{
			for(int i=1; i <= Statystyki.WynikQuizu.size(); i++)
				poleQuiz.append("Partia quizu nr " + i + ": " + Statystyki.WynikQuizu.get(i-1) + "/" + Statystyki.RozegraneQuizy.get(i-1) + " pkt.\n");
			wynikQuiz.setText("Wszystkie zdobyte punkty: " + Statystyki.CalkowityWynik(Statystyki.WynikQuizu) + "/" + Statystyki.CalkowityWynik(Statystyki.RozegraneQuizy) + " pkt.");	
		}
	}
}
