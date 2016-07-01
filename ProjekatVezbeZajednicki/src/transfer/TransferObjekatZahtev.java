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

    private int operaacija;
    private Object parametar;

    public int getOperaacija() {
        return operaacija;
    }

    public void setOperaacija(int operaacija) {
        this.operaacija = operaacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

}
