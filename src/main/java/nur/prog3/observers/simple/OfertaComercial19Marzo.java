package nur.prog3.observers.simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OfertaComercial19Marzo implements
        PropertyChangeListener {
    private static final Logger logger =
            LogManager.getRootLogger();
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logger.info("Observador llamado");
        Cuenta obj = (Cuenta)evt.getSource();
        double oldSaldo = (double)evt.getOldValue();
        double newSaldo = (double)evt.getNewValue();

        double monto = newSaldo - oldSaldo;
        // Oferta comercial 19 de marzo
        if (monto > 100) {
            logger.info("Oferta comercial aplicada");
            int div100 = (int)monto / 100;
            obj.depositoInterno((double)div100);
        }
    }
}
