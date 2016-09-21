import java.awt.Color;
import java.awt.Graphics;

public class PongPaddle {
	
	public Pong game;
	public int xpos, ypos;
	public int length;
	public int upKey, downKey;
	public int curDir;
	
	public PongPaddle(Pong current, int updir, int downdir, int xval) {
		game = current;
		length = 100;
		xpos = xval;
		upKey = updir;
		downKey = downdir;
		curDir = 0;
		ypos = game.getHeight()/2-length/2;
	}
	
	public void update() {
		if (ypos > 0 && ypos < game.getHeight()-length-29) {
			ypos += curDir;
		}
		else if (ypos >= game.getHeight()-length-29) {
			ypos -= 2;
		}
		else if (ypos <= 0) {
			ypos += 2;
		}
	}
	
	public void pressed(int key) {
		if (key == upKey) {
			curDir = -2;
		}
		else if (key == downKey) {
			curDir = 2;
		}
	}
	
	public void released(int key) {
		if (key == upKey || key == downKey) {
			curDir = 0;
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(xpos, ypos, 30, length);
	}
	
}
