# Práctico 1 - Gravedad y gráficos

El objetivo de este práctico es familiarizarse con el patrón
de diseño observer. Este patrón de diseño es la mejor forma
conocida para notificar de cambios en objetos, esto sin que
se relacionen los objetos observados y los observadores.

## Estructura del programa

El programa debe tener las siguientes clases:

* GravedadFrame: esta clase contiene la ventana de nuestra 
  aplicación. Esta ventana debe acomodarse al tamaño del 
  panel interno que contiene. Esta ventana tiene ademas un panel
  a la derecha que tiene un campo para colocar un número y
  un botón para comenzar la animación.
* GravedadPanel: esta clase es el panel que se encuentra dentro
  de la ventana. El tamaño de este panel es de 800x600 píxeles.
* Pelota: esta clase representa una pelota que se ve en la pantalla
  como un círculo de radio 30 píxeles. La posición inicial de
  esta pelota es la posición del centro en (30,30)

## Reglas de ejecución

Cuando el programa se ejecuta aparece el panel vacío con la 
pelota en su lugar inicial. El espacio del panel está simulando
un espacio real donde cada pixel es un centímetro en la vida
real.

La idea es simular lo más perfectamente posible la caída de
una pelota desde una altura de 6m.