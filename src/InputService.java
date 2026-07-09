import java.util.InputMismatchException;
import java.util.Scanner;

public class InputService {
    private final Scanner scan = new Scanner(System.in);

    public Integer readIntUntilCorrect(){
        while (true){
            try{
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод");
                scan.nextLine();
            }
        }
    }
    public String readStringUntilCorrect(){
        while (true){
            try{
                return scan.next();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод");
                scan.nextLine();
            }
        }
    }
}
