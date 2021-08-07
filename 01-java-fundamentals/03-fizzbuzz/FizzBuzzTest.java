public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz myTest = new FizzBuzz();

        System.out.println(myTest.fizzBuzz(3));
        System.out.println(myTest.fizzBuzz(34));
        System.out.println(myTest.fizzBuzz(10));
        System.out.println(myTest.fizzBuzz(15));
        System.out.println(myTest.fizzBuzz(16));
        System.out.println(myTest.fizzBuzz(2));
        
        for (int i = 1; i <= 50; i++) {
            System.out.println(tester.fizzBuzz(i));
        }
    }
}
