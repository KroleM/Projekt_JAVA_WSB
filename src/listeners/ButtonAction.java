package listeners;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * 
 * @author marci
 *
 */
public class ButtonAction extends AbstractAction
{
	private JButton button;

	public ButtonAction(JButton button)
	{
		this.button = button;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		button.doClick();
	}
}
