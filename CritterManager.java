/**
 * class that supers CritterModel. So students only need to implement an extra
 * update method here instead of dealing with the thousand-line code
 * Cheng Shen
 */
import java.util.*;
import java.awt.Point;

public class CritterManager extends Observable{
	// Instance variables useful for fancy operations
	protected final List<Critter> critterList;//list holding your critters
	private final int buffTurn = 25; //25 moves until buff
	private final int teleportTurn = 15; // 15 moves until teleport 
	protected int moveCount;
	protected final Map<Critter, Point> locationMap;
	protected final Critter[][] grid;


	protected final SortedMap<String, CritterState> classStateMap;
	protected final Map<Critter, CritterState> critterStateMap;

	protected final boolean NEED_BUFF = true;

	public CritterManager(int width, int height){
		critterList = new ArrayList<Critter>();
		moveCount = 0;
		locationMap = new HashMap<Critter, Point>();
		grid = new Critter[width][height];


		// initialize various data structures
		classStateMap = new TreeMap<String, CritterState>();
		// important to use IdentityHashMap so they can't trick me by 
        // overriding hashCode
		critterStateMap = new IdentityHashMap<Critter, CritterState>();
	}

	//Student TODO
    /**
     * Apply buff, debuff, or teleport for every 25th move, 26th move, and 15th
     * move
     * @param none
     * @return extraBuff - true or false if buff was added
     * */
	public synchronized boolean addBuff(){
		moveCount ++;//Increment moveCount 

		if (NEED_BUFF == false) return false;

		boolean extraEffect = false;

		//TODO: fill in your solution code here
		/* HINTS:Look at critterList. It has the critters you to buff/debuff
		 * for. You also have instance variables for the amount of moves 
		 * you need to wait before buffing/debuffing/teleporting. You'll need
		 * use getState as a helper method. It returns the CritterState of 
		 * the given critter. 
		 * 
		*/
        
        
        //buff - every 25th move
        if (moveCount != 1 && moveCount%buffTurn == 1)
        {
            //add buff to every critter
            for (int index = 0; index < critterList.size(); index++)
            {
                Critter animal = critterList.get(index);
                animal.debuff(getState(animal));
                extraEffect = false;
            }
        }

        //debuff - every 26th move
        if (moveCount != 0 && moveCount%buffTurn == 0)
        {
            //add debuff to every critter
            for (int index = 0; index < critterList.size(); index++)
            {
                Critter animal = critterList.get(index);
                animal.buffBehavior(getState(animal));
               
                extraEffect = true;
            }
        }

        //teleport - every 15th move
        if (moveCount != 0 && moveCount%teleportTurn == 0)
        {
            for (int index = 0; index < critterList.size(); index++)
            {
                //check if critter is a starfish
                if (critterList.get(index) instanceof Starfish)
                {
                    Critter animal = critterList.get(index); 
                    ((Starfish) animal).teleport(getLocation(animal), grid);
                }
            }

        }
                       
		return extraEffect;
	}   

	// Helper method to get the state students need to pass in 
    // buffBehavior/debuff
	// Provided to students

    /**
     * Check what instance and the gameState of what the critter is
     * @param c Critter getting state of
     * @return gameState of critter
     * */
	public CritterState getState (Critter c){
		// Return state from classState if it changes some data of the 
        // whole species
		if (c instanceof Turtle) return classStateMap.get("Turtle");
		if (c instanceof Ocelot) return classStateMap.get("Ocelot");
		if (c instanceof Elephant) return classStateMap.get("Elephant");
		if (c instanceof Starfish) return classStateMap.get("Starfish");

		// Return state from critterStateMap if the change only applies
        // to one individual.
		if (c instanceof Feline) return critterStateMap.get(c);
		return null;
	}

	// Provided to student
    /**
     * Get point location of the critter
     * @param c Critter that is getting the location of
     * @return Point critter is at
     * */
	public Point getLocation (Critter c){
		return locationMap.get(c);
	}
}
