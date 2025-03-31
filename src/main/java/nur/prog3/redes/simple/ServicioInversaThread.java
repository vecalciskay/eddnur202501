package nur.prog3.redes.simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServicioInversaThread {
    private static Logger logger = LogManager.getRootLogger();
    private final int puerto;
    private boolean corriendo;
    public static ServicioInversaThread servidor;

    public static void main(String[] args) {
        ServicioInversaThread srv = new ServicioInversaThread(8005);
        servidor = srv;
        srv.comenzar();
    }

    private void comenzar() {
        try (ServerSocket srv = new ServerSocket(puerto)) {
            logger.info("Servidor creado, comienza a escuchar ahora");

            corriendo = true;
            while (corriendo) {
                srv.setSoTimeout(1000);
                try {
                    Socket clt = srv.accept();
                    logger.info("Un cliente se acaba de conectar, comienza a dar el servicio");
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                servicio(clt);
                            } catch (IOException e) {
                                logger.error("Algo paso que no se pudo ejecutar", e);
                            }
                        }
                    });
                    t.start();
                } catch (SocketTimeoutException e1) {
                    logger.info("Timeout de socket, solamente para que pueda chequear la variable de corriendo");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("No pudo crear socket servidor", e);
        }
    }

    public void servicio(Socket clt) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(clt.getInputStream()));
        PrintWriter output = new PrintWriter(clt.getOutputStream());
        logger.info("Abiertos los canales para escribir y leer, primero leemos un texto");

        String leidoDelSocket = input.readLine();
        logger.info("<<<< " + leidoDelSocket);
        String inversa = ejecutar(leidoDelSocket);
        logger.info("Servicio calcula valor y envia: " + inversa);
        output.println(inversa);
        output.flush();
        logger.info(">>>> " + inversa);

        clt.close();
    }

    private String ejecutar(String leidoDelSocket) {
        StringBuilder resultado = new StringBuilder();
        for (int i = leidoDelSocket.length() - 1; i >= 0; i--) {
            resultado.append(leidoDelSocket.charAt(i));
        }
        return resultado.toString();
    }

    public void detener() {
        corriendo = false;
    }

    public ServicioInversaThread(int puerto) {
        this.puerto = puerto;
        this.corriendo = false;
    }
}
