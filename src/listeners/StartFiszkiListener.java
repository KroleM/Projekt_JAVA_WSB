package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import program.OknoFiszki;

import threads.FiszkiThread;

/**
 * Listener do przycisku START w oknie Fiszki
 * Gdy kt�ry� checkbox jest zaznaczony, po naci�ni�ciu tego przycisku w��czy si� tryb odgadywania fiszek (FiszkiThread)
 * Ponadto ten przycisk po wci�ni�ciu zamieni si� w timer odliczaj�cy czas (ten w�tek zostaje uruchomiony ju� w FiszkiThread)
 */
public class StartFiszkiListener implements ActionListener
{
	private OknoFiszki oknoFiszki;
	
	public OknoFiszki getOknoFiszki() {
		return oknoFiszki;
	}
	public void setOknoFiszki(OknoFiszki oknoFiszki) {
		this.oknoFiszki = oknoFiszki;
	}

	public StartFiszkiListener(OknoFiszki oknoFiszki)
	{
		this.oknoFiszki = oknoFiszki;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			if(e.getActionCommand().equals("START") && getOknoFiszki().getStart().getText().equals("START"))
			{
				if((getOknoFiszki().getPolski().isSelected() && !getOknoFiszki().getAngielski().isSelected())
						|| (!getOknoFiszki().getPolski().isSelected() && getOknoFiszki().getAngielski().isSelected()))
				{
					dezaktywujPrzyciski();
					//System.out.println("Zgadywanie angielskich s��w");
					getOknoFiszki().setCzyStart(true);
					new FiszkiThread(getOknoFiszki()).start();
				}
			}
			if(e.getActionCommand().equals("Zako�cz"))
				getOknoFiszki().setCzyStart(false);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
	private void dezaktywujPrzyciski()
	{
		getOknoFiszki().getPolski().setEnabled(false);
		getOknoFiszki().getAngielski().setEnabled(false);
	}

}
