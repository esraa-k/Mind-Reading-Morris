import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Horse {
    private Image hPicHap, hPicSad, hPicAng, hPicThink, hPicIdea, hPicWin, hPicGuess;
    private String emo;
    private int x, y;
    public Horse (){
        emo = "hap";
        hPicHap = new ImageIcon("pics/hap.png").getImage();
        hPicSad = new ImageIcon("pics/sad.png").getImage();
        hPicAng = new ImageIcon("pics/ang.png").getImage();
        hPicThink = new ImageIcon("pics/think.png").getImage(); 
        hPicIdea = new ImageIcon("pics/idea.png").getImage();
        hPicWin = new ImageIcon("pics/win.png").getImage();
        hPicGuess = new ImageIcon("pics/morrisGuess.png").getImage();



    }
    public void setEmo(String s){
        emo=s;
    }
    public Image getImage(){
        if (emo=="hap"){
            return hPicHap;
        }
        else if (emo=="sad"){
            return hPicSad;
        }
        else if (emo=="ang"){
            return hPicAng;
        }
        else if (emo=="think"){
            return hPicThink;
        }
        else if (emo=="idea"){
            return hPicIdea;
        }
        else if (emo=="guess"){
            return hPicGuess;
        }
        else{
            return hPicWin;
        }
    }
}
