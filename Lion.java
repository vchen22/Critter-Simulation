/**
 * Author: Vicki Chen
 * CSE8B Login: cs8bwahm
 * Date: 2/18/19
 * File: Lion.java
 * Source of Help: PA4 write up, Piazza, CSE8B Tutors
 *
 * This file contains the subclass Lion of Feline.
 * It creates a Lion object with all its specified Lion attributes
 * */

import java.awt.*;

/**
 * This class contains methods that specifies an Lion's color,
 * movement, eating, sleeping, and waking up habits, and its buff behavior.
 * fightWins count the number of fights won, movementCount keep track of how
 * many moves it has taken, and isHungry is its hunger state
 **/
public class Lion extends Feline
{
    private int fightWins;
    private int movementCount;
    private boolean isHungry;
    private static final String DP_NAME = "Lion";
    private static final int MOVE_RECYCLE = 20;
    private static final int SOUTH_MOVE = 5;
    private static final int WEST_MOVE = 10;
    private static final int NORTH_MOVE = 15;
    private static final String SLEEP_NAME = "noiL";
    private static final String BUFF_NAME = "LION";

    /**
     * Intializes Lion object with display name, counter for number of wins,
     * counter for number of moves taken, and hunger state
     * @param none
     * @return void
     * */
    public Lion()
    {
        this.displayName = DP_NAME;
        this.fightWins = 0;
        this.movementCount = 0;
        this.isHungry = false;
    }
    
    /** 
     * Set color of Lion object
     * @param none
     * @return Color yellow
     * */
    @Override
    public Color getColor()
    {
        return Color.YELLOW;
    }

    /** 
     * Change direction of Lion for every 5 moves
     * @param none
     * @return Direction lion is going
     * */
    @Override
    public Direction getMove()
    {
        if (movementCount == MOVE_RECYCLE)
        {
            movementCount = 0;
        }
        //move 0-4
        if (movementCount < SOUTH_MOVE)
        {
            movementCount++;
            return Direction.SOUTH;
        }
        //move 5-9
        else if (movementCount < WEST_MOVE)
        {
            movementCount++;
            return Direction.WEST;
        }
        //move 10-14
        else if (movementCount < NORTH_MOVE)
        {
            movementCount++;
            return Direction.NORTH;
        }
        //move 15-19
        else 
        {
            movementCount++;
            return Direction.EAST;
        }
                     
    }
    
    /** 
     * Eat when it is hungry after a fight
     * @param none
     * @return boolean true or false if Lion is going to eat
     * */
    @Override
    public boolean eat()
    {
        //reset to full after eating
        if (isHungry == true)
        {
            isHungry = false;
            return true;
        }

        return false;
    }

    /**
     * Reset fightWins, change displayName, and is not hungry when sleeping
     * @param none
     * @return void
     * */
    @Override
    public void sleep()
    {
        fightWins = 0;
        this.displayName = SLEEP_NAME;
        isHungry = false;

    }

    /**
     * Change back to original display name waking up
     * @param none
     * @return void
     * */
    @Override
    public void wakeup()
    {
        this.displayName = DP_NAME;
    }

    /**
     * Increment fightWins when if win in a fight and isHungry after
     * @param none
     * @return void
     * */
    @Override
    public void win()
    {
        fightWins++;
        isHungry = true;
    }

    /**
     * Change display name as buff behavior
     * @param s CritterState being buffed
     * @return void
     * */
    @Override
    public void buffBehavior(CritterState s)
    {
        this.displayName = BUFF_NAME;
    }

    /**
     * Revert display name back to original name
     * @param s CritterState being debuffed
     * @return void
     * */
    @Override
    public void debuff(CritterState s)
    {
        this.displayName = DP_NAME;
    }
    

}
