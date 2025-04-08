package nur.prog3.redes.simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServidorWebImagenes {
    private int puerto;
    private static final Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        ServidorWebImagenes srv = new ServidorWebImagenes(8050);
        srv.comenzar();
    }

    public ServidorWebImagenes(int p) {
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
        OutputStream output = clt.getOutputStream();
        logger.info("Abiertos los canales para escribir y leer, primero leemos un texto");

        logger.info("Se lee todo el input que envia el cliente");
        StringBuilder entrada = new StringBuilder();
        entrada.append(input.readLine());
        String ordenHttp = entrada.toString();
        while(input.ready()) {
            entrada.append(input.readLine());
        }
        logger.info("La entrada es: " + entrada.toString());

        buscarYEnviarImagen(output, ordenHttp);
        output.flush();
        clt.close();
    }

    private void buscarYEnviarImagen(OutputStream output, String ordenHttp) throws IOException {
        String pathGeneral = "C:/Deploy/www";
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
            /*
            image/apng: Animated Portable Network Graphics (APNG)
            image/avif : AV1 Image File Format (AVIF)
            image/gif: Graphics Interchange Format (GIF)
            image/jpeg: Joint Photographic Expert Group image (JPEG)
            image/png: Portable Network Graphics (PNG)
            image/svg+xml: Scalable Vector Graphics (SVG)
            image/webp: Web Picture format (WEBP)
            */
            String mime = "";
            if (path.getParent().endsWith("png")) mime = "image/png";
            else if (path.getParent().endsWith("gif")) mime = "image/gif";
            else if (path.getParent().endsWith("jpg")) mime = "image/jpeg";
            else if (path.getParent().endsWith("jpeg")) mime = "image/jpeg";
            else if (path.getParent().endsWith("svg")) mime = "image/svg+xml";

            byte[] allBytes = Files.readAllBytes(path);

            String line = "HTTP/1.1 200 OK\r\n";
            output.write(line.getBytes(StandardCharsets.UTF_8));
            line = "Content-Type: " + mime + "\r\n";
            output.write(line.getBytes(StandardCharsets.UTF_8));
            line = "Content-Length: " + allBytes.length + "\r\n\r\n";
            output.write(line.getBytes(StandardCharsets.UTF_8));

            output.write(allBytes);
        }
    }
}
