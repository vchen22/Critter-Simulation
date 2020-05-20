/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wahm
 * Date: 2/18/19
 * File: Leopard.java
 * Source of Help: PA4 write up, Piazza, CSE8B Tutors
 *
 * This file contains the subclass Leopard of Feline.
 * It creates a Leopard object with all its specified Leopard attributes
 * 
 * */

import java.awt.*;
import java.util.Random;

/**
 * This class contains methods that specifies an Leopard color
 * movement, eating and attacking habits, winning and losing status, 
 * and its buff behavior. confidence determines when the leopard will eat.
 * */
public class Leopard extends Feline
{
    protected static int confidence = 0;
    private static final String FOOD = ".";
    private static final int NUM_DIR = 4;
    private static final int EAST_NUM = 2;
    private static final int EAT_RANGE = 10;
    private static final double PERCENT = 0.01;
    private static final int CONFID_MULT = 10;
    private static final double CONVERT_DOUBLE = 10.0;
    private static final String STARFISH_OBJ = "Patrick";
    private static final String TURTLE_OBJ = "Tu";
    private static final int CONFID_5 = 5;
    private static final int CONFID_MAX = 10;
    private static final int NUM_ATTACKS = 3;
    private static final String BUFF_NAME = "lalalala~~~~";
    private static final String DP_NAME = "Lpd";
   
    /**
     * Intializes a Leopard object with its display name
     * @param none
     * @return void
     * */
    public Leopard()
    {
        this.displayName = DP_NAME;
    }
    
    /** 
     * Set color of Leopard object
     * @param none
     * @return Color red
     * */
    @Override
    public Color getColor()
    {
        return Color.RED;
    }

    /** 
     * Determines what direction based on the surrounding of Leopard
     * @param none
     * @return Direction Leopard is going
     * */
    @Override
    public Direction getMove()
    {
        //checking surrounding for food and starfish
        //check in NSEW directions
       if (getNeighbor(Direction.NORTH).equals(FOOD) || 
           getNeighbor(Direction.NORTH).equals(STARFISH_OBJ))
       {
           return Direction.NORTH;
       }
       else if (getNeighbor(Direction.SOUTH).equals(FOOD) || 
           getNeighbor(Direction.SOUTH).equals(STARFISH_OBJ))
       {
           return Direction.SOUTH;
       }
       else if (getNeighbor(Direction.EAST).equals(FOOD) || 
           getNeighbor(Direction.EAST).equals(STARFISH_OBJ))
       {
           return Direction.EAST;
       }
       else if (getNeighbor(Direction.WEST).equals(FOOD) || 
           getNeighbor(Direction.WEST).equals(STARFISH_OBJ))
       {
           return Direction.WEST;
       }
       else
       {
           //generating random direction when no food or starfish
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
     * Calculate when to eat based on confidence
     * @param none
     * @return boolean true or false if Leopard is going to eat
     * */
    @Override
    public boolean eat()
    {
        if (confidence == 0)
        {
            return false;
        }
        else
        {
            //calculate the probability of eating using confidence
            double chance = (confidence*CONFID_MULT)*PERCENT;
            Random randNum = new Random();
            int eatNum = randNum.nextInt(EAT_RANGE)+1;

            //compare generated num with prob
            if (eatNum/CONVERT_DOUBLE <= chance)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /**
     * Increment confidence if win in a fight
     * @param none
     * @return void
     **/
    @Override
    public void win()
    {
        if (confidence < CONFID_MAX)
        {
            confidence++;
        }
    }

    /**
     * Decrement confidence if lose in a fight
     * @param none
     * @return void
     * */
    @Override
    public void lose()
    {
        if (confidence > 0)
        {
           confidence--;
        }
    }

    /**
     * Determine attack based on surrounding and confidence or use random
     * attack
     * @param opponent Foe that needs to be attack
     * @return Attack Leopard is going to perform
     * */
    @Override
    public Attack getAttack(String opponent)
    {
        if (opponent.equals(TURTLE_OBJ) || confidence > CONFID_5)
        {
            return Attack.ROAR;
        }
        else
        {
            //calling helper method to generate random attack if not
            return generateAttack();
        }
    }

    /**
     * Randomizes a random attack
     * @param none
     * @return Attack randomly generated
     * */
    public Attack generateAttack()
    {
        //randomize a number and return the attack assigned to that number
        Random randNum = new Random();
        int randAttack = randNum.nextInt(NUM_ATTACKS);

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
     * Change display name back to original name to debuff
     * @param s CritterState being debuffed
     * @return void
     * */
    @Override
    public void debuff(CritterState s)
    {
        this.displayName = DP_NAME;
    }
    
}
