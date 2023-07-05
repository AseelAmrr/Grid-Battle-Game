package views;

import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
public class GamePanel extends JPanel implements ActionListener {
  private Marvel marvel;
  private JPanel panel1;
  private JButton[][] buttons;
   
  
  private JPanel panel2;
  private JButton up;
  private JButton down;
  private JButton left;
  private JButton right;
  
  private JButton up1;
  private JButton down1;
  private JButton left1;
  private JButton right1;
   
  private Direction d=Direction.LEFT;
  
  private JPanel panel3;
  private JComboBox<String> abilitiesCombo;

  private JButton castAbility;
  
  private JPanel panel4;
  private JTextArea curplayer;
  private JTextArea curplayer2;
  private JButton endTurn;
   
  public GamePanel(Marvel marvel) {
	  this.marvel=marvel;
	  this.setLayout(null);
	  
	  panel1= new JPanel();
	  panel1.setBounds(0,0,10,20);
	  panel1.setLayout(new GridLayout(5,5));
	  this.add(panel1);
	  buttons= new JButton[5][5];
	  
	  for(int i=0;i<buttons.length;i++) {
		  for(int j=0;j<buttons.length;j++) {
			  buttons[i][j]=new JButton();
			  
			  buttons[i][j].addActionListener(this);
			  panel1.add(buttons[i][j]);
		  }
	  }
	  panel2=new JPanel();
	  panel2.setLayout(null);
	  panel2.setBounds(0,0,10,20);
	  this.add(panel2);
	  
	  
	  left=new JButton("left");
	  left.setBounds(20,80,80,40);
	  left.addActionListener(this);
	  panel2.add(this);
	  
	  right=new JButton("right");
	  right.setBounds(20,80,80,40);
	  up.addActionListener(this);
	  panel2.add(this);
	  
	  up=new JButton("up");
	  up.setBounds(20,80,80,40);
	  up.addActionListener(this);
	  panel2.add(this);
	  
	  down=new JButton("down");
	  down.setBounds(20,80,80,40);
	  down.addActionListener(this);
	  panel2.add(this);
	  
	  left1=new JButton("left");
	  left1.setBounds(20,80,80,40);
	  left1.addActionListener(this);
	  panel2.add(this);
	  
	  right1=new JButton("right");
	  right1.setBounds(20,80,80,40);
	  right1.addActionListener(this);
	  panel2.add(this);
	  
	  up1=new JButton("up");
	  up1.setBounds(20,80,80,40);
	  up1.addActionListener(this);
	  panel2.add(this);
	  
	  down1=new JButton("down");
	  down1.setBounds(20,80,80,40);
	  down1.addActionListener(this);
	  panel2.add(this);
	  
	  panel3=new JPanel();
	  panel3.setLayout(null);
	  panel3.setBounds(620,220,350,160);
	  this.add(this);
	  
	  abilitiesCombo= new JComboBox<String>();
	  abilitiesCombo.setBounds(20,10,300,25);
	  panel3.add(this);
	  
	  castAbility=new JButton("Cast");
	  castAbility.setBounds(20,110,300,25);
	  castAbility.addActionListener(this);
	  panel3.add(castAbility);
	  
	  panel4=new JPanel();
	  panel4.setLayout(null);
	  panel4.setBounds(690,220,350,160);
	  this.add(this);
	   
	 
	  curplayer=new JTextArea();
	  curplayer.setEditable(false);
	  curplayer.setFont(new Font("serif",Font.BOLD,13));
	  JScrollPane sp=new JScrollPane(curplayer);
	  sp.setBounds(0,0,350,200);
	  panel4.add(sp);
	  
	  curplayer2=new JTextArea();
	  curplayer2.setEditable(false);
	  curplayer2.setFont(new Font("serif",Font.BOLD,13));
	  JScrollPane sp2=new JScrollPane(curplayer);
	  sp2.setBounds(0,0,350,200);
	  panel4.add(sp2);
	  
	  endTurn=new JButton("End Turn");
	  endTurn.setBounds(730,390,100,25);
	  endTurn.addActionListener(this);
	  this.add(endTurn);
	  
	  displayTheBoard();
	  displayCurrentInfo();
	  loadCurrAbilitiesInCombo();
	  
  }
	  
	  
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==up ) {
			d= Direction.UP;
			try {
				marvel.getGame().move(d);
				displayTheBoard();
				displayCurrentInfo();
			}
			catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==down) {
			d= Direction.DOWN;
		try {
			marvel.getGame().move(d);
			displayTheBoard();
			displayCurrentInfo();
		}
		catch (NotEnoughResourcesException | UnallowedMovementException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		}
		
		if(e.getSource()== left) {
			d= Direction.LEFT;
			try {
				marvel.getGame().move(d);
				displayTheBoard();
				displayCurrentInfo();
			}
			catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==right) {
			d= Direction.RIGHT;
			try {
				marvel.getGame().move(d);
				displayTheBoard();
				displayCurrentInfo();
			}
			catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==right1) {
			d= Direction.RIGHT;
			try {
				marvel.getGame().attack(d);
				displayTheBoard();
				displayCurrentInfo();
			}
			catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==left1) {
			d= Direction.LEFT;
			try {
				marvel.getGame().attack(d);
				displayTheBoard();
				displayCurrentInfo();
			}
			catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==up1) {
			d= Direction.UP;
			try {
				marvel.getGame().attack(d);
				displayTheBoard();
				displayCurrentInfo();
			}
			catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==down1) {
			d= Direction.DOWN;
			try {
				marvel.getGame().attack(d);
				displayTheBoard();
				displayCurrentInfo();
			}
			catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	 private void displayTheBoard() {
		
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
				if (marvel.getGame().getBoard()[i][j] instanceof Cover) {
					Cover c= (Cover)marvel.getGame().getBoard()[i][j];
					
					buttons[i][j].setForeground(Color.black);
					buttons[i][j].setText(c.getCurrentHP()+"");
					
				}else if (marvel.getGame().getBoard()[i][j] instanceof Champion) {
					Champion c= (Champion)marvel.getGame().getBoard()[i][j];
					if (c==marvel.getGame().getCurrentChampion()) {
						
						buttons[i][j].setForeground(Color.white);
					}else if (marvel.getGame().getFirstPlayer().getTeam().contains(c) ) {
						
						buttons[i][j].setForeground(Color.black);

					}else {
						
						buttons[i][j].setForeground(Color.yellow);

					}buttons[i][j].setText(c.getName()+"/"+c.getCurrentHP()+"");
					
				}else {
					buttons[i][j].setText("");
					buttons[i][j].setBackground(Color.white);
					
				}
			}}
		}
	 private void  loadCurrAbilitiesInCombo() {
		 abilitiesCombo.removeAllItems();
		 
		 ArrayList<String> result= marvel.getCurrentChampionAbnames();
		 for(int i=0;i<result.size();i++) {
			 abilitiesCombo.addItem(result.get(i));
		 }
	 }
  public void displayCurrentInfo() {
	  curplayer.setText(marvel.getCurrentPInfo());
	    }
}
