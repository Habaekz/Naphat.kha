//Naphat Khajohn-Udomrith
//ID 6188029 
//SEC 1

public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	private PlayerType type; // Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage,
								// or Phoenix
	private double maxHP; // Max HP of this player
	private double currentHP; // Current HP of this player
	private double atk; // Attack power of this player

	private int numofcount = 0;
	private int specialturn;
	private Player Cursed = null;
	private String TeamName;
	private String Row;
	private int position;
	private boolean NowTaunting;
	private boolean NowCursed;
	private boolean NowSleeeping;
	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)
	{	
		//INSERT YOUR CODE HERE
		this.type = _type;
		switch(this.type) 
		{
			case Healer:
				this.maxHP = 4790;
				this.atk = 238;
				this.currentHP = 4790;
				specialturn = 4;
				break;
			case Tank:
				this.maxHP = 5340;
				this.atk = 255;
				this.currentHP = 5340;
				specialturn = 4;
				break;
			case Samurai:
				this.maxHP = 4005;
				this.atk = 368;
				this.currentHP = 4005;
				specialturn = 3;
				break;
			case BlackMage:
				this.maxHP = 4175;
				this.atk = 303;
				this.currentHP = 4175;
				specialturn = 4;
				break;
			case Phoenix:
				this.maxHP = 4175;
				this.atk = 209;
				this.currentHP = 4175;
				specialturn = 8;
				break;
			case Cherry:
				this.maxHP = 3560;
				this.atk = 198;
				this.currentHP = 3560;
				specialturn = 4;
				break;
			
		}
	}
	/**
	 * Returns the current HP of this player
	 * 
	 * @return
	 */
	public double getCurrentHP() {
		// INSERT YOUR CODE HERE
		return currentHP;
	}
	/**
	 * Returns type of this player
	 * 
	 * @return
	 */
	public Player.PlayerType getType() {
		// INSERT YOUR CODE HERE
		return type;
	}
	/**
	 * Returns max HP of this player.
	 * 
	 * @return
	 */
	public double getMaxHP() {
		// INSERT YOUR CODE HERE
		return maxHP;
	}
	/**
	 * Returns whether this player is sleeping.
	 * 
	 * @return
	 */
	public boolean isSleeping() {
		// INSERT YOUR CODE HERE
		return NowSleeeping ;
	}
	/**
	 * Returns whether this player is being cursed.
	 * 
	 * @return
	 */
	public boolean isCursed() {
		// INSERT YOUR CODE HERE
		return NowCursed;
	}
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * 
	 * @return
	 */
	public boolean isAlive() {
		// INSERT YOUR CODE HERE
		if(this.currentHP >0) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	/**
	 * Returns whether this player is taunting the other team.
	 * 
	 * @return
	 */
	public boolean isTaunting() {
		// INSERT YOUR CODE HERE
		return NowTaunting;
	}
	public void attack(Player target) {
		// INSERT YOUR CODE HERE
		target.currentHP = target.currentHP - atk; 
		if(target.currentHP < 0) 
		{
			target.currentHP = 0;
		}
	}
	public void useSpecialAbility(Player[][] myTeam, Player[][] TargetTeam) {
		// INSERT YOUR CODE HERE
		numofcount =0;
		
		if(this.type == PlayerType.Healer) {
			Player lowest = findHeal(myTeam);
			if(lowest.NowCursed) {
				return;
			}
			if(lowest.currentHP<lowest.maxHP && lowest.currentHP > 0 && lowest.NowCursed == false) {
				System.out.println("# "+playerInfo()+" Heals "+lowest.playerInfo());
				lowest.currentHP += (lowest.maxHP * 0.25);
				if(lowest.currentHP > lowest.maxHP) {
					lowest.currentHP = lowest.maxHP;
				}
			}
		}
		
		else if(this.type == PlayerType.Tank) {
			System.out.println("# "+playerInfo()+" is Taunting");
			setTaunting(true);
		}
		
		else if(this.type == PlayerType.BlackMage) {
			Player cursing = findCurses(TargetTeam);
			if(IsTaunting(TargetTeam) != null) {
				cursing = IsTaunting(TargetTeam);
			}
			if (cursing != null) {
				System.out.println("# "+playerInfo()+" Curses "+cursing.playerInfo());
				cursing.setCursed(true);
				this.Cursed = cursing;
			}
		}
		
		else if(this.type == PlayerType.Cherry) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < TargetTeam[0].length; j++) {
					if(TargetTeam[i][j].isAlive()) {
						System.out.println("# "+playerInfo()+" Feeds a Fortune Cookie to "+TargetTeam[i][j].playerInfo());
						TargetTeam[i][j].setSleeeping(true);
					}
				}
			}
		}
		
		else if (this.type == PlayerType.Phoenix) {
			Player Undead = myTeam[0][0];
			boolean find_GOD = false;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < myTeam[0].length; j++) {
					if(!myTeam[i][j].isAlive() && find_GOD == false) {
						Undead = myTeam[i][j];
						find_GOD = true;
					}
				}
			}
			
			System.out.println("# "+playerInfo()+" Revives "+Undead.playerInfo());
			Undead.currentHP = Undead.currentHP + (Undead.maxHP*0.3);
			Undead.numofcount = 0;
			
			
			Undead.setSleeeping(false);
			Undead.setCursed(false);
			Undead.setTaunting(false);
		}
}
	/**
	 * This method is called by Arena when it is this player's turn to take an
	 * action. By default, the player simply just "attack(target)". However, once
	 * this player has fought for "numSpecialTurns" rounds, this player must perform
	 * "useSpecialAbility(myTeam, theirTeam)" where each player type performs his
	 * own special move.
	 * 
	 * @param arena
	 */
	public void takeAction(Arena arena) {
		// INSERT YOUR CODE HERE
		if(this.type == PlayerType.BlackMage && Cursed != null) {
			Cursed.setCursed(false);
			Cursed = null;
		}
		if(this.NowTaunting) {
			this.setTaunting(false);
		}
		if(this.NowSleeeping) {
			this.setSleeping(false);
			return;
		}
		
		numofcount++;
		
		Player[][] myteam = null;
		Player[][] TargetTeam = null;
		if(arena.FoundMyTeam(this) == arena.MemberTeamA()) {
			 myteam = arena.MemberTeamA();
			 TargetTeam = arena.MemberTeamB();	
		}
		else if(arena.FoundMyTeam(this) == arena.MemberTeamB()) {
			 myteam = arena.MemberTeamB();
			 TargetTeam = arena.MemberTeamA();
		}
		if(numofcount == this.specialturn) {
		switch(this.type) 
		{
		case Healer:
			useSpecialAbility(myteam, TargetTeam);
			break;
		case Tank:
			useSpecialAbility(myteam, TargetTeam);
			break;
		case Samurai:
			numofcount = 0;
			Player target = arena.findTarget(this);
			if(target == null) {
				return;
			}
				System.out.println("# "+playerInfo()+" Double-Slashes "+target.playerInfo());
				attack(target);
				attack(target);
				break;
		case BlackMage:
			useSpecialAbility(myteam, TargetTeam);
			break;
		case Phoenix:
			useSpecialAbility(myteam, TargetTeam);
			break;
		case Cherry:
			useSpecialAbility(myteam, TargetTeam);
			break;
		}
		}
		else {
			Player target = arena.findTarget(this);
			if(target != null) 
			{
				attack(target);
				
				System.out.println("# "+playerInfo()+" Attacks "+target.playerInfo()/*+target.currentHP*/);
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < TargetTeam[i].length; j++) {
				if(TargetTeam[i][j].isAlive() ==false) 
				{
					TargetTeam[i][j].NowCursed = false;
					TargetTeam[i][j].NowTaunting = false;
					TargetTeam[i][j].NowSleeeping = false;
				}
			}
		}
}
	/**
	 * This method overrides the default Object's toString() and is already
	 * implemented for you.
	 */
	@Override
	public String toString() {
		return "[" + this.type.toString() + " HP:" + this.currentHP + "/" + this.maxHP + " ATK:" + this.atk + "]["
				+ ((this.isCursed()) ? "C" : "") + ((this.isTaunting()) ? "T" : "") + ((this.isSleeping()) ? "S" : "")
				+ "]";
	}
	//=======================//ADD//===============================//
	public String playerInfo() {
		return this.TeamName+"["+this.Row+"]["+this.position+"] {"+this.type.toString()+"}";
	}
	public Player findHeal(Player[][] myteam) {
		double lowest = 1000000;
		Player target = null;
		for(int i =0;i<2;i++) {
			if(i==0) {
				for(int j =0;j<myteam[i].length;j++) {
					if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100 < lowest) {
						lowest = myteam[i][j].getCurrentHP()/(myteam[i][j].getMaxHP())*100;
						target = myteam[i][j];
					}
				}
			}
			else {
				for (int j = 0; j < myteam[i].length; j++) {
					if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() /(myteam[i][j].getMaxHP())*100 < lowest) {
						lowest = myteam[i][j].getCurrentHP()/(myteam[i][j].getMaxHP())*100;
						target = myteam[i][j];
						
					}
				}
			}
		}
		return target;
	}
	public Player findCurses(Player[][] theirTeam) {
		double mininum = 1000000;
		Player target = null;
		boolean findcurse = false;
		for (int i = 0; i < 2; i++) {
				for (int j = 0; j < theirTeam[i].length; j++) {
					if(theirTeam[i][j].isAlive() && theirTeam[i][j].currentHP < mininum) {
						mininum = theirTeam[i][j].currentHP;
						target = theirTeam[i][j];
						findcurse = true;
					}
				}
		}
		return target;
	}
	public Player IsTaunting(Player[][] team) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < team[i].length; j++) {
				if(team[i][j].NowTaunting) {
					return team[i][j];
				}
			}
		}
		return null;
	}
	public String getTeamName() {
		return TeamName;
	}
	public String getRow() {
		return Row;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int Position,String TeamName,String Row) {
		position = Position;
		this.TeamName = TeamName;
		this.Row = Row;
	}
	public void setSleeeping(boolean isSleeeping) {
		NowSleeeping = isSleeeping;
	}
	public void setTaunting(boolean isTaunting) {
		NowTaunting = isTaunting;
	}
	public void setCursed(boolean isCursed) {
		NowCursed = isCursed;
    }
	public String getTeam() {
		return this.TeamName;
	}
	public void setSleeping(boolean isSleeping) {
		this.NowSleeeping = isSleeping;
	}
}
