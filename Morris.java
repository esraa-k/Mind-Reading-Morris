import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random; 
import java.util.ArrayList;

class Morris extends JFrame{
    public Morris(){
        super("Mind-Reading Morris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new morrisPanel());
        pack();
        setVisible(true);
    }
    public static void main(String []args){
        Morris game = new Morris();
    }
}