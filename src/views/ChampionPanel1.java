package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.*;

import engine.Game;
import model.world.Champion;

import java.awt.event.ItemListener;

	public class ChampionPanel1 extends JPanel implements ItemListener, ActionListener {
	private Marvel marvel;

	private JLabel title1;
    private JLabel title2;
    private JLabel title3;
    private JLabel title4;
	private JLabel Leader1;
	private JLabel champ11;
	private JLabel champ12;

	 private JComboBox Box1;
	 private JComboBox Box2;
	 private JComboBox Box3;
	 
	 private ArrayList<String> array;
	 private JComboBox champions;
	 
	 private JButton next;
     private JLabel Label;
     private JTextArea infos;
	
    
	 public ChampionPanel1(Marvel marvel) {
			this.marvel = marvel;
			this.setLayout(null);
			title1 = new JLabel("First Player Champions");
			title1.setBounds(20, 50, 200, 25);
			title1.setFont(new Font("Verdana",  Font.BOLD, 15));
			title1.setForeground(Color.green);
			this.add(title1);
			
			
			title2 = new JLabel("Select Leader");
			title2.setBounds(20, 200, 170, 25);
			title2.setFont(new Font("Verdana",  Font.BOLD, 15));
			title2.setForeground(Color.green);
			this.add(title2);
			
			
			title3 = new JLabel("Select Champion 1");
			title3.setBounds(20, 350, 170, 25);
			title3.setFont(new Font("Verdana",  Font.BOLD, 15));
			title3.setForeground(Color.green);
			this.add(title3);
			
			title4 = new JLabel("Select Champion 2");
			title4.setBounds(20, 550, 170, 25);
			title4.setFont(new Font("Verdana",  Font.BOLD, 15));
			title4.setForeground(Color.green);
			this.add(title4);
			
				
			Box1=new JComboBox<String>(marvel.getChampions());
			Box1.setBounds(250, 200, 200, 30);
			Box1.addItemListener(this);
			this.add(Box1);
			
			
			Box2=new JComboBox<String>(marvel.getChampions());
			Box2.setBounds(250, 350, 200, 30);
			Box2.addItemListener(this);
			this.add(Box2);
			
			
			Box3=new JComboBox<String>(marvel.getChampions());
			Box3.setBounds(250, 550, 200, 30);
			Box3.addItemListener(this);
			this.add(Box3);
				
			
			next=new JButton("Next");
		    next.setBounds(400,750,200,30);
		    next.addItemListener(this);
		    next.addActionListener(this);
		    this.add(next);
			
		    infos= new JTextArea();
		    infos.setBounds(700,20,400,300);
		    infos.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 15));
		    infos.setEditable(false);
		    this.add(infos);
			
		    ImageIcon image=new ImageIcon("test.jpg");
			Label = new JLabel("");
			Label.setBounds(0, 0, 1600,1000);
			//Label.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
			Label.setIcon(image);
			this.add(Label);
			
	 }





		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == next) {
				if(Box1.getSelectedItem() == Box2.getSelectedItem()
						|| Box1.getSelectedItem() == Box3.getSelectedItem() 
						|| Box3.getSelectedItem() == Box2.getSelectedItem()) {
					
					JOptionPane.showMessageDialog(this, "3 Champions must be Different", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			
			
				else {
					marvel.switchToChampionPanel2(Box1.getSelectedIndex(),Box2.getSelectedIndex(),Box3.getSelectedIndex());
		}

		}
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==Box1)
				infos.setText(marvel.info(Box1.getSelectedIndex()));
			else if(e.getSource()==Box2)
				infos.setText(marvel.info(Box2.getSelectedIndex()));
			else if(e.getSource()==Box3)
				infos.setText(marvel.info(Box3.getSelectedIndex()));
		}
		
		
		}



	