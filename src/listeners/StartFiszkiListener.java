package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import program.OknoFiszki;


import threads.FiszkiThread;

/**
 * Listener do przycisku START
 * Gdy któryœ checkbox jest zaznaczony, po naciœniêciu tego przycisku w³¹czy siê tryb odgadywania fiszek (FiszkiThread)
 * Ponadto ten przycisk po wciœniêciu zamieni siê w timer odliczaj¹cy czas (ten w¹tek zostaje uruchomiony ju¿ w FiszkiThread)
 */
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
			if((getOknoFiszki().getPolski().isSelected() && !getOknoFiszki().getAngielski().isSelected())
					|| (!getOknoFiszki().getPolski().isSelected() && getOknoFiszki().getAngielski().isSelected()))
			{
				dezaktywujPrzyciski();
				System.out.println("Zgadywanie angielskich s³ów");
				new FiszkiThread(getOknoFiszki()).start();
			}
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
		getOknoFiszki().getWprowadzanie().setEnabled(false);
	}

}
