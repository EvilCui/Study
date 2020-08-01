package study;

public class UpperLetter implements ChangeLetter {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String change() {
        return str.toUpperCase();
    }
}
