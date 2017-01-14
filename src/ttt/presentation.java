/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author mbsaicharan
 */
public class presentation {
    
    menu m;
    opg o;
    tpg t;
    public presentation(menu m,opg o,tpg t)
    {
        this.m = m;
        this.o = o;
        this.t = t;
        m.b1Listener(new opgButton());
        m.b2Listener(new tpgButton());
        m.setVisible(true);
       // o.resetListener(new resetO());
        o.menuListener(new menuOAL());
       // t.resetListener(new resetT());
        t.menuListener(new menuTAL());
       // o.buttonsListener(new buttonAction());
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
    
    
    
    class menuOAL implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            m.setVisible(true);
            o.dispose();
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
    
    /*class buttonAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            for(int i=0;i < 9 ; i++)
                if(e.getSource().equals(o.buttonArray[i]))
                    o.setX(i);
            
        }
    }*/
}
