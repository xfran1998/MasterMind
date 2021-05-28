package juegocolores.model;

public class UserRanking {
    private String name;
    private int score;

    public UserRanking(){
        this.name = "";
        this.score = 0;
    }

    public UserRanking(String name, int score){
        this.name = name;
        this.score = score;
    }

    String getName(){
        return name;
    }

    int getScore(){
        return score;
    }

    void setValues(String name, int score){
        this.name = name;
        this.score = score;
    }
}