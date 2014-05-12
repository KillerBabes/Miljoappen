import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Application extends JFrame {
	public static final String title = "Miljöappen";

	private Items items;

	private Container contentPane;

	private LoginPage loginPage;
	private ProfilePage profilePage;
	private AddPage addPage;

	private Page currentPage;

	private NavBar navBar;

	private User user;

	public static void main(String[] args) {
		new Application();
	}

	public Application() {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(480, 800));
		setResizable(false);

		items = new Items();

		loginPage = new LoginPage("Login");

		ActionListener loginAction = new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				login();
			}
		};

		loginPage.getLoginButton().addActionListener(loginAction);
		loginPage.getNewUserButton().addActionListener(loginAction);

		profilePage = new ProfilePage("Profile");

		ActionListener addAction = new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				add();
			}
		};

		profilePage.getActionBar().getAddButton().addActionListener(addAction);

		addPage = new AddPage("Add");
		JComboBox<String> cBox = addPage.getCategoryBox();

		for (String s : items.getCategories()) {
			cBox.addItem(s);
		}

		updateItemBox();

		cBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateItemBox();
			}
		});

		addPage.getAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tryAdd();
			}
		});

		navBar = new NavBar();

		ActionListener backAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		};

		ActionListener exitAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		navBar.getBackButton().addActionListener(backAction);
		navBar.getHomeButton().addActionListener(exitAction);

		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(navBar, BorderLayout.SOUTH);
		contentPane.add(loginPage, BorderLayout.CENTER);
		currentPage = loginPage;

		pack();
		setVisible(true);
	}

	private void tryAdd() {
		JComboBox<String> cBox = addPage.getCategoryBox();
		JComboBox<Item> iBox = addPage.getItemBox();
		JTextField nField = addPage.getNumField();
		double num;

		try {
			num = Double.parseDouble(nField.getText());
		} catch (NumberFormatException e) {
			// If not a proper double
			return;
		}

		if (num < 0) {
			return;
		}

		nField.setText("");
		user.addCO2Consumed(num * iBox.getItemAt(iBox.getSelectedIndex()).getCO2());

		contentPane.removeAll();
		contentPane.add(navBar, BorderLayout.SOUTH);
		contentPane.add(profilePage, BorderLayout.CENTER);
		profilePage.update(user);
		currentPage = profilePage;

		pack();
		setVisible(true);
		repaint();
	}

	private void updateItemBox() {
		JComboBox<String> cBox = addPage.getCategoryBox();
		JComboBox<Item> iBox = addPage.getItemBox();

		iBox.removeAllItems();

		for (Item it : items.getItems(cBox.getItemAt(cBox.getSelectedIndex()))) {
			iBox.addItem(it);
		}
	}

	private void login() {
		user = new User("Adam");
		user.addCO2Consumed(30.0);
		user.setCO2Goal(90.0);
		profilePage.update(user);

		contentPane.removeAll();
		contentPane.add(navBar, BorderLayout.SOUTH);
		contentPane.add(profilePage, BorderLayout.CENTER);
		currentPage = profilePage;

		pack();
		setVisible(true);
	}

	private void add() {
		if (currentPage.getTitle().equals("Add")) {
			return;
		}

		contentPane.removeAll();
		contentPane.add(navBar, BorderLayout.SOUTH);
		contentPane.add(addPage, BorderLayout.CENTER);
		currentPage = addPage;

		pack();
		setVisible(true);
		repaint();
	}

	private void back() {
		if (!currentPage.getTitle().equals("Add")) {
			System.exit(0);
		}

		contentPane.removeAll();
		contentPane.add(navBar, BorderLayout.SOUTH);
		contentPane.add(profilePage, BorderLayout.CENTER);
		currentPage = profilePage;

		pack();
		setVisible(true);
		repaint();
	}
}
