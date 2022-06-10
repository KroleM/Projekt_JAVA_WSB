package listeners;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 * Klasa, kt�ra obs�uguje przyciski klawiatury w Quizie 
 * Przyci�ni�cie na klawiaturze a, b, c, lub d powoduje wci�ni�cie przycisku w oknie.
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
