/**
  * Author: Vicki Chen
  * CSE8B Login: cs8wahm
  * Date: 2/19/19
  * File: README.md
  * Source of Help: PA4 write up
  *
  * This contains the answer to the PA4 short response questions
  **/

Short-Response Questions
1. The public modifier allows other classes/world to access its classes,
    variables, methods, and constructor. Private only allows access to its own
    class only. Protected allows access only to the package and all subclasses.
    While the default modifer allow access to the package.

2. Inheritance minimizes the duplication of the same code by creating a 
   hierarchy where other classes can access the code and use it.

3. We used the Movable interface because not all class/objects are the same
   but interfaces allows it inherit the same code and implement it they want
   to. Therefore, it allows multiple inheritance.

4. No because Starfish does not implement the Movable interface

5. Starfish inherits Critter's toString method so it uses that method to
   correctly return the display name

6. If we did not override Leopard's getAttack() method, it would inherit
    Feline's method. The behavior would be to always pounce.

7. Turtle has to override getAttack because it has a 50% chance of attacking,
    so it cannot always forfeit like the getAttack method in Critter.

8. The getMove() method is inherited from the Movable interface. Starfish
   does not inherite Movable because it is a motionless creature when
   Spongbob is not around.

9. Static variables are useful because it can be shared among all objects and
   when there is a change in the variable, all objects variable will be
   changed as well. We needed static variables in this PA because all
   Elephants have the same goal and all Leopard's confidence depends on
   each other.

10. My critter will go to the direction that has food in the NSEW order. If
    there is no food, it will randomize a direction. My critter will always
    randomize an attack, but never forfeit. My critter will also always eat.
    The color of my critter is magenta.

