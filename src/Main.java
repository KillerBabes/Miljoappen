import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
	private JPanel startPanel;
	private Container contentPane;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(480, 800));
		contentPane = getContentPane();
		makeStartPanel();
		contentPane.add(startPanel);
		pack();
		setVisible(true);
	}

	private void makeStartPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 50, 50));

		JLabel label = new JLabel("<html><body><p align=\"center\">Välkommen till<br>Miljöappen!</p></body></html>", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 36));
		label.setForeground(Color.WHITE);
		panel.add(label);

		JButton button;

		button = new JButton("Logga in");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				//logIn();
				System.out.println("Logga in");
			}
		});
		panel.add(button);

		button = new JButton("Ny användare");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				//newUser();
				System.out.println("Ny användare");
			}
		});
		panel.add(button);

		panel.setPreferredSize(new Dimension(360, 540));
		panel.setBackground(Color.BLUE);

		startPanel = new JPanel();
		startPanel.add(panel);
		startPanel.setBackground(Color.BLUE);
	}
}
