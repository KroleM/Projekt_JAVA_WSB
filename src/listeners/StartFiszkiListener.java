package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import program.OknoFiszki;
<<<<<<< HEAD

=======
import threads.FiszkiThread;

/**
 * Listener do przycisku START
 * Gdy kt�ry� checkbox jest zaznaczony, po naci�ni�ciu tego przycisku w��czy si� tryb odgadywania fiszek (FiszkiThread)
 * Ponadto ten przycisk po wci�ni�ciu zamieni si� w timer odliczaj�cy czas (ten w�tek zostaje uruchomiony ju� w FiszkiThread)
 */
>>>>>>> karol
public class StartFiszkiListener implements ActionListener
{
	/*
	private JButton przycisk;
	private JCheckBox checkBoxPolski;
	private JCheckBox checkBoxAngielski;
	private JButton wprowadzanie;
	private ArrayList<ParaSlow> paraSlow;
	*/
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
<<<<<<< HEAD
			if(getOknoFiszki().getPolski().isSelected() && !getOknoFiszki().getAngielski().isSelected())
			{
				getOknoFiszki().getStart().setText("Nast�pny");
			}
			else if(!getOknoFiszki().getPolski().isSelected() && getOknoFiszki().getAngielski().isSelected())
			{
				getOknoFiszki().getStart().setText("Nast�pny");
=======
			if((getOknoFiszki().getPolski().isSelected() && !getOknoFiszki().getAngielski().isSelected())
					|| (!getOknoFiszki().getPolski().isSelected() && getOknoFiszki().getAngielski().isSelected()))
			{
				dezaktywujPrzyciski();
				System.out.println("Zgadywanie angielskich s��w");
				new FiszkiThread(getOknoFiszki()).start();
>>>>>>> karol
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
<<<<<<< HEAD
		}	
	}
	
=======
		}

	}
	
	private void dezaktywujPrzyciski()
	{
		getOknoFiszki().getPolski().setEnabled(false);
		getOknoFiszki().getAngielski().setEnabled(false);
		getOknoFiszki().getWprowadzanie().setEnabled(false);
	}

	
>>>>>>> karol
}
