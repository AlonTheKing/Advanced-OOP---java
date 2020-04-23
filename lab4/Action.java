public class Action {

    private String name;


    public Action(String n) {
        this.name = n;
    }
    public String getName(){
        return this.name;
    }
    public boolean equals(Object other) {
        if( this == other){
            return true;
        }
        else if(other instanceof Action){
            return this.name.equals(((Action) other).name);
        }
        return false;
    }

}

