package nur.prog3.observers.simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cuenta {
    private static final Logger logger = LogManager.getRootLogger();
    private double saldo;
    private PropertyChangeSupport observado;

    public Cuenta() {
        saldo = 0;
        observado = new PropertyChangeSupport(this);
    }

    public void deposito(double monto)  {
        logger.info("Depositando " + monto);
        double oldSaldo = saldo;
        saldo += monto;
        double newSaldo = saldo;

        observado.firePropertyChange("CUENTA",
                oldSaldo, newSaldo);
    }

    public void addObserver(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public void depositoInterno(double monto) {
        logger.info("Deposito adicional de " + monto);
        saldo += monto;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                '}';
    }
}
