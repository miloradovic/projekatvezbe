/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Darko
 */
public class TransferObjekatZahtev implements Serializable {

    private int operacija;
    private Object parametar;

    public int getOperacija() {
        return operacija;
    }

    public void setOperaacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

}
