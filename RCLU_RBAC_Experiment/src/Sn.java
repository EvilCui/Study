public class Sn {

    public static double CalculateSu(int a,int b){
        if(b == 1){
            return a;
        }else{
            double n = a/b;
            b--;
            return n+CalculateSu(a,b);

        }
    }

    public static void main(String[] args) {
        double sum = CalculateSu(5,6) ;
        System.out.println(sum);
    }
}
