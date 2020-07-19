package mokito;

public class ValidNumber {

    public boolean checkNumber(Object o){
        if(o instanceof Integer){
            return ((Integer)o<10 && (Integer)o>=0);
        }
        return false;
    }
}
