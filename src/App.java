import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args)  {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("Numeri.txt"));
            bw.write("");
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Thread t1 = Thread.currentThread();

        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nInerire nome Thread Principale : ");
        String nomeThread = sc.nextLine();
        System.out.println();
        
        sc.close();

        t1.setName(nomeThread);

        Thread t2 = new Thread(new ThreadFiglio1(), "pari");
        t2.start();

        Thread t3 = new Thread(new ThreadFiglio1(), "dispari");
        t3.start();
        
        System.out.println("" + Thread.currentThread().getName() + "- Ha iniziato la sua esecuzione\n");

        try {
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("Numeri.txt", true));

            for (int i = 28; i <= 40; i += 2) {
            
                bw2.write(Thread.currentThread().getName() + " Numero : " + i + "\n");
                Thread.sleep(1000);

            }

            bw2.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("" + Thread.currentThread().getName() + "- Ha terminato la sua esecuzione\n");

    }
}
