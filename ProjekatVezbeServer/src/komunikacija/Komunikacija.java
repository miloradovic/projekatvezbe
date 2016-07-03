/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package komunikacija;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author Darko
 */
public class Komunikacija {

    private boolean kraj = false;

    public void pokreniServer() throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut");
        while (!kraj) {
            Socket socket = ss.accept();
            System.out.println("Klijent se povezao");
            NitKlijent nit = new NitKlijent(socket);
            nit.start();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Komunikacija().pokreniServer();
    }
}
