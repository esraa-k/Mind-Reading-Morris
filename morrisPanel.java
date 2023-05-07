import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;

class morrisPanel extends JPanel implements ActionListener, MouseListener{
    Timer myTimer;
    Image gamePic, intropg, yes, no, idk, question, winScreen, maybeScreen, fyes, fno, teacherQ, winHorse, sadHorse, play, liedScreen;
    String gameScreen, attribute, atType, curQ, ansTeach;
    Random rand = new Random();
    Horse morris;

    public static ArrayList<Teacher> all = new ArrayList<Teacher>();
    public static ArrayList<String> attributes = new ArrayList<String>();
    public static ArrayList<String> emotion = new ArrayList<String>();
    public static Teacher curTeacher;
    public static boolean qAsked;

    public morrisPanel(){
        setPreferredSize(new Dimension(1000,800));
        setFocusable(true);
        requestFocus();
        addMouseListener(this);
        myTimer = new Timer(20, this);
        myTimer.start();
        readFile();
//        gamePic = new ImageIcon("gameScreen.png").getImage();
        intropg = new ImageIcon("pics/intropg.png").getImage();
        yes = new ImageIcon("pics/yes.png").getImage();
        no = new ImageIcon("pics/no.png").getImage();
        idk = new ImageIcon("pics/idk.png").getImage();
        question = new ImageIcon("pics/question.png").getImage();
        winScreen = new ImageIcon("pics/endpg.png").getImage();
        maybeScreen = new ImageIcon("pics/maybepg.png").getImage();
        fyes = new ImageIcon("pics/finalYes.png").getImage();
        fno = new ImageIcon("pics/finalNo.png").getImage();
        teacherQ = new ImageIcon("pics/teacherQ.png").getImage();
        winHorse = new ImageIcon("pics/win.png").getImage();
        sadHorse = new ImageIcon("pics/sad.png").getImage();
        play = new ImageIcon("pics/play.png").getImage();
        liedScreen = new ImageIcon("pics/liedpg.png").getImage();





        morris = new Horse();




        Collections.shuffle(all);
        curTeacher = all.get(0);
        gameScreen = "intro";
        attribute = "gender";
        atType = curTeacher.getGender();
        qAsked = true;
        curQ = "Is your teacher "+atType+" ?";
        emotion.add("hap");
        emotion.add("sad");
        emotion.add("think");
        emotion.add("ang");
        emotion.add("idea");
    }

    public void readFile(){
        try{
            Scanner teacherInfile = new Scanner(new File("teachers.txt"));
            Scanner attributeInfile = new Scanner(new File("attributes.txt"));
            int numTeach = Integer.parseInt(teacherInfile.nextLine());
            int att = Integer.parseInt(attributeInfile.nextLine());
            for(int i = 0; i < numTeach; i++){
                Teacher t = new Teacher(teacherInfile.nextLine());
                all.add(t);
            }
            for(int i = 0; i < att; i++){
                attributes.add(attributeInfile.nextLine());
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex);
        }
    }
    public void restart(){
        Collections.shuffle(all);
        curTeacher = all.get(0);
        gameScreen = "intro";
        attribute = "gender";
        atType = curTeacher.getGender();
        qAsked = true;
        curQ = "Is your teacher "+atType+" ?";
    }
    
