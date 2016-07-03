/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package komunikacija;

import domen.Mesto;
import domen.PoslovniPartner;
import java.io.*;
import java.net.Socket;
import java.util.List;
import poslovnalogika.Kontroler;
import transfer.*;
import util.Konstante;

/**
 *
 * @author Darko
 */
public class NitKlijent extends Thread {

    private Socket socket;
    private boolean aktivan;

    public NitKlijent(Socket socket) {
        this.socket = socket;
        this.aktivan = true;
    }

    @Override
    public void run() {
        try {
            izvrsenjeOperacija();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Nit je zavrsila sa radom.");
    }

    private void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (aktivan) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjekatZahtev toZahtev = (TransferObjekatZahtev) inSocket.readObject();
            TransferObjekatOdgovor toOdgovor = new TransferObjekatOdgovor();
            try {
                System.out.println("O: " + toZahtev.getOperacija());
                switch (toZahtev.getOperacija()) {
                    case Konstante.VRATI_MESTA:
                        List<Mesto> lm = Kontroler.getInstance().vratiMesta();
                        toOdgovor.setRezultat(lm);
                        toOdgovor.setPoruka("Mesta su ucitana.");
                        break;
                    case Konstante.SACUVAJ_PARTNERA:
                        PoslovniPartner pp = (PoslovniPartner) toZahtev.getParametar();
                        Kontroler.getInstance().dodajPartnera(pp);
                        toOdgovor.setPoruka("Partner je uspesno sacuvan.");
                    case Konstante.KRAJ_RADA:
                        aktivan = false;
                        break;
                }
            } catch (Exception e) {
                toOdgovor.setPoruka(e.getMessage());
                toOdgovor.setIzuzetak(e);
            }
            posaljiOdgovor(toOdgovor);
        }
    }

    private void posaljiOdgovor(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }
}
