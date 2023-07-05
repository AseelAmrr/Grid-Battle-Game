package views;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import model.world.Champion;

import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
public class ChampionPanel2 extends JPanel implements ActionListener,ItemListener {
	private Marvel marvel;

	private JLabel title1;
    private JLabel title2;
    private JLabel title3;
    private JLabel title4;
	private JLabel Leader1;
	private JLabel champ11;
	private JLabel champ12;
    private JLabel Label;
	 private JComboBox Box4;
	 private JComboBox Box5;
	 private JComboBox Box6;
	 
	 private ArrayList<String> array;
	 private JComboBox champions;
	 
	 private JButton next;

	
	 private JTextArea infos;
	 private int Box1;
	 private int Box2;
	private int Box3;



	public ChampionPanel2(Marvel marvel, int o1,int o2,int o3) {
	    this.Box1 = o1;
	    this.Box2 = o2;
	    this.Box3 = o3;
			this.marvel = marvel;
			this.setLayout(null);
			title1 = new JLabel("Second Player Champions");
			title1.setBounds(20, 50, 250, 25);
			title1.setFont(new Font("Verdana",  Font.BOLD, 15));
			title1.setForeground(Color.green);
			this.add(title1);
			
			
			title2 = new JLabel("Select Leader");
			title2.setBounds(20, 200, 170, 25);
			title2.setFont(new Font("Verdana" , Font.BOLD, 15));
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
			
				
			Box4=new JComboBox<String>(marvel.getChampions());
			Box4.setBounds(250, 200, 200, 30);
			Box4.addItemListener(this);
			this.add(Box4);
			
			
			Box5=new JComboBox<String>(marvel.getChampions());
			Box5.setBounds(250, 350, 200, 30);
			Box5.addItemListener(this);
			this.add(Box5);
			
			
			Box6=new JComboBox<String>(marvel.getChampions());
			Box6.setBounds(250, 550, 200, 30);
			Box6.addItemListener(this);
			this.add(Box6);
				
			
			next=new JButton("Next");
		    next.setBounds(400,750,200,30);
		    next.addItemListener(this);
		    next.addActionListener(this);
		    this.add(next);
		    infos= new JTextArea();
		    infos.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 15));
		    infos.setBounds(700,20,400,300);
		    infos.setEditable(false);
		    
		    	
		    this.add(infos);
			
		    ImageIcon image=new ImageIcon("test.jpg");
			Label = new JLabel("");
			Label.setBounds(0, 0, 1600,1000);
			Label.setIcon(image);
			this.add(Label);
			
			
		}



				
			
		
			
			
			
			
		



		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == next) {
				if(Box4.getSelectedItem() == Box5.getSelectedItem()
						|| Box4.getSelectedItem() == Box6.getSelectedItem() 
						|| Box6.getSelectedItem() == Box5.getSelectedItem()) {
					
					JOptionPane.showMessageDialog(this, "3 Champions must be Different", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(Box4.getSelectedIndex()== Box1
						|| Box4.getSelectedIndex() ==Box2
						|| Box4.getSelectedIndex() ==Box3
						|| Box5.getSelectedIndex()== Box1
						|| Box5.getSelectedIndex() ==Box2
						|| Box5.getSelectedIndex() ==Box3
						|| Box6.getSelectedIndex()== Box1
						|| Box6.getSelectedIndex() ==Box2
						|| Box6.getSelectedIndex() ==Box3) {
					
					JOptionPane.showMessageDialog(this, "3 Champions must be Different from first player's champions", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
					marvel.switchToGamePanel(Box1, Box2, Box3, Box4.getSelectedIndex(), Box5.getSelectedIndex(), Box6.getSelectedIndex());
				
				}
					
				
			
			
		}


		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==Box4)
				infos.setText(marvel.info(Box4.getSelectedIndex()));
			else if(e.getSource()==Box5)
				infos.setText(marvel.info(Box5.getSelectedIndex()));
			else if(e.getSource()==Box6)
				infos.setText(marvel.info(Box6.getSelectedIndex()));
		}
		
		}

