import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.*;

public class NavBar extends JPanel {
	private JButton backButton;
	private JButton homeButton;
	private JButton multitaskButton;

	public NavBar() {
		setLayout(new GridLayout(1, 0, 50, 0));
		setBackground(Color.BLACK);
		setBorder(new EmptyBorder(10, 20, 10, 20));

		backButton = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/nav/back.png"));
			backButton.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/nav/back.png\".");
		}

		backButton.setMargin(new Insets(0, 0, 0, 0));
		backButton.setBackground(Color.BLACK);
		backButton.setBorder(null);

		add(backButton);

		homeButton = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/nav/home.png"));
			homeButton.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/nav/home.png\".");
		}

		homeButton.setMargin(new Insets(0, 0, 0, 0));
		homeButton.setBackground(Color.BLACK);
		homeButton.setBorder(null);

		add(homeButton);

		multitaskButton = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/nav/multitask.png"));
			multitaskButton.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/nav/multitask.png\".");
		}

		multitaskButton.setMargin(new Insets(0, 0, 0, 0));
		multitaskButton.setBackground(Color.BLACK);
		multitaskButton.setBorder(null);

		add(multitaskButton);
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	private JButton getMultitaskButton() {
		return multitaskButton;
	}
}
