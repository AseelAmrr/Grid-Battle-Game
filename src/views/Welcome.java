package views;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
public class Welcome extends JPanel implements ActionListener  {
	private Marvel marvel;
	private JButton startGame;
	private JList<String> list1;
	private JLabel Label;
	private JLabel label1;

	public Welcome(Marvel marvel) {
		
		this.marvel = marvel;
		this.setLayout(null);
		startGame = new JButton("Start Game");
		setOpaque(true);
		startGame.setBounds(650, 600, 200, 40);
		 startGame.setBackground(Color.BLACK);
		 startGame.setFont(new Font("Monospace", Font.BOLD, 18));
		startGame.addActionListener(this);
		this.add(startGame);
		  
		label1 = new JLabel("Copyrights @guc,2022");
		label1.setBounds(680, 800, 300, 25);
		label1.setFont(new Font("Monospace", Font.BOLD, 12));
		label1.setForeground(Color.white);
		this.add(label1);
		
		ImageIcon image=new ImageIcon("namepanel 2.jpg");
		//image.getImage().getScaledInstance(1600,800,java.awt.Image.SCALE_SMOOTH);
		
		Label = new JLabel("");
		Label.setBounds(0, 0, 1600,1000);
		
		Label.setIcon(image);
		this.add(Label);
		playSound("song.mp3");
	
		

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startGame) {
			marvel.switchToNamePanel();
			
		}

	}

	
	public void playSound(final String filepath) {
		new Thread(new Runnable() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Applet.newAudioClip(getClass().getResource(filepath)).play();
				
			}
			
		}).start();
	}

}
