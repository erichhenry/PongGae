import javax.swing.JFrame;

public class Pong extends JFrame {
	
	private PongPanel gamepanel;
	private int winheight;
	private int winwidth;

	public Pong() {
		winheight = 800;
		winwidth = 1200;
		this.setTitle("Pong");
		this.setBounds(0,0,winwidth,winheight);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gamepanel = new PongPanel(this);
		add(gamepanel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Pong();
	}
	
	public int getWidth() {
		return winwidth;
	}
	
	public int getHeight() {
		return winheight;
	}
	
	public PongPanel getPanel() {
		return gamepanel;
	}
}
