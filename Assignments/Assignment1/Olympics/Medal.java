/*
package = Olympics
 */
package Olympics;

/*
this class represents a certain medal
 */
public class Medal {
    public enum myMedal {
        bronze, silver, gold
    }


    public myMedal medal;
    public String tournament;
    public int year;

    /*
     *** Medal's Constructor ***
     @param: medal gives us an enum value, which represent a winning medal
     @param: tournament gives us the place where the medal have been given
     @param: year gives us the year which the tournament has been
     */
    public Medal(myMedal medal, String tournament, int year) {
        this.medal = medal;
        this.tournament = tournament;
        this.year = year;
    }

    /*
    this function gives us a string that contains the information about the medal's instance
    @return: medal's information
     */
    public String toString() {
        return "(*) Medal: " + this.medal + ".\n(*) Tournament: " + this.tournament + ".\n(*) Year: " + this.year + ".\n";
    }
}


