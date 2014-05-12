import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class AddPage extends Page {
	private ActionBar actionBar;
	private JComboBox<String> categoryBox;
	private JComboBox<Item> itemBox;
	private JTextField numField;
	private JButton addButton;

	public AddPage(String title) {
		super(title);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		actionBar = new ActionBar("Lägg till");
		add(actionBar, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(50, 100, 300, 100));
		panel.setLayout(new GridLayout(0, 1));

		categoryBox = new JComboBox<String>();
		itemBox = new JComboBox<Item>();
		numField = new JTextField();
		addButton = new JButton("Lägg till");

		panel.add(categoryBox);
		panel.add(new JLabel(""));
		panel.add(itemBox);
		panel.add(new JLabel(""));
		panel.add(new JLabel("Antal:"));
		panel.add(numField);
		panel.add(new JLabel(""));
		panel.add(addButton);
		add(panel, BorderLayout.CENTER);
	}

	public ActionBar getActionBar() {
		return actionBar;
	}

	public JComboBox<String> getCategoryBox() {
		return categoryBox;
	}

	public JComboBox<Item> getItemBox() {
		return itemBox;
	}

	public JTextField getNumField() {
		return numField;
	}

	public JButton getAddButton() {
		return addButton;
	}
}
