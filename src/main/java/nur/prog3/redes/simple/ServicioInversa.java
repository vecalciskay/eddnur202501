package nur.prog3.redes.simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServicioInversa {
    private static Logger logger = LogManager.getRootLogger();
    private final int puerto;

    public static void main(String[] args) {
        ServicioInversa srv = new ServicioInversa(8004);
        srv.comenzar();
    }

    private void comenzar() {
        try (ServerSocket srv = new ServerSocket(puerto)) {
            logger.info("Servidor creado, comienza a escuchar ahora");
            Socket clt = srv.accept();
            logger.info("Un cliente se acaba de conectar, comienza a dar el servicio");
            servicio(clt);
        } catch (IOException e) {
            throw new RuntimeException("No pudo crear socket servidor", e);
        }
    }

    private void servicio(Socket clt) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(clt.getInputStream()));
        PrintWriter output = new PrintWriter(clt.getOutputStream());
        logger.info("Abiertos los canales para escribir y leer, primero leemos un texto");

        while(true) {
            String leidoDelSocket = input.readLine();
            logger.info("<<<< " + leidoDelSocket);
            if (leidoDelSocket.equals("FIN")) {
                logger.info("Palabra clave FIN, entonces salimos");
                break;
            }
            String inversa = ejecutar(leidoDelSocket);
            logger.info("Servicio calcula valor y envia: " + inversa);
            output.println(inversa);
            output.flush();
            logger.info(">>>> " + inversa);
        }

        clt.close();
    }

    private String ejecutar(String leidoDelSocket) {
        StringBuilder resultado = new StringBuilder();
        for(int i=leidoDelSocket.length()-1; i>=0; i--) {
            resultado.append(leidoDelSocket.charAt(i));
        }
        return resultado.toString();
    }

    public ServicioInversa(int puerto) {
        this.puerto = puerto;
    }
}
