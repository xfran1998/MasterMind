package juegoColores.model;

import java.awt.List;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
/*
public class Ranking {
    private List<UserRanking> myRanking = new ArrayList<>();
    
    public Ranking(){
       
    }

    public void LeerRanking(){
        try {
            Scanner myReader = new Scanner(new File(System.getProperty("user.dir")+"/textos/ranking.txt"));

            while (myReader.hasNextLine()) {
                String name = myReader.nextLine();
                int score = Integer.parseInt(myReader.nextLine()); //en caso de que falle ---> Integer.parseInt(...);

                myRanking.add(new UserRanking(name, score));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("F en el chat");
            e.printStackTrace();
        }
    }

    public List<UserRanking> getRanking(){
        return myRanking;
    }

    public test(){
        for (int i=0; i < myRanking.size(); i++)
        {
            UserRanking myUser = myRanking.get(i);

            System.out.println("User: " + myUser.getName());
            System.out.println("Score: " + myUser.getScore());
        }
    }
}
*/