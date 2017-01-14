package ttt;

/**
 *
 * @author mbsaicharan
 */
public class tictactoe {
    public static void main(String[] args)
    {
        menu m = new menu();
        opg o = new opg();
        tpg t = new tpg();
        presentation p = new presentation(m,o,t);
        
    }
}
