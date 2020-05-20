/**
 * Author: Vicki Chen
 * CS8B Login: cs8bwahm
 * Date: 2/19/19
 * File: Starfish.java
 * Source of Help: PA4 write up, Piazza, CSE8B Tutors
 *
 * This file contains the subclass Starfish of Critter.
 * It creates an Ocelot object with all its specified Starfish attributes
 * */

import java.awt.*;
import java.util.*;

/**
 * This class contains methods that specifies a Starfish's color,
 * teleportation ability, and its buff behavior. 
 * */
public class Starfish extends Critter{
    
    private static final String DP_NAME = "Patrick";
    private static final String EMPTY_NAME = "";

    /**
     * Intializes a Starfish object with its display name
     * @param none
     * @return void
     * */
    public Starfish() {
        super(DP_NAME);
    }

    /** 
     * Set Starfish object to a color
     * @param none
     * @return Color pink
     * */
    @Override 
    public Color getColor() {
        return Color.PINK;
    }

    /**
     * Decrement count by 1 for every starfish alive and change display name
     * to an empty string
     * @param s CitterState being buffed
     * @return void
     * */
    @Override
    public void buffBehavior(CritterState s){
    	// A very humble animal, making the manager thinks there's no
    	// starfish at all!!!
    	s.count -= 1;
    	this.displayName = EMPTY_NAME;
    }

    /**
     * Increment count by 1 for every starfish alive and revert display name
     * back to original name
     * @param s CritterState being debuffed
     * @return void
     * */
    @Override
    public void debuff(CritterState s){
    	s.count += 1;
    	this.displayName = DP_NAME;
    }

    //Student TODO
    //Starfish is able to teleport to another place
    //To do that, reset the position in currentLocation and 
    //remove previous location
    //from the arena

    /**
     * Teleport Starfish by randomizing a different set of coordinates
     * @param currentLocation Points Starfish is at
     * @param arena Map Starfish is in
     * */
    public void teleport(Point currentLocation, Critter[][] arena){
        //Write your code here

        //randomize numa based on arena dimensions
        Random rand = new Random();
        int randX = rand.nextInt(getWidth());
        int randY = rand.nextInt(getHeight());

        //temp for original position
        int currentX = currentLocation.x;
        int currentY = currentLocation.y;

        //set new location to randomized num
        currentLocation.x = randX;
        currentLocation.y = randY;

        arena[currentX][currentY] = null;
                
    }
}
