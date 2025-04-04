package nur.prog3.redes.simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServidorWebBasico {
    private int puerto;
    private static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        ServidorWebBasico srv = new ServidorWebBasico(8050);
        srv.comenzar();
    }

    public ServidorWebBasico(int p) {
        puerto  = p;
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

        logger.info("Se lee todo el input que envia el cliente");
        StringBuilder entrada = new StringBuilder();
        entrada.append(input.readLine());
        String ordenHttp = entrada.toString();
        while(input.ready()) {
            entrada.append(input.readLine());
        }
        logger.info("La entrada es: " + entrada.toString());

        output.println("HTTP/1.1 200 OK");
        output.println("");
        buscarYEnviarArchivo(output, ordenHttp);
        output.flush();
        clt.close();
    }

    private void buscarYEnviarArchivo(PrintWriter output, String ordenHttp) throws IOException {
        String pathGeneral = "C:/Users/Public/wwwedd";
        String pathRelativo = "";
        String regex =  "^GET (.+) HTTP\\/([0-9]\\.[0-9])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ordenHttp);
        if (matcher.find()) {
            pathRelativo = matcher.group(1);
        }
        String  pathCompleto = pathGeneral + pathRelativo;

        Path path = Path.of(pathCompleto);
        if (Files.exists(path)) {
            logger.info("Archivo existe, devolviendo completo");
            List<String> allLines = Files.readAllLines(path);
            for (String linea: allLines) {
                output.println(linea);
            }
        }
    }
}
