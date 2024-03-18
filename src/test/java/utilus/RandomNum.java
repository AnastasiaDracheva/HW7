package utilus;

public class RandomNum {

    public static int generateId(){
        int a;
            a = 1 + (int) ( Math.random() * 1000 );
            System.out.println(a);
            return generateId();

    }

}
