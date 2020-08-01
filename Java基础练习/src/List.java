
class Change{
    static void doIt(int[] z){
        //int[] A=z;
        //A[0] = 99;
        z[0] = 99;
    }

}

public class List {
    public static void main(String[] args){
        int[] myArry = {1,2,3,4,5};
        Change.doIt(myArry);
        for(int i = 0;i<myArry.length;i++){
            System.out.println(myArry[i]+" ");
        }
    }
}