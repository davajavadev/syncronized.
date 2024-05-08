import java.util.Scanner;

public class Main {

    private static int sharedNumber;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число : ");
        sharedNumber = scanner.nextInt();

       /* System.out.println("Без синхронизации : ");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                sharedNumber--;
                System.out.println(Thread.currentThread().getName() + " : " + sharedNumber);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){}
            }).start();
        }
        
        */



       // с использованием синхронизации :

        System.out.println("\nC с использованием синхронизации : ");
        sharedNumber = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (Main.class){
                    sharedNumber--;
                    System.out.println(Thread.currentThread().getName() + " : " + sharedNumber);
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){}
                }
            }).start();
        }

    }
}
