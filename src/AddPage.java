import java.awt.*;
import javax.swing.*;

public class AddPage extends Page {
	private ActionBar actionBar;

	public AddPage(String title) {
		super(title);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		actionBar = new ActionBar("Lägg till");
		add(actionBar, BorderLayout.NORTH);

		//TODO: this
		add(new JLabel("Add page"), BorderLayout.CENTER);
	}

	public ActionBar getActionBar() {
		return actionBar;
	}
}
