package views;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;
public class NamePanel extends JPanel implements ActionListener {
	private Marvel marvel;
	private JLabel label1;
	private JLabel label2;

	private JTextField name1;
	private JTextField name2;

	private JButton next;
	private JLabel Label;

	public NamePanel(Marvel marvel) {
		this.marvel = marvel;

		this.setLayout(null);

		label1 = new JLabel("First Player name:");
		label1.setBounds(150, 100, 150, 25);
		label1.setFont(new Font("SANS_SERIF", Font.ITALIC, 15));
		label1.setForeground(Color.green);
		this.add(label1);

		name1 = new JTextField("");
		name1.setBounds(280, 100, 150, 25);
		this.add(name1);

		label2 = new JLabel("Second Player name:");
		label2.setBounds(800, 100, 150, 25);
		label2.setFont(new Font("SANS_SERIF", Font.ITALIC, 15));
		label2.setForeground(Color.green);
		this.add(label2);

		name2 = new JTextField("");
		name2.setBounds(950, 100, 150, 25);
		this.add(name2);

		next = new JButton(">>>");
		next.setBounds(500, 500, 120, 50);
		next.setForeground(Color.blue);
		next.addActionListener(this);
		next.setIcon(new ImageIcon("button next 2.jpeg"));
		this.add(next);

		ImageIcon image=new ImageIcon("namepanel 2.jpg");
		//image.getImage().getScaledInstance(1600,800,java.awt.Image.SCALE_SMOOTH);
		
		Label = new JLabel("");
		Label.setBounds(0, 0, 1600,1000);
		
		Label.setIcon(image);
		this.add(Label);

	}

	public void actionPerformed(ActionEvent e) {
		if (name1.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Player 1 must have a name", "Error", JOptionPane.ERROR_MESSAGE);
		else if (name2.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Player 2 must have a name", "Error", JOptionPane.ERROR_MESSAGE);
		else {
			marvel.switchToChampionPanel1(name1.getText(),name2.getText());
			
		}

	}

}