package juegocolores.model;

import java.awt.List;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Ranking {
    private ArrayList<UserRanking> myRanking = new ArrayList<>();
    private final int maxPoints;
    String path;
    
    public Ranking(int maxPoints){
       this.maxPoints = maxPoints;
       path = System.getProperty("user.dir")+"/textos/ranking.txt";
    }

    public void LeerRanking(){
        try {
            Scanner myReader = new Scanner(new File(path));

            while (myReader.hasNextLine()) {
                String name = myReader.nextLine();
                int score = Integer.parseInt(myReader.nextLine()); //en caso de que falle ---> Integer.parseInt(...);

                myRanking.add(new UserRanking(name, score));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("no ha funcionado");
            e.printStackTrace();
        }
    }

    public ArrayList<UserRanking> getRanking(){
        return myRanking;
    }
    
    public void addRanking(UserRanking newUser){
        Boolean found = false;
        
        for (int i=0; i < myRanking.size() && !found; i++)
        {
            if (myRanking.get(i).getScore() >= newUser.getScore()){
                myRanking.add(i, newUser);
                found = true;
            }
        }
        
        if (!found && newUser.getScore() <= maxPoints){
            myRanking.add(newUser);
        }
    }
    
    public void saveRaking(){
        try {
            File myFile = new File(path);
            
            if (myFile.createNewFile())
                System.out.println("File created: " + myFile.getName());
            else 
                System.out.println("File already exists.");
            
            FileWriter myWriter = new FileWriter(path);
            for (int i=0; i < myRanking.size(); i++)
            {
                myWriter.write(myRanking.get(i).getName()+"\n");
                myWriter.write(Integer.toString(myRanking.get(i).getScore())+"\n");
            }
            myWriter.close();
            
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void testShow(){
        for (int i=0; i < myRanking.size(); i++)
        {
            UserRanking myUser = myRanking.get(i);

            System.out.println("User: " + myUser.getName());
            System.out.println("Score: " + myUser.getScore());
        }
    }
}