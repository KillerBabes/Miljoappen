import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;

public class Main extends JFrame {
	private JPanel startPanel;
	private JPanel navPanel;
	private Container contentPane;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		super("Miljöappen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(480, 800));
		contentPane = getContentPane();
		makeNavPanel();
		makeStartPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(startPanel, BorderLayout.CENTER);
		contentPane.add(navPanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	private void makeNavPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0, 50, 0));
		panel.setBackground(Color.BLACK);

		JButton button;

		button = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/nav/back.png"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/nav/back.png\".");
		}

		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBackground(Color.BLACK);
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				//back();
				System.out.println("Back");
			}
		});
		panel.add(button);

		button = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/nav/home.png"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/nav/home.png\".");
		}

		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBackground(Color.BLACK);
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				System.exit(0);
			}
		});
		panel.add(button);

		button = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/nav/multitask.png"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/nav/multitask.png\".");
		}

		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBackground(Color.BLACK);
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				//null
				System.out.println("Multitask");
			}
		});
		panel.add(button);

		navPanel = new JPanel();
		navPanel.setBackground(Color.BLACK);
		navPanel.add(panel);
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
