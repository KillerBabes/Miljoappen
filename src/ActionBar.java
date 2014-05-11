import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.*;

public class ActionBar extends JPanel {
	private JButton menuButton;
	private JButton addButton;
	private JButton settingsButton;

	public ActionBar(String title) {
		setLayout(new BorderLayout());
		setBackground(new Color(0x3B, 0xB9, 0xFF));

		JLabel label = new JLabel("<html><body><p align=\"center\">" + title + "</p></body></html>", SwingConstants.CENTER);
		label.setFont(new Font(null, Font.PLAIN, 30));
		label.setForeground(Color.WHITE);
		add(label, BorderLayout.CENTER);
		menuButton = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/action/menu.png"));
			menuButton.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/action/menu.png\"");
		}

		menuButton.setMargin(new Insets(0, 0, 0, 0));
		menuButton.setBackground(new Color(0x3B, 0xB9, 0xFF));
		menuButton.setBorder(new EmptyBorder(10, 10, 10, 10));

		add(menuButton, BorderLayout.WEST);

		addButton = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/action/add.png"));
			addButton.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/action/add.png\"");
		}

		addButton.setMargin(new Insets(0, 0, 0, 0));
		addButton.setBackground(new Color(0x3B, 0xB9, 0xFF));
		addButton.setBorder(new EmptyBorder(10, 10, 10, 10));

		settingsButton = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/action/settings.png"));
			settingsButton.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/action/settings.png\"");
		}

		settingsButton.setMargin(new Insets(0, 0, 0, 0));
		settingsButton.setBackground(new Color(0x3B, 0xB9, 0xFF));
		settingsButton.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));
		panel.add(addButton);
		panel.add(settingsButton);

		add(panel, BorderLayout.EAST);
	}

	public JButton getMenuButton() {
		return menuButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getSettingsButton() {
		return settingsButton;
	}
}
