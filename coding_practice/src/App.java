// import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        int iterations=10;
        int first_num= iterations;
        int second_num= first_num-1;
        int c = 0;
        for(int i=0; i<=first_num; i++){
            c= first_num*second_num;
            first_num= c;
            second_num=second_num-1;
            if(second_num==0)
            break;
        }
        System.out.println(c);
        int d=10*9*8*7*6*5*4*3*2*1;
        System.out.println(d);
    }
}
 /*
 iter 1   
 */
