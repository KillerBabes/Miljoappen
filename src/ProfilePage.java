import java.awt.*;
import javax.swing.*;

public class ProfilePage extends Page {
	private ActionBar actionBar;
	private JPanel content;
	private JLabel helloLabel;
	private JLabel consumedLabel;
	private JLabel remainingLabel;
	private JPanel summaryPanel;
	private JLabel goalLabel;
	private JLabel usedLabel;
	private JLabel leftLabel;

	public ProfilePage(String title) {
		super(title);
		setLayout(new BorderLayout());
		actionBar = new ActionBar("Profil");
		content = new JPanel();
		content.setLayout(new GridLayout(0, 1));
		content.setBackground(Color.WHITE);

		helloLabel = new JLabel("<html><body>Hej namn</body></html>", SwingConstants.CENTER);
		consumedLabel = new JLabel("<html><body>Du har förbrukat x kg CO<sub>2</sub> denna vecka.</body></html>", SwingConstants.CENTER);
		remainingLabel = new JLabel("<html><body>Du har y kg CO<sub>2</sub> kvar av din kvot till ditt<br>mål på z kg CO<sub>2</sub></body></html>", SwingConstants.CENTER);
		summaryPanel = new JPanel();
		summaryPanel.setLayout(new GridLayout(1, 0));
		goalLabel = new JLabel("<html><body><p align=\"center\">z<br>MÅL</p></body></html>", SwingConstants.CENTER);
		usedLabel = new JLabel("<html><body><p align=\"center\">x<br>KONSUMERAT</p></body></html>", SwingConstants.CENTER);
		leftLabel = new JLabel("<html><body><p align=\"center\">y<br>KVAR</p></body></html>", SwingConstants.CENTER);
		summaryPanel.add(goalLabel);
		summaryPanel.add(usedLabel);
		summaryPanel.add(leftLabel);

		content.add(new JLabel(""));
		content.add(helloLabel);
		content.add(new JLabel(""));
		content.add(consumedLabel);
		content.add(new JLabel(""));
		content.add(remainingLabel);
		content.add(new JLabel(""));
		content.add(new JLabel(""));
		content.add(new JLabel(""));
		content.add(new JLabel(""));
		content.add(summaryPanel);

		add(content, BorderLayout.CENTER);
		add(actionBar, BorderLayout.NORTH);
	}

	public ActionBar getActionBar() {
		return actionBar;
	}

	public void update(User user) {
		helloLabel.setText("<html><body>Hej " + user.getName() + "</body></html>");
		consumedLabel.setText("<html><body>Du har förbrukat " + String.format("%.1f", user.getCO2Consumed()) + " kg CO<sub>2</sub> denna vecka.</body></html>");
		remainingLabel.setText("<html><body>Du har " + String.format("%.1f", user.getCO2Goal() - user.getCO2Consumed()) + " kg CO<sub>2</sub> kvar av din kvot till ditt<br>mål på " + user.getCO2Goal() + " kg CO<sub>2</sub></body></html>");
		goalLabel.setText("<html><body><p align=\"center\">" + String.format("%.1f", user.getCO2Goal()) +"<br>MÅL</p></body></html>");
		usedLabel.setText("<html><body><p align=\"center\">" + String.format("%.1f", user.getCO2Consumed()) + "<br>KONSUMERAT</p></body></html>");
		leftLabel.setText("<html><body><p align=\"center\">" + String.format("%.1f", user.getCO2Goal() - user.getCO2Consumed()) + "<br>KVAR</p></body></html>");
	}
}
