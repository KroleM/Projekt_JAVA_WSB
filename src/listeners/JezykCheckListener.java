package listeners;

<<<<<<< HEAD
=======
import java.awt.Font;
>>>>>>> karol
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

<<<<<<< HEAD
import program.OknoFiszki;
=======
>>>>>>> karol

/**
 * Akcja wywo³ana CheckBoxami polski/angielski w karcie Fiszki
 * Pozwala na rozpoczêcie wpisywania t³umaczeñ w wybranym jezyku
 */
public class JezykCheckListener implements ActionListener
{
	private JCheckBox checkbox1;
	private JCheckBox checkbox2;
	private JTextField pole1;
	private JTextField pole2;
	
	public JCheckBox getCheckbox1() {
		return checkbox1;
	}
	public void setCheckbox1(JCheckBox checkbox1) {
		this.checkbox1 = checkbox1;
	}
	public JCheckBox getCheckbox2() {
		return checkbox2;
	}
	public void setCheckbox2(JCheckBox checkbox2) {
		this.checkbox2 = checkbox2;
	}
	public JTextField getPole1() {
		return pole1;
	}
	public void setPole1(JTextField pole1) {
		this.pole1 = pole1;
	}
	public JTextField getPole2() {
		return pole2;
	}
	public void setPole2(JTextField pole2) {
		this.pole2 = pole2;
	}
	
	public JezykCheckListener(JCheckBox checkbox1, JCheckBox checkbox2, JTextField pole1, JTextField pole2)
	{
		super();
		this.checkbox1 = checkbox1;
		this.checkbox2 = checkbox2;
		this.pole1 = pole1;
		this.pole2 = pole2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			if(checkbox1.isSelected())
			{
				dezaktywacja(pole1, pole2);
<<<<<<< HEAD
=======
				pole1.setFont(new Font("Calibri", Font.BOLD, 14));
				pole2.setFont(new Font("Calibri", Font.BOLD, 14));
>>>>>>> karol
				checkbox2.setSelected(false);
			}
			else
			{
				aktywacja(pole1, pole2);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	private void dezaktywacja(JTextField pole1, JTextField pole2)
	{
		pole1.setEnabled(false);
		//pole1.setEditable(false);
		pole2.setEnabled(true);
		//pole2.setEditable(true);
	}
	private void aktywacja(JTextField pole1, JTextField pole2)
	{
		pole1.setEnabled(true);
		pole1.setEditable(true);
		pole2.setEnabled(true);
		pole2.setEditable(true);
	}
}
