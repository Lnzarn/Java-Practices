public class EvenOddAnalzyer {
    public static void main(String[] args){
        for(int i = 1; i <= 100; i++){
            System.out.println((i % 2 == 0 ? i + " is an even": i + " is an odd"));
        }
    }
}
