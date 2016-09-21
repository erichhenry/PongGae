import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class PongBall {
	public int xpos,ypos,xmin,xmax,ymin,ymax;
	public int xvel,yvel;
	public Pong game;
	public int rad;
	private Random gen;
	
	public PongBall(Pong current) {
		gen = new Random();
		game = current;
		rad = 12;
		xpos = game.getWidth()/2-rad;
		ypos = game.getHeight()/2-rad;
		
		xvel = 2;
		yvel = gen.nextInt(4)+2;
		if (gen.nextInt(2) == 0) {
			xvel = xvel * -1;
		}
		if (gen.nextInt(2) == 0) {
			yvel = yvel * -1;
		}
		
		xmin = game.getBounds().x;
		xmax = game.getBounds().width-(rad*2);
		ymin = game.getBounds().y;
		ymax = game.getBounds().height-(rad*2)-29;
	}
	
	public void update() {
		xpos +=xvel;
		ypos +=yvel;
		if (xpos <= xmin) {
			game.getPanel().goalCPU();
			xpos = game.getWidth()/2-rad;
			xvel = xvel * -1;
			yvel = gen.nextInt(4)+2;
		}
		else if (xpos >= xmax) {
			game.getPanel().goalHuman();
			xpos = game.getWidth()/2-rad;
			xvel = xvel * -1;
			yvel = gen.nextInt(4)+2;
		}
		if (ypos <= ymin || ypos >= ymax) {
			ypos = ypos - yvel - yvel;
			yvel = yvel * -1;
			
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(xpos, ypos, rad*2, rad*2);
	}

}
