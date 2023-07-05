package views;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;
import engine.Player;
import model.abilities.Ability;
import model.world.Champion;

public class Marvel extends JFrame {
	private Game game;
	private Welcome welcome;
	private Player one;
	private Player two;
	private NamePanel n;
    private ChampionPanel1 Cp1;
    private ChampionPanel2 Cp2;
    private GamePanel gamePanel ;
    
    
	public Marvel() {
		
		  
		welcome = new Welcome(this);
		this.setContentPane(welcome);
		this.setTitle("Marvel Ultimate War");
		this.setSize(1600, 1000);
		this.setLocation(500, 50); // not for others
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void switchToNamePanel() {

		n = new NamePanel(this);
		this.setContentPane(n);
		this.validate();
		this.repaint();
	}
	public void switchToChampionPanel1(String name1, String name2) {
		one = new Player(name1);
		two = new Player(name2);
		game = new Game(one,two);
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
			this.setSize(1600,1000);
			this.remove(n);
			Cp1=new ChampionPanel1(this);
			this.setContentPane(Cp1);
			this.validate();
			this.repaint();
		}
		catch(IOException a) {
		a.printStackTrace();
		}
	}
	
	
			
		
	public void switchToChampionPanel2(int s1, int s2,int s3) {
		
		
		
			this.setSize(1600,1000);
			this.remove(Cp1);
			Cp2=new ChampionPanel2(this,s1,s2,s3);
			this.setContentPane(Cp2);
			this.validate();
			this.repaint();
		
	}
		
	

	public  String[] getChampions() {
		ArrayList<Champion>Champions=Game.getAvailableChampions();
		String []l=new String[Champions.size()];
		for(int i=0;i<Champions.size();i++) {
			l[i]=Champions.get(i).getName();
		}
		return l;
	
	}
	
	
	public String info(int index) {
		ArrayList<Champion>Champions=Game.getAvailableChampions();
			Champion c=	Champions.get(index);
			String result= "Name: "+c.getName()+"\n"+"Attack: "+c.getAttackDamage()+"\n"+"Attack Range:"+c.getAttackRange()+"\n"+
			"Health: "+c.getCurrentHP()+"\n"+"Mana: "+c.getMana()+"\n"+"Abilities: "+"\n";
			int i=0;
			while(i<c.getAbilities().size()) {
				result=result+(i+1)+"-"+c.getAbilities().get(i).getName()+"\n";
				i++;
			}
				return result;
	}
	

	public static void main(String[] args) {
		Marvel m = new Marvel();
	}

	public void switchToGamePanel(int box1, int box2, int box3, int box4, int box5,int box6) {
		one.setLeader(Game.getAvailableChampions().get(box1));
		one.getTeam().add(Game.getAvailableChampions().get(box2));
		one.getTeam().add(Game.getAvailableChampions().get(box3));
		two.setLeader(Game.getAvailableChampions().get(box4));
		two.getTeam().add(Game.getAvailableChampions().get(box5));
		two.getTeam().add(Game.getAvailableChampions().get(box6));
		
		this.remove(Cp2);
		gamePanel=new GamePanel(this);
		this.setContentPane(gamePanel);
		this.validate();
		this.repaint();
		
		
	}

	
	public Game getGame() {
		return game;
	}
	public ArrayList<String> getCurrentChampionAbnames(){
		ArrayList<String> result=new ArrayList<String>();
		for(int i=0;i<game.getCurrentChampion().getAbilities().size();i++) {
			result.add(game.getCurrentChampion().getAbilities().get(i).getName());
			
		}
		return result;
	}

	
	public String getCurrentPInfo() {
		String s= "Current Player:";
		if(game.getFirstPlayer().getTeam().contains(game.getCurrentChampion()))
			s=s+game.getFirstPlayer().getName()+"\n\n";
		else
			s=s+game.getSecondPlayer().getName()+"\n\n";
		
		Champion c= game.getCurrentChampion();
		s=s+"Current Champion Info: "+"\n"+ "Name" +c.getName()+"\n" +"Attack: "+ c.getAttackDamage()+"\n"+ "Range: "+
		 c.getAttackRange() +"\n" +"Health" + c.getCurrentHP()+ "\n"+ "Mana: "+ c.getMana()+"\n"+ "Current Action Points:" + "\n\n"+
	"Abilities :" +"\n";
		for(int i=0; i<c.getAbilities().size();i++) {
			Ability a=c.getAbilities().get(i);
			s=s+(i+1) +")" +a.getName()+ ":\n";
			s=s+"-Mana cost: " +a.getManaCost()+"\n";
			s=s+"-Cool Down : " +a.getCurrentCooldown()+"\n";
			s=s+"-Action Points : " +a.getRequiredActionPoints()+"\n";
			s=s+"-Area of effect : " +a.getCastArea()+"\n";
		}
		return s;
	}


	
}