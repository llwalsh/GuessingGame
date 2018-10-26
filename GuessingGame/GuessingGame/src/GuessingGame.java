import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */

/**
 * @author lauren
 *
 */
public class GuessingGame extends JFrame
{
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	
	public void CheckGuess()
	{
		String guessText = txtGuess.getText();
		String message = "";
		int guess;
		
		try
		{
			guess = Integer.parseInt(guessText);
		
			if (guess < theNumber)
				message = guess + " is too low.";
			else if (guess > theNumber)
				message = guess + " is too high.";
			else
			{
				message = guess + " is correct. You win! Let's play again! There is no escape!";
				NewGame();
			}
		}
		catch(Exception ex)
		{
			message = "Enter a whole number between 1 and 100.";
		}
		finally
		{
			lblOutput.setText(message);	
			txtGuess.requestFocus();
			txtGuess.selectAll();		
		}
	}
	
	public void NewGame()
	{
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(Color.MAGENTA);
		setFont(new Font("Arial Black", Font.BOLD, 14));
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblMyLabel = new JLabel("BEHOLD! MY LABEL!");
		lblMyLabel.setBounds(0, 0, 687, 22);
		lblMyLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblMyLabel.setForeground(Color.MAGENTA);
		lblMyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMyLabel);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100: ");
		lblGuessANumber.setBounds(0, 99, 297, 33);
		lblGuessANumber.setFont(new Font("Arial Black", Font.PLAIN, 14));
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckGuess();
			}
		});
		txtGuess.setToolTipText("Enter a number between 1 and 100");
		txtGuess.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtGuess.setBounds(292, 100, 55, 32);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(3);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				CheckGuess();
			}
		});
		//btnGuess.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {} });
		btnGuess.setToolTipText("Click Guess button after entering a number in the text box");
		btnGuess.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnGuess.setBounds(273, 191, 141, 35);
		getContentPane().add(btnGuess);
		
		lblOutput =  new JLabel("");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(123, 290, 422, 26);
		getContentPane().add(lblOutput);
	} 

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		GuessingGame theGame = new GuessingGame();
		theGame.NewGame();
		theGame.setSize(new Dimension(700,450));
		theGame.setVisible(true);
	}
}
