package nur.prog3.imagenes.gui;

import nur.prog3.imagenes.Imagen;
import nur.prog3.imagenes.operaciones.CnvertirAGris;
import nur.prog3.imagenes.operaciones.IComando;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagenFrame extends JFrame {
    private final ImagenPanel panel;
    private final Imagen modelo;

    public static void main(String[] args) {
        new ImagenFrame();
    }

    public ImagenFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(600,400);
        panel = new ImagenPanel(modelo);
        modelo.addObservador(panel);

        getContentPane().add(panel, BorderLayout.CENTER);

        JButton btn =  new JButton("Franja roja");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnFranjaRoja_clicked();
            }
        });
        getContentPane().add(btn, BorderLayout.EAST);

        JMenuBar mbar =  new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        mbar.add(menu);

        JMenuItem item = new JMenuItem("Leer imagen");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuArchivo_leerImagen();
            }
        });
        menu.add(item);

        menu = new JMenu("Operaciones");
        mbar.add(menu);

        item = new JMenuItem("Tonos de gris");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuOperaciones_tonosdegris();
            }
        });
        menu.add(item);

        this.setJMenuBar(mbar);

        pack();
        setVisible(true);
    }

    private void menuOperaciones_tonosdegris() {
        //modelo.convertirGris();
        IComando cmd = new CnvertirAGris(modelo);
        cmd.ejecutar();
    }

    private void menuArchivo_leerImagen() {
        try {
            BufferedImage image =
                    ImageIO.read(new File("C:/Users/Public/wwwedd/foto1.png"));
            modelo.setImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void btnFranjaRoja_clicked() {
        modelo.pintarFranja(60,100, 146,54,194);
    }
}
