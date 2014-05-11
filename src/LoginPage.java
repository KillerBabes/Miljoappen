import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginPage extends Page {
	private JButton loginButton;
	private JButton newUserButton;

	public LoginPage(String title) {
		super(title);
		setLayout(new GridLayout(0, 1, 50, 50));
		setBackground(new Color(0x3B, 0xB9, 0XFF));
		setBorder(new EmptyBorder(30, 50, 30, 50));

		JLabel label = new JLabel("<html><body><p align=\"center\">Välkommen till<br>Miljöappen</p></body></html>", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 36));
		label.setForeground(Color.WHITE);

		loginButton = new JButton("Logga in");
		loginButton.setFont(new Font(null, Font.PLAIN, 20));
		loginButton.setBackground(Color.WHITE);
		loginButton.setBorder(new LineBorder(Color.BLACK, 2));

		newUserButton = new JButton("Ny användare");
		newUserButton.setFont(new Font(null, Font.PLAIN, 20));
		newUserButton.setBackground(Color.WHITE);
		newUserButton.setBorder(new LineBorder(Color.BLACK, 2));

		add(label);
		add(loginButton);
		add(newUserButton);
		add(new JLabel(""));
		add(new JLabel(""));
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JButton getNewUserButton() {
		return newUserButton;
	}
}
