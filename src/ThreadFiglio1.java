import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadFiglio1 implements Runnable{

    @Override
    public void run() {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Medie.txt"));
            bw.write("");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (Thread.currentThread().getName().equals("pari")) {

            System.out.println("\t\t" + Thread.currentThread().getName() + "- Ha iniziato la sua esecuzione\n");

            Thread t1 = new Thread(new ThreadAggiuntivoFiglio());
            
            try {
                BufferedReader br1 = new BufferedReader(new FileReader("Nomi.txt"));
                String r = br1.readLine();
                t1.setName(r);
                br1.close();
                
                t1.start();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                BufferedReader br = new BufferedReader(new FileReader("Numeri1.txt"));
                String r = br.readLine();
                int i = 1;
                int somma = 0;
                int contarighe = 0;

                while(r != null){
                    if(i %2 == 0){
                        somma += Integer.parseInt(r);
                        contarighe++;  
                    }
                    r = br.readLine();
                    i++;
                }

                int mediapari = somma / contarighe;
                System.out.println("\t\t Media valori pari : " + mediapari + "\n");
                
                try {
                    BufferedWriter bw2 = new BufferedWriter(new FileWriter("Medie.txt",true));
                    bw2.write("\t\tMedia valori pari : " + mediapari + "\n");
                    bw2.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                br.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("\t\t" + Thread.currentThread().getName() + "- Ha terminato la sua esecuzione\n");
        }

        if (Thread.currentThread().getName().equals("dispari")) {

            System.out.println("\t\t\t\t" + Thread.currentThread().getName() + "- Ha iniziato la sua esecuzione\n");

            Thread t2 = new Thread(new ThreadAggiuntivoFiglio());
            
            try {
                BufferedReader br1 = new BufferedReader(new FileReader("Nomi.txt"));
                String r = br1.readLine();
                r = br1.readLine();

                t2.setName(r);
                br1.close();
                
                t2.start();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                BufferedReader br = new BufferedReader(new FileReader("Numeri1.txt"));
                String r = br.readLine();

                int i = 1;
                int somma = 0;
                int contarighe = 0;

                while(r != null){
                    if(i %2 != 0){
                        somma += Integer.parseInt(r);
                        contarighe++;
                    }
                    r = br.readLine();
                    i++;
                }

                int mediadispari = somma/contarighe;
                System.out.println("\t\t\t\t Media valori dispari : " + mediadispari + "\n");

                try {
                    BufferedWriter bw2 = new BufferedWriter(new FileWriter("Medie.txt",true));
                    bw2.write("\t\t\t\tMedia valori dispari : " + somma/contarighe + "\n");
                    bw2.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                br.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("\t\t\t\t" + Thread.currentThread().getName() + "- Ha terminato la sua esecuzione\n");
        }
    }
}