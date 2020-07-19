package mokito;

public class Add {

    private ValidNumber validNumber;

    public Add(ValidNumber validNumber){
        this.validNumber = validNumber;
    }

    public int add(Object a, Object b){
        if (validNumber.checkNumber(a) && validNumber.checkNumber(b)){
            return (Integer)a + (Integer)b;
        }
        return 0;
    }
}
