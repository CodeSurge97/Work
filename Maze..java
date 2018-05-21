/**
 * Title: Savings Calculator
 * Semester: COP3337 – Summer 2017
 *
 * @author Serge Metellus
 *
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
 *
 * This program creates a maze, checks whether you can escape from the maze, and 
 * recursively checks whether you can escape from one of the empty neighboring 
 * locations without visiting the current location.
 */


public class Maze 
{

    //Declare Character
    private char[][] MazeMatrx;

    /**
     * Declare a Maze Constructor
     * @param Inp
     */
    public Maze(char[][] Inp) 
    {

        //makes an Allocation
        MazeMatrx = new char[Inp.length][Inp[0].length];

         // makes Outer for Loop
        for (int kk = 0; kk < Inp.length; kk++) 
        {

            //makes for Inner for Loop
            for (int aa = 0; aa < Inp[0].length; aa++) //assign a Copy Values
            {
                MazeMatrx[kk][aa] = Inp[kk][aa];
            }

        }

        //Make Set for Exiting Point
        MazeMatrx[0][1] = 'X';

    }

    /**
     * Define Method Escape() method
     * @param X
     * @param Y
     * @return 
     */
    public boolean Escape(int X, int Y) 
    {

        //Calls function
        if (MoveNextCell(X, Y)) {

            return true;

        }

        return false;

    }

    /**
     * Defining a Method
     * @param X
     * @param Y
     * @return 
     */ 
    public boolean MoveNextCell(int X, int Y) 
    {

        //Checking a Condition
        if (MazeMatrx[X][Y] == 'X') 
        {

            return true;

        }

        if (MazeMatrx[X][Y] == '*' || MazeMatrx[X][Y] == '$') 
        {

            return false;

        }

        MazeMatrx[X][Y] = '$';

        boolean TmpRt;

        TmpRt = MoveNextCell(X, Y + 1);

        if (TmpRt) 
        {

            return true;

        }

        TmpRt = MoveNextCell(X - 1, Y);

        if (TmpRt) 
        {

            return true;

        }

        TmpRt = MoveNextCell(X, Y - 1);

        if (TmpRt) 
        {

            return true;

        }

        TmpRt = MoveNextCell(X + 1, Y);

        if (TmpRt) 
        {

            return true;

        }

        MazeMatrx[X][Y] = ' ';

        return false;

    }

}
