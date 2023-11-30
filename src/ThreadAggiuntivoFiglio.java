import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadAggiuntivoFiglio implements Runnable{

    @Override
    public void run() {

        System.out.println("\t" + Thread.currentThread().getName() + "- Ha iniziato la sua esecuzione\n");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write("");
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("output.txt",true));
            for (int i = 111; i <= 129; i++) {
                bw1.write(""+i);
                if ( i!= 129) {
                    bw1.write("-");
                }
            }
            bw1.write("\n");
            bw1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\t" + Thread.currentThread().getName() + "-Terminato\n");
    }
    
}
