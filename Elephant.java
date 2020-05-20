/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wahm
 * Date: 2/17/19
 * File: Elephant.java
 * Source of Help: PA4 write up, Piazza, CSE8b Tutors
 *
 * This file contains the subclass Elephant of Critter and has the
 * implentation of Movable
 * It creates an Elephant object with all its specified Elephant attributes
 * */

import java.awt.*;
import java.util.Random;

/**
 * This class contains methods that specifies an Elephant's color
 * movement, eating and mating habits, and its buff behavior. goalX and goalY 
 * are the coordinates all elephants are trying to go to and randNum is to
 * generate new goal coordinates
 * */
public class Elephant extends Critter implements Movable
{
    static int goalX = 0;
    static int goalY = 0;
    private Random randNum;
    private static final int ADD_LEVEL = 2;
    private static final String DP_NAME = "El";
    private static final int ADD_SUB_FOOD = 7;
    

    /**
     * Intializes an Elephant object with its display name and a random object
     * @param none
     * @return void
     * */
    public Elephant()
    {
        super(DP_NAME);
        randNum = new Random();

    }

    /** 
     * Set an Elephant object to a color
     * @param none
     * @return Color gray
     * */
    @Override
    public Color getColor()
    {
        return Color.GRAY;
    }

    /**
     * Move in direction based on the longer distance from the goal on the x 
     * or y axis
     * @param none
     * @return Direction Elephant is going
     * */
    @Override
    public Direction getMove()
    {
        //check if an elephant is at the goal
        //set new goal if true
        if (getX() == goalX && getY() == goalY)
        {

            int newX = randNum.nextInt(getWidth());
            int newY = randNum.nextInt(getHeight());
            goalX = newX;
            goalY = newY;
        }
        
        //if x has longer distance from goal
        if (Math.abs(getX() - goalX) > Math.abs(getY() - goalY))
        {
            if (getX() - goalX > 0)
            {
                return Direction.WEST;
            }
            else
            {
                return Direction.EAST;
            }
        }
        //if y has a longer distance from goal
        else if (Math.abs(getX() - goalX) < Math.abs(getY() - goalY))
        {
            if (getY() - goalY > 0)
            {
                return Direction.NORTH;
            }
            else
            {
                return Direction.SOUTH;
            }
        }
        //if x and y have same distance move on the x-axis
        else
        {
            if (getX() - goalX > 0)
            {
                return Direction.WEST;
            }
            else
            {
                return Direction.EAST;
            }
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

    /**
     * Increment level by 2 when it mating
     * @param none
     * @return void
     * */
    @Override
    public void mate()
    {
       //call helper method in Critter to increment
       incrementLevel(ADD_LEVEL);
    }

    /**
     * Add 7 food for every elephant alive
     * @param s CritterState being buffed
     * @return void
     * */
    public void buffBehavior(CritterState s)
    {
        s.foodEaten += ADD_SUB_FOOD;
    }

    /**
     * Subtract 7 food for every elephant alive
     * @param s CritterState being debuffed
     * @return none
     * */
    @Override
    public void debuff(CritterState s)
    {
        s.foodEaten -= ADD_SUB_FOOD;
    }

}

