package nur.prog3.imagenes;

public class Imagen {
    private String ruta;
    private int alto;
    private int ancho;
    private int[][] pixeles;

    public Imagen(int w, int h) {
        ancho = w;
        alto = h;
        pixeles = new int[w][h];
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[][] pixeles) {
        this.pixeles = pixeles;
    }
}
