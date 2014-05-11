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
