import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

class Teacher{
	private Image teacherPic;
	ArrayList<String> pets = new ArrayList<String>();
	ArrayList<String> university = new ArrayList<String>();
	ArrayList<String> sports = new ArrayList<String>();
	ArrayList<String> hobbies = new ArrayList<String>();
	ArrayList<String> subjects = new ArrayList<String>();
	ArrayList<String> clubs = new ArrayList<String>();
	String info, name, gender, hair, eye, music, height, catchphrase;
	boolean glasses, born, married, children, yt;
	int floor, teaching;
	
	public Teacher(String info){
		this.info = info;
		String[] stats = info.split(",");
		int pos, i; 
		teacherPic = new ImageIcon("pics/"+stats[0]+".png").getImage();
		name = stats[0];
		gender = stats[1];
		hair = stats[2];
		eye = stats[3];
		glasses = Boolean.parseBoolean(stats[4]);
		married = Boolean.parseBoolean(stats[5]);
		for (pos = 0; pos<Integer.parseInt(stats[6]); pos++){
			pets.add(stats[7+pos]);
		}
		pos+=7;
		for (i=1; i<Integer.parseInt(stats[pos])+1; i++){
			university.add(stats[pos+i]);
		}
		pos+=i;
		for (i=1; i<Integer.parseInt(stats[pos])+1; i++){
			subjects.add(stats[pos+i]);
		} 
		pos+=i;
		for (i=1; i<Integer.parseInt(stats[pos])+1; i++){
			sports.add(stats[pos+i]);
		}
		pos+=i;
		floor = Integer.parseInt(stats[pos]);
		pos++;
		children = Boolean.parseBoolean(stats[pos]);
		pos++;
		born = Boolean.parseBoolean(stats[pos]);
		pos++;
		yt = Boolean.parseBoolean(stats[pos]);
		pos++;
		for(i=1; i<Integer.parseInt(stats[pos])+1;i++){
			hobbies.add(stats[pos+i]);
		}
		pos+=i;
		music = stats[pos];
		pos++;
		teaching = Integer.parseInt(stats[pos]);
		pos++;
		height = stats[pos];
		pos++;
		catchphrase = stats[pos];
		pos++;
		for(i=1; i<Integer.parseInt(stats[pos])+1;i++){
			clubs.add(stats[pos+i]);
		}
	}
	public String getAttribute(String a){
		Random rand = new Random();
		if (a.equals("name")){
			return name;
		}
		else if (a.equals("teaching")){
			return teaching+"";
		}
		else if (a.equals("hair")){
			return hair;
		}
		else if (a.equals("eye")){
			return eye;
		}
		else if (a.equals("pets")){
			if(pets.size() > 0){
				int r = rand.nextInt(0, pets.size());
				return pets.get(r);
			}
			else{
				return "none";
			}
		}
		else if (a.equals("university")){
			if (university.size() > 0){
				int r = rand.nextInt(0, university.size());
				return university.get(r);
			}
			else{
				return "none"; 
			}
		}
		else if (a.equals("subjects")){
			if(subjects.size() > 0){
				int r = rand.nextInt(0, subjects.size());
				return subjects.get(r);
			}
			else{
				return "none";
			}	
		}
		else if( a.equals("sports")){
			if( sports.size() > 0){
				int r = rand.nextInt(0, sports.size());
				return sports.get(r);
			}
			else{
				return "none";
			}
			
		}
		else if (a.equals("floor")){
			return floor+"";
		}
		else if (a.equals("music")){
			return music;
		}
		else if (a.equals(("height"))){
			// System.out.println(height);
			return height;
		}
		else if (a.equals("catchphrase")){
			return catchphrase;
		}
		else if (a .equals("clubs")){
			if(clubs.size() > 0){
				int r = rand.nextInt(0, clubs.size());
				return clubs.get(r);
			}
			else{
				return "none";
			}
			
		}
		else if (a.equals("hobbies")){
			if(hobbies.size() > 0){
				int r = rand.nextInt(0, hobbies.size());
				return hobbies.get(r);
			}
			else{
				return "none";
			}
		}
		return "";
	}

	public String getName(){
		return name;
	}
	public int getTeaching(){
		return teaching;
	}
	public int getFloor(){
		return floor;
	}
	public boolean getMarried(){
		return married;
	}
	public boolean getChildren(){
		return children;
	}
	public boolean glasses(){
		return glasses;
	}
	public String getCatchphrase(){
		return catchphrase;
	}
	public boolean getBorn(){
		return born;
	}
	public String getGender(){
		return gender;
	}
	public String getHair(){
		return hair;
	}
	public String getEye(){
		return eye;
	}
	public String getHeight(){
		return height;
	}
	public String getMusic(){
		return music;
	}
	public boolean getYt(){
		return yt;
	}
	public String getClub(){
		Random rand = new Random();
		int r = rand.nextInt(0,clubs.size());
		return clubs.get(r);
	}
	public String getPet(){
		Random rand = new Random();
		int r = rand.nextInt(0,pets.size());
		return pets.get(r);
	}
	public String getUni(){
		Random rand = new Random();
		int r = rand.nextInt(0,university.size());
		return university.get(r);
	}
	public String getSport(){
		Random rand = new Random();
		int r = rand.nextInt(0,sports.size());
		return sports.get(r);
	}
	public String getHobbies(){
		Random rand = new Random();
		int r = rand.nextInt(0,hobbies.size());
		return hobbies.get(r);
	}
	public String getSubject(){
		Random rand = new Random();
		int r = rand.nextInt(0,subjects.size());
		return subjects.get(r);
	}
	public String getClubs(){
		Random rand = new Random();
		int r = rand.nextInt(0,clubs.size());
		return clubs.get(r);
	}

	public void drawTeacher(Graphics g){
		g.drawImage(teacherPic, 592, 218, null);
	}
}