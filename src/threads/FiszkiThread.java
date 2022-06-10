package threads;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import program.OknoFiszki;
import program.ParaSlow;
import program.Statystyki;

/**
 * W¹tek zaczyna pokazywaæ s³owa po polsku lub angielsku (w zale¿noœci od wybranego trybu) i nale¿y dopasowaæ do nich t³umaczenie.
 * U¿ytkownik ma 5 sekund na odpowiedz. Po tym czasie pole tekstowe zostanie zaznaczone na zielono lub czerwono zale¿nie, czy zosta³a udzielona prawid³owa odpowiedz.
 * Dodatkowo na czas 1 sekundy zostanie pokazana prawid³owa odpowiedz.
 * Ten w¹tek uruchamia wewn¹trz kolejny w¹tek: odliczanie czasu odpowiedzi (OdliczanieThread)
 */
public class FiszkiThread extends Thread
{
	private OknoFiszki oknoFiszki;
	
	public OknoFiszki getOknoFiszki() {
		return oknoFiszki;
	}
	public void setOknoFiszki(OknoFiszki oknoFiszki) {
		this.oknoFiszki = oknoFiszki;
	}

	public FiszkiThread(OknoFiszki oknoFiszki)
	{
		this.oknoFiszki = oknoFiszki;
	}
	
	@Override
	public void run()
	{
		JTextField pole1 = new JTextField();
		JTextField pole2 = new JTextField();
		boolean jezyk;
		int wynik = 0;
		int liczbaFiszek = 0;
		
		if(getOknoFiszki().getPolski().isSelected())
		{
			pole1 = getOknoFiszki().getFiszkaPolska();
			pole2 = getOknoFiszki().getFiszkaAngielska();
			jezyk = true;
		}
		else
		{
			pole2 = getOknoFiszki().getFiszkaPolska();
			pole1 = getOknoFiszki().getFiszkaAngielska();
			jezyk = false;
		}
		
		for(var elem : getOknoFiszki().LosujFiszki())	
		{
			try
			{
				new OdliczanieThread(getOknoFiszki().getStart(), 5).start();
				pole1.setText(getOknoFiszki().getPolski().isSelected()? elem.getSlowoPolskie() : elem.getSlowoAngielskie());
				Thread.sleep(5000);		
				if(pole2.getText().equals(getOknoFiszki().getPolski().isSelected() ? elem.getSlowoAngielskie() : elem.getSlowoPolskie()))
				{
					wynik++;
					liczbaFiszek++;
					dobraOdpowiedz(pole2);
					Thread.sleep(1000);
					wyzerujPole(pole2);
				}
				else
				{
					liczbaFiszek++;
					zlaOdpowiedz(pole2, elem, jezyk);
					Thread.sleep(1000);
					wyzerujPole(pole2);
				}	
			}
			catch(InterruptedException e)
			{
				System.out.println("W¹tek siê zatrzymuje");
				break;	//wyskakuje z for
			}
			finally
			{
				getOknoFiszki().getFiszkaAngielska().setText("");
				getOknoFiszki().getFiszkaPolska().setText("");
				if(getOknoFiszki().isCzyStart() == false) break;
			}
		}
		Statystyki.WynikFiszek.add(wynik);
		Statystyki.RozegraneFiszki.add(liczbaFiszek);
		if(getOknoFiszki().isCzyStart() == true) JOptionPane.showMessageDialog(null, "Cykl fiszek zakoñczony!");
		aktywujPrzyciski();
	}
	
	private void dobraOdpowiedz(JTextField pole)
	{
		pole.setEditable(false);
		pole.setBackground(new Color(50,205,50));
	}
	private void zlaOdpowiedz(JTextField pole, ParaSlow para, boolean jezyk)
	{
		pole.setBackground(new Color(255,0,0));
		pole.setText(jezyk == true ? para.getSlowoAngielskie() : para.getSlowoPolskie());
	}
	private void wyzerujPole(JTextField pole)
	{
		pole.setBackground(new Color(255,255,255));
		pole.setText("");
		pole.setEditable(true);
	}
	private void aktywujPrzyciski()
	{
		getOknoFiszki().getPolski().setEnabled(true);
		getOknoFiszki().getAngielski().setEnabled(true);
		getOknoFiszki().getStart().setText("START");
	}
}
