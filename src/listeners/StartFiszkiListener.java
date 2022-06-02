package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import program.OknoFiszki;

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
			if(getOknoFiszki().getPolski().isSelected() && !getOknoFiszki().getAngielski().isSelected())
			{
				getOknoFiszki().getStart().setText("Nastêpny");
			}
			else if(!getOknoFiszki().getPolski().isSelected() && getOknoFiszki().getAngielski().isSelected())
			{
				getOknoFiszki().getStart().setText("Nastêpny");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	}
	
}
