package nur.prog3.graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaSimple extends JFrame {
    private PanelSimple panel;
    private  Pelota modelo;
    public VentanaSimple() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modelo = new Pelota();
        panel = new PanelSimple(modelo);
        modelo.addObserver(panel);
        this.getContentPane().setLayout(new BorderLayout());

        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btn = new JButton("Comenzar");
        btn.addActionListener(e -> animacion());
        this.getContentPane().add(btn, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    private void animacion() {
        Runnable r = () -> {
            for (int i=0; i<300; i++) {
                modelo.setPosicion(i,0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    public static void main(String[] args) {
        new VentanaSimple();
    }
}
