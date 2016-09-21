import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle {
	
	public Pong game;
	public int xpos, ypos;
	public int length;
	public int curDir;
	
	public AIPaddle(Pong current, int xval) {
		game = current;
		length = 100;
		xpos = xval;
		curDir = 0;
		ypos = game.getHeight()/2-length/2;
	}
	
	public void update() {
		int curMidPaddle = ypos+length/2;
		int curMidBall = game.getPanel().ball.ypos+game.getPanel().ball.rad;
		if (curMidPaddle < curMidBall) {
			curDir = 1;
		}
		else if (curMidPaddle > curMidBall) {
			curDir = -1;
		}
		else {
			curDir = 0;
		}
		if (ypos > 0 && ypos < game.getHeight()-length-29) {
			ypos += curDir;
		}
		else if (ypos == game.getHeight()-length-29) {
			ypos--;
		}
		else if (ypos == 0) {
			ypos++;
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(xpos, ypos, 30, length);
	}
	
}