    public String getQuestion(){
        int r = rand.nextInt(0,attributes.size());
        attribute = attributes.get(r);
        atType = curTeacher.getAttribute(attribute);
        if (atType.equals("none")){
            getQuestion();
        }
        if (attribute.equals("hair") || attribute.equals("eye") ||  attribute.equals("pets")){  
            return "Does your teacher have " + atType + "?";
        }
        else if (attribute.equals("music")){
            return "Does your teacher listen to " + atType + " music?";
        }
        else if (attribute.equals("catchphrase")){
            return "Does your teacher commonly say, \"" + atType + "\"?";
        }
        else if (attribute.equals("subjects")){
            return "Does your teacher teach " + atType + "?";
        }
        else if (attribute.equals("sports")){
            return "Does your teacher like to " + atType + "?";
        }
        else if (attribute.equals("glasses")){
            return "Does your teacher wear glasses?";
        }
        else if (attribute.equals("yt")){
            return "Does your teacher have a YouTube channel?";
        }
        else if (attribute.equals("children")){
            return "Does your teacher have children?";
        }
        else if (attribute.equals("married")){
            return "Is your teacher married?";
        }
        else if (attribute.equals("floor")){
            return "Is your teacher on floor " + atType + "?";
        }
        else if (attribute.equals("height")){
            return "Is your teacher considered " + atType + "?";
        }
        else if (attribute.equals("university")){
            return "Did your teacher go to " + atType + "?";
        }
        else if (attribute.equals("teaching")){
            return "Has your teacher been teaching for about " + atType + " years?";
        }
        else if (attribute.equals("born")){
            return "Was your teacher born and raised in the Windsor/Essex area?";
        }
        else if (attribute.equals("clubs")){
            return "Does your teacher run " + atType + "?";
        }
        else if (attribute.equals("hobbies")){
            return "Does your teacher like " + atType + "?";
        }
        else{
            return "attribute : " + attribute + "atType: " + atType;
        }
    }
    public void elimTeacher(boolean r){//r is response
        ArrayList<Teacher> tremove = new ArrayList<Teacher>();
        
        if (attribute.equals("glasses")){
            for(Teacher t : all){
                if(t.glasses() && !r){
                    tremove.add(t);
                }
                else if(!t.glasses() && r){
                    tremove.add(t);
                }
            }
        }
        else if (attribute.equals("married")){
            for(Teacher t : all){
                if(t.getMarried() && !r){
                    tremove.add(t);
                }
                else if(!t.getMarried() && r){
                    tremove.add(t);
                }
            }
        }
        else if (attribute.equals("children")){
            for(Teacher t : all){
                if(t.getChildren() && !r){
                    tremove.add(t);
                }
                else if(!t.getChildren() && r){
                    tremove.add(t);
                }
            }
        }
        else if (attribute.equals("born")){
            for(Teacher t : all){
                if(t.getBorn() && !r){
                    tremove.add(t);
                }
                else if(!t.getBorn() && r){
                    tremove.add(t);
                }
            }
        }
        else if(attribute.equals("yt")){
            for(Teacher t : all){
                if(t.getYt() && !r){
                    tremove.add(t);
                }
                else if(!t.getYt() && r){
                    tremove.add(t);
                }
            }
        }
        else if (attribute.equals("floor")){
            for(Teacher t : all){
                if(r){
                    if(t.getFloor() != Integer.parseInt(atType)){
                        tremove.add(t);
                    }
                }
                else{
                    if(t.getFloor() == Integer.parseInt(atType)){
                        tremove.add(t);
                    }
                }
            }
        }
        else if (attribute.equals("teaching")){
            for(Teacher t : all){
                if(r){
                    if(t.getTeaching() != Integer.parseInt(atType)){
                        tremove.add(t);
                    }
                }
                else{
                    if(t.getTeaching() == Integer.parseInt(atType)){
                        tremove.add(t);
                    }
                }
            }
        }
        else if (attribute.equals("gender")){
            for(Teacher t : all){
                if(r){
                    if(!t.getGender().equals(atType)){
                        tremove.add(t);
                    }
                }
                else{
                    if(t.getGender().equals(atType)){
                        tremove.add(t);
                    }
                }
            }
        }
        else{
            if(r){
                for(Teacher t : all){
                    if(!t.info.contains(atType)){
                        tremove.add(t);
                    }
                }
            }
            else{
                for(Teacher t : all){
                    if(t.info.contains(","+atType)){
                        tremove.add(t);
                    }
                }
            }
        }

        
        all.removeAll(tremove);
        int i = attributes.indexOf(attribute);
        if(i>0) attributes.remove(i);
        
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font ("Arial Rounded MT Bold", Font.PLAIN, 28));
        if(gameScreen == "intro"){
            g.drawImage(intropg, 0, 0, null);
            g.drawImage(play, 84, 655, null);
        }
        else if(gameScreen == "game"){
            g.drawImage(maybeScreen, 0, 0, null);
            g.drawImage(morris.getImage(), 60,69,null);
            g.setColor(Color.WHITE);
            g.drawImage(question, 505, 69, null);
            g.drawImage(yes, 505, 357, null);
            g.drawImage(no, 505, 482, null);
            g.drawImage(idk, 505, 607, null);
            if(qAsked){
                int ind = 0;
                if(curQ.length() > 26){
                    String temp = curQ;
                    String remain = "";
                    for (int i = curQ.length()-1; i>-1; i--){
                        if (curQ.charAt(i)==' '){
                            ind = i;
                            break;
                        }
                    }
                    temp = curQ.substring(0,ind);
                    remain = curQ.substring(ind,curQ.length());
                    if(remain.length() > 26){
                        String temp1 = remain;
                        String remain1 = "";
                        for (int i = curQ.length()-1; i>-1; i--){
                            if (temp.charAt(i)==' '){
                                ind = i;
                                break;
                            }
                        }
                        temp1 = remain.substring(0,ind);
                        remain1 = remain.substring(ind,remain.length());
                        if (remain1.length()>26){
                            String temp2 = remain1;
                            String remain2 = "";
                            for (int i = curQ.length()-1; i>-1; i--){
                                if(temp.charAt(i)==' '){
                                    ind = i;
                                    break;
                                }
                            }
                            temp2 = remain1.substring(0,ind);
                            remain2 = remain1.substring(ind,remain1.length());
                            g.drawString(temp,532,120);
                            g.drawString(temp1,532,156);
                            g.drawString(temp2,532,192);
                            g.drawString(remain2,532,258);
                        }
                        else{
                            g.drawString(temp,532,120);
                            g.drawString(temp1,532,156);
                            g.drawString(remain1,532,192);
                        }
                    }
                    else{
                        g.drawString(temp,532,120);
                        g.drawString(remain,532,156);
                    }
                }
                else{
                    g.drawString(curQ, 532, 120);
                }
            } 
        }
        else if (gameScreen == "maybe"){
            g.drawImage(maybeScreen, 0,0, null);
            all.get(0).drawTeacher(g);
            morris.setEmo("guess");
            g.drawImage(morris.getImage(),60,69, null);
            g.drawImage(fyes, 530, 618, null);
            g.drawImage(fno, 728, 618, null);
            g.drawImage(teacherQ, 530, 80, null);
            g.setColor(Color.WHITE);
            g.drawString(all.get(0).getName(),630,255);
        }
        else if (gameScreen == "win"){
            g.drawImage(winScreen, 0, 0, null);
            g.drawImage(winHorse, 60, 69, null);
            String text ="I HAVE";
            String text1 = "DEFEATED YOU";
            String text2 = "YET AGAIN!";
            String text3 = "YOU WILL";
            String text4 = "NEIGH-VER";
            String text5 = "CONQUER THE";
            String text6 = "GREAT, THE";
            String text7 = "MIGHTY";
            String text8 = "MORRIS";
            g.setFont(new Font ("Arial Rounded MT Bold", Font.PLAIN, 50));
            g.setColor(Color.WHITE);
            g.drawString(text,500,150);
            g.drawString(text1,500,210);
            g.drawString(text2,500,270);
            g.drawString(text3,500,330);
            g.drawString(text4,500,390);
            g.drawString(text5,500,450);
            g.drawString(text6,500,510);
            g.drawString(text7,500,570);
            g.drawString(text8,500,630);
            g.drawImage(play, 84, 655, null);
        }
        else if (gameScreen == "lose"){
            g.drawImage(maybeScreen, 0, 0, null);
            g.drawImage(sadHorse, 60, 69, null);
            g.drawImage(play, 84, 655, null);
            g.setFont(new Font ("Arial Rounded MT Bold", Font.PLAIN, 50));
            g.setColor(Color.WHITE);
            String text ="WHAAAAAAAT";
            String text1 = "SURELY THIS";
            String text2 = "CANNOT BE.";
            String text3 = "EITHER YOU";
            String text4 = "LIED OR YOU";
            String text5 = "LIED.";
            String text6 = "PLAY AGAIN";
            String text7 = "AND YOU";
            String text8 = "SHALL SEE.";
            g.drawString(text,500,150);
            g.drawString(text1,500,210);
            g.drawString(text2,500,270);
            g.drawString(text3,500,330);
            g.drawString(text4,500,390);
            g.drawString(text5,500,450);
            g.drawString(text6,500,510);
            g.drawString(text7,500,570);
            g.drawString(text8,500,630);
        }
        else if (gameScreen == "LIED"){
            g.drawImage(liedScreen, 0, 0, null);
            morris.setEmo("ang");
            g.drawImage(morris.getImage(),60,69, null);
            g.setFont(new Font ("Arial Rounded MT Bold", Font.PLAIN, 50));
            g.setColor(Color.WHITE);
            String text ="HAY! YOU DARED";
            String text1 = "TO DEFY ME,";
            String text2 = "BUT I AM";
            String text3 = "GREATER THAN";
            String text4 = "THOU, HOLIER";
            String text5 = "THAN THOU";
            String text6 = "AND MORE";
            String text7 = "MAJESTIC";
            String text8 = "THAN THOU!";
            g.drawString(text,500,150);
            g.drawString(text1,500,210);
            g.drawString(text2,500,270);
            g.drawString(text3,500,330);
            g.drawString(text4,500,390);
            g.drawString(text5,500,450);
            g.drawString(text6,500,510);
            g.drawString(text7,500,570);
            g.drawString(text8,500,630);
            g.drawImage(play, 84, 655, null);

        }
        
    }


    @Override
    public void actionPerformed(ActionEvent e){
        Random rand = new Random();
        repaint();
        if (gameScreen == "game"){
            if(all.size()==1){
                gameScreen = "maybe";
            }
            else if(all.size()==0){
                gameScreen = "LIED";
            }
            else if(!qAsked){
                curTeacher = all.get(0);
                curQ = getQuestion();
                morris.setEmo(emotion.get(rand.nextInt(0,emotion.size())));
                qAsked = true; 
                System.out.println("\n"+curQ);
            }
           
        }
    }
    @Override
	public void mouseClicked(MouseEvent e){
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        if(gameScreen == "intro"){
            if(mouse.x > 84 && mouse.x < 917){
                if(mouse.y > 685 && mouse.y < 753){
                    gameScreen = "game";
                }
            }
        }
        else if(gameScreen == "win" || gameScreen == "lose" || gameScreen == "LIED"){
            if(mouse.x > 84 && mouse.x < 917){
                if(mouse.y > 685 && mouse.y < 753){
                    gameScreen = "intro";
                    readFile();
                    restart();
                }
            }
        }
        else if(gameScreen == "game"){
            if(mouse.x > 505 && mouse.x < 942){
                if(mouse.y > 387 && mouse.y < 473){
                    elimTeacher(true);
                    qAsked = false;
                }
                else if(mouse.y > 512 && mouse.y < 598){
                    elimTeacher(false);
                    qAsked = false;

                }
                else if(mouse.y > 637 && mouse.y < 723){
                    qAsked = false;
                }
                for(Teacher t : all){
                    System.out.println(t.getName());
                }
            }
        }
        else if(gameScreen == "maybe"){
            if(mouse.y > 648 && mouse.y < 754){
                if(mouse.x > 530 && mouse.x < 728){
                    gameScreen = "win";
                }
                else if(mouse.x > 728 && mouse.x < 956){
                    gameScreen = "lose";
                }
            }
        }
    }
    @Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
}