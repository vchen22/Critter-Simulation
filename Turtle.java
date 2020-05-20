/**
 * Author: Vicki Chen
 * CSE8B Login: cs8wahm
 * Date: 2/17/19
 * File: Turtle.java
 * Source of Help: PA4 write up, Piazza, CSE8b Tutors
 *
 * This file contains the subclass Turtle of Critter and has the
 * implentation of Movable
 * It creates an Turtle object with all its specified Turtle attributes
 * */

import java.util.Random;
import java.awt.*;

/**
 * This class contains methods that specifies an Turtle's color,
 * movement, eating and attacking habits, and its buff behavior. 
 * */
public class Turtle extends Critter implements Movable
{
    private static final String EMPTY_SPACE = " ";
    private static final String FOOD = ".";
    private static final int ATTACK_PROB = 2;
    private static final String TURTLE_OBJ = "Tu";
    private static final int ADD_SUB_COUNT = 5;

    /**
     * Intializes an Turtle object with display name
     * @param none
     * @return void
     * */
    public Turtle()
    {
        super(TURTLE_OBJ);
    }

    /** 
     * Set color to Turtle Object
     * @param none
     * @return Color green
     * */
    @Override
    public Color getColor()
    {
        return Color.GREEN;
    }

    /**
     * Move west
     * @param none
     * @return Direction west performed by Turtle
     * */
    @Override
    public Direction getMove()
    {
        return Direction.WEST;
    }

    /** 
     * Eat if no hostile animals in surrounding
     * @param none
     * @return boolean true or false if Turtle is going to eat
     * */
    @Override
    public boolean eat()
    {
        //check surrounding for hostile animals NSEW
        if (!(getNeighbor(Direction.NORTH).equals(EMPTY_SPACE)) && 
               !(getNeighbor(Direction.NORTH).equals(FOOD))
                    && !(getNeighbor(Direction.NORTH).equals(TURTLE_OBJ)))
        {
            return false;
        }
        else if (!(getNeighbor(Direction.SOUTH).equals(EMPTY_SPACE)) && 
                !(getNeighbor(Direction.SOUTH).equals(FOOD)) &&
                     !(getNeighbor(Direction.SOUTH).equals(TURTLE_OBJ)))
        {
            return false;
        }
        else if (!(getNeighbor(Direction.EAST).equals(EMPTY_SPACE)) && 
                !(getNeighbor(Direction.EAST).equals(FOOD))
                    && !(getNeighbor(Direction.EAST).equals(TURTLE_OBJ)))
        {
            return false;
        }
        else if (!(getNeighbor(Direction.WEST).equals(EMPTY_SPACE)) &&
                !(getNeighbor(Direction.WEST).equals(FOOD))
                    && !(getNeighbor(Direction.WEST).equals(TURTLE_OBJ)))
        {
            return false;
        }
        //eat if no hostile animals around
        else
        {
            return true;
        }
    }

    /**
     * Generate attack of Roar or Forfeit
     * @param opponent Foe fighting against
     * @return Attack Turtle will perform
     * */
    @Override
    public Attack getAttack(String opponent)
    {
        //generate attack on a 50% probabilty
        Random randNum = new Random();
        int chance = randNum.nextInt(ATTACK_PROB);
        if (chance == 0)
        {
            return Attack.ROAR;
        }
        else
        {
            return Attack.FORFEIT;
        }
    }

    /**
     * Increment count by 5 for every turtle alive
     * @param s State of object being buffed
     * @return void
     * */
    public void buffBehavior(CritterState s)
    {
        s.count += ADD_SUB_COUNT;
    }

    /**
     * Decrement count by 5 for every turtle alive
     * @param s state of object being debuffed
     * @return void
     * */
    @Override
    public void debuff(CritterState s)
    {
        s.count -= ADD_SUB_COUNT;
    }
    

}
