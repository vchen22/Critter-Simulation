/**
 * Author: Vicki Chen
 * CSE8B Login: cs8bwahm
 * Date: 2/19/19
 * File: Vicki_vchen.java
 * Source of Help: PA4 write up, Piazza, CSE8B Tutors
 *
 * This file contains the subclass Vicki_vchen of Critter with the
 * implementation of Movable
 * It creates an Vicki_vchen object with all its specified Vicki_vchen
 * attributes
 * */

import java.util.Random;
import java.awt.*;

/**
 * This class contains methods that specifies a Vicki_vchen's color,
 * moving and attacking ability, and its eating habits.
 * */
public class Vicki_vchen extends Critter implements Movable
{
    private static final String FOOD = ".";
    private static final int NUM_DIR = 4;
    private static final int EAST_NUM = 2;
    private static final int NUM_ATTACK = 3;
    private static final String DP_NAME = "vchen";


    /**
     * Intializes a Vicki_vchen object with its display name
     * @param none
     * @return void
     * */
    public Vicki_vchen()
    {
        super(DP_NAME);
    }

    /** 
     * Set a Vicki_vchen object to a color
     * @param none
     * @return Color magenta
     * */
    @Override
    public Color getColor()
    {
        return Color.MAGENTA;
    }

    /** 
     * Go to direction where there is food or randomize a direction
     * @param none
     * @return Direction vchen will go
     * */
    @Override
    public Direction getMove()
    {
        //check surrounding for food in NSEW direction
        if (getNeighbor(Direction.NORTH).equals(FOOD))
        {
            return Direction.NORTH;
        }
        else if (getNeighbor(Direction.SOUTH).equals(FOOD))
        {
            return Direction.SOUTH;
        }
        else if (getNeighbor(Direction.EAST).equals(FOOD))
        {
            return Direction.EAST;
        }
        else if (getNeighbor(Direction.WEST).equals(FOOD))
        {
            return Direction.WEST;
        }
        else
        {
            //if no food, randomize a direction
            Random randDir = new Random();
            int dir = randDir.nextInt(NUM_DIR);
            
            if (dir == 0)
            {
                return Direction.NORTH;
               
            }
            else if (dir == 1)
            {
                return Direction.SOUTH;
             
            }
            else if (dir == EAST_NUM)
            {
                return Direction.EAST;
            }
            else
            {
                return Direction.WEST;
                
            }
            
            
        }
    }

    /** 
     * Randomize an attack to fight opponent
     * @param Opponent Foe fighting against
     * @return Randomized attack
     * */
    @Override
    public Attack getAttack(String opponent)
    {
        Random randNum = new Random();
        int randAttack = randNum.nextInt(NUM_ATTACK);

        if (randAttack == 0)
        {
            return Attack.ROAR;
        }
        else if (randAttack == 1)
        {
            return Attack.POUNCE;
             
        }
        else
        {
            return Attack.SCRATCH;
                
        }        
    }

    /** 
     * Always eat food
     * @param none
     * @return boolean true 
     * */
    @Override
    public boolean eat()
    {
        return true;
    }
    
}

