import javax.swing.JPanel;

public class Page extends JPanel {
	protected String title;

	public Page(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
