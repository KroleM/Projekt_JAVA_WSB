package listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import program.Kolory;
import program.OknoQuiz;

public class QuizOdpowiedzListener implements ActionListener
{
	private OknoQuiz oknoQuiz;
	
	public OknoQuiz getOknoQuiz() {
		return oknoQuiz;
	}
	public void setOknoQuiz(OknoQuiz oknoQuiz) {
		this.oknoQuiz = oknoQuiz;
	}
	
	public QuizOdpowiedzListener(OknoQuiz oknoQuiz)
	{
		this.oknoQuiz = oknoQuiz;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			wyczyscKolor();
			switch(e.getActionCommand())
			{
				case " A ":
					getOknoQuiz().setWybranaOdp(getOknoQuiz().getTekstOdpA());
					wybierzPole(getOknoQuiz().getTekstOdpA());
					break;
				case " B ":
					getOknoQuiz().setWybranaOdp(getOknoQuiz().getTekstOdpB());
					wybierzPole(getOknoQuiz().getTekstOdpB());
					break;
				case " C ":
					getOknoQuiz().setWybranaOdp(getOknoQuiz().getTekstOdpC());
					wybierzPole(getOknoQuiz().getTekstOdpC());
					break;
				case " D ":
					getOknoQuiz().setWybranaOdp(getOknoQuiz().getTekstOdpD());
					wybierzPole(getOknoQuiz().getTekstOdpD());
					break;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}				
	}
	
	private void wyczyscKolor()
	{
		getOknoQuiz().getTekstOdpA().setBackground(null);
		getOknoQuiz().getTekstOdpB().setBackground(null);
		getOknoQuiz().getTekstOdpC().setBackground(null);
		getOknoQuiz().getTekstOdpD().setBackground(null);
	}
	private void wybierzPole(JTextField wybranePole)
	{
		wybranePole.setBackground(Kolory.Niebieski);
	}

}
