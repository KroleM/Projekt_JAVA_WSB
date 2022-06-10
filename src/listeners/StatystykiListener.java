package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import program.OknoGlowne;
import program.OknoStatystyki;

/**
 * Akcja wywo³ana przyciskiem QUIZ
 * Otwiera okno quizu oraz ukrywa Okno g³ówne
 */
public class StatystykiListener implements ActionListener
{
	private OknoGlowne okno;
	
	public OknoGlowne getOkno() {
		return okno;
	}
	public void setOkno(OknoGlowne okno) {
		this.okno = okno;
	}
	
	public StatystykiListener(OknoGlowne okno)
	{
		super();
		this.okno = okno;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			new OknoStatystyki(getOkno());
			getOkno().getFrame().setVisible(false);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
}
