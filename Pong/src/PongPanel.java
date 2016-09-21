import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
	public PongBall ball;
	private Pong game;
	private PongPaddle human;
	private AIPaddle cpu;
	private int humanscore;
	private int cpuscore;
	
	public PongPanel(Pong current) {
		this.setBackground(Color.blue);
		game = current;
		humanscore = 0;
		cpuscore = 0;
		ball = new PongBall(game);
		human = new PongPaddle(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 30);
		cpu = new AIPaddle(game, game.getWidth()-30-30);
		Timer clock = new Timer(5, this);
		clock.start();
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
	}
	
	public void goalCPU() {
		cpuscore++;
		if (cpuscore == 10) {
			repaint();
			JOptionPane.showMessageDialog(this, "CPU Wins!\n Exiting", "You lost to a primative robot", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}
	
	public void goalHuman() {
		humanscore++;
		if (humanscore == 10) {
			repaint();
			JOptionPane.showMessageDialog(this, "You Win!\n Exiting", "Congratulations!", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}
	
	public void update() {
		ball.update();
		human.update();
		cpu.update();
		checkPaddleHit();
	}
	
	public void checkPaddleHit() {
		if ((ball.xpos == human.xpos+30 && ball.ypos+ball.rad >= human.ypos && ball.ypos-ball.rad <= human.ypos+human.length) || (ball.xpos+ball.rad*2 == cpu.xpos && ball.ypos+ball.rad >= cpu.ypos && ball.ypos-ball.rad <= cpu.ypos+cpu.length)) {
			ball.xvel *= -1;
		}		
	}

	public void keyPressed(KeyEvent key) {
		human.pressed(key.getKeyCode());
	}

	public void keyReleased(KeyEvent key) {
		human.released(key.getKeyCode());
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		Font font = new Font("Times New Roman", Font.BOLD, 40);
		g.setFont(font);
		g.drawString(humanscore + " : " + cpuscore, game.getWidth()/2, 50);
		ball.paint(g);
		human.paint(g);
		cpu.paint(g);
	}
}
