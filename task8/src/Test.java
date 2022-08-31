import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test extends Thread {
    private int a;
    public Test() throws InterruptedException {
        a =1;
        start();
        sleep(1000);
        System.out.println(a);
    }

    public  void run() {
        a++;
    }
    public static void main(String[] args) throws InterruptedException {
    new Test();
    new Test();
        }
    }

