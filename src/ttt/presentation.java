/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mbsaicharan
 */
public class presentation {
    
    private char[] board;
    menu m;
    opg o;
    tpg t;
    model mo;
    public presentation(menu m,opg o,tpg t,model mo)
    {
        this.m = m;
        this.o = o;
        this.t = t;
        this.mo = mo;
        board = new char[9];
        m.b1Listener(new opgButton());
        m.b2Listener(new tpgButton());
        m.setVisible(true);
        o.resetListener(new resetO());
        o.menuListener(new menuOAL());
       // t.resetListener(new resetT());
        t.menuListener(new menuTAL());
        o.buttonsListener(new buttonAction());
    }
    
    class opgButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            m.dispose();
            o.setVisible(true);
        }
    }
    
    class tpgButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            m.dispose();
            t.setVisible(true);
        }
    }
    
    class resetO implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            o.initialize();
        }
    }
    
    class menuOAL implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            m.setVisible(true);
            o.dispose();
            o.initialize();
        }
    }
    
    class menuTAL implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            m.setVisible(true);
            t.dispose();
        }
    }
    
    class buttonAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int i,m,n;
            for(i = 0 ;i<9;i++)
                if(e.getSource().equals(o.getButton(i)))
                    break;
            o.setX(i);
            board = o.getBoard();
            n = mo.finalResult(board);
            switch (n) {
                case 1:
                    JOptionPane.showMessageDialog(o, "Draw1");
                    
                    break;
                case 3:
                    JOptionPane.showMessageDialog(o, "You win");
                    break;
                default:
                    break;
            }
            try
            {
                m = mo.findBestMove(board);
                o.setO(--m); 
                board = o.getBoard();
                n = mo.finalResult(board);
            }catch(Exception ex)
            {
                //do nothing This is to handle arrayout of bound exception 
                //which occurs when there is a draw
            }
            switch (n) {
                case 2:
                    JOptionPane.showMessageDialog(o, "You lose");
                    break;
                default:
                    break;
            }
            
        } 
    }
}



