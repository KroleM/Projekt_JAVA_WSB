package listeners;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * Klasa, która obs³uguje przyciski klawiatury w Quizie 
 * Przyciœniêcie na klawiaturze a, b, c, lub d powoduje wciœniêcie przycisku w oknie.
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
