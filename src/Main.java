import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;

public class Main extends JFrame {
	private JPanel actionPanel;
	private JLabel actionLabel;
	private JPanel startPanel;
	private JPanel navPanel;
	private JPanel profilPanel;
	private JPanel addPanel;
	private Container contentPane;
	private String currentPage;
	private Read read;
	private double carbon;
	private double carbonGoal;
	private JLabel carbonConsumedLabel;
	private JLabel carbonLeftLabel;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		super("Miljöappen");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(480, 800));
		contentPane = getContentPane();
		makeActionPanel();
		makeNavPanel();
		makeStartPanel();

		read = new Read();
		carbon = 30.0;
		carbonGoal = 90.0;

		makeProfilPanel();

		contentPane.setLayout(new BorderLayout());
		currentPage = "welcome";
		contentPane.add(startPanel, BorderLayout.CENTER);
		contentPane.add(navPanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	private void start() {
		currentPage = "profil";
		contentPane.removeAll();
		contentPane.add(actionPanel, BorderLayout.NORTH);
		contentPane.add(navPanel, BorderLayout.SOUTH);
		contentPane.add(profilPanel, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private void add() {
		currentPage = "add";
		contentPane.removeAll();
		contentPane.add(actionPanel, BorderLayout.NORTH);
		contentPane.add(navPanel, BorderLayout.SOUTH);
		contentPane.add(addPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	private void back() {
		if (currentPage.equalsIgnoreCase("add")) {
			start();
		} else {
			System.exit(0);
		}
	}

	private void makeActionPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0, 10, 0));

		JButton button;

		button = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/action/menu.png"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/action/menu2.png\".");
		}

		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
			}
		});
		panel.add(button);

		actionLabel = new JLabel("Miljöappen");
		actionLabel.setFont(new Font("Serif", Font.BOLD, 25));
		panel.add(actionLabel);

		button = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/action/add2.png"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/action/add.png\".");
		}

		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				add();
			}
		});
		panel.add(button);

		button = new JButton();

		try {
			Image img = ImageIO.read(new File("../res/action/settings2.png"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("error: Couldn't read file \"../res/action/settings.png\".");
		}

		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBorder(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
			}
		});
		panel.add(button);

		actionPanel = new JPanel();
		actionPanel.add(panel);
	}

	private void makeProfilPanel() {
		profilPanel = new JPanel();
		profilPanel.setLayout(new GridLayout(0, 1, 0, 50));

		profilPanel.add(new JLabel(""));

		JLabel hejLabel = new JLabel("<html><body>Hej Adam!</body></html>", SwingConstants.CENTER);
		profilPanel.add(hejLabel);
		hejLabel.setFont(new Font("Serif", Font.BOLD, 32));

		carbonConsumedLabel = new JLabel("<html><body><p align=\"center\">Du har förbrukat " + carbon + " kg CO2<br>denna vecka.</p></body></html>", SwingConstants.CENTER);
		profilPanel.add(carbonConsumedLabel);
		carbonConsumedLabel.setFont(new Font("Serif", Font.BOLD, 24));

		carbonLeftLabel = new JLabel("<html><body><p align=\"center\">Du har " + (carbonGoal - carbon) + " kg CO2 kvar<br>till ditt mål på " + carbonGoal + " kg CO2.</p></body></html>", SwingConstants.CENTER);
		profilPanel.add(carbonLeftLabel);
		carbonLeftLabel.setFont(new Font("Serif", Font.BOLD, 24));

		profilPanel.add(new JLabel(""));
		profilPanel.add(new JLabel(""));
		profilPanel.add(new JLabel(""));
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
				back();
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
				start();
			}
		});
		panel.add(button);

		button = new JButton("Ny användare");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				start();
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
