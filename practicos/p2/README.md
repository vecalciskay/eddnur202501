# Práctico 2 - Servidor web con funciones recursivas

Este práctico trata de programar un servidor web. Su programa
tiene que lanzar un servicio en algún puerto específico. Ese
servicio tiene que responder en protocolo HTTP para que desde
el navegador se puedan ver las páginas web publicadas en el 
servidor.

## Funcionalidad

El servidor web debe poder ejecutarse y escuchar consultas
HTTP en version 0.9. Es decir solamente GET por el momento.

### Servidor de paginas web
El servidor tiene una carpeta definida como el sitio a publicar.
Todos los archivos que se soliciten de esa carpeta se deben 
mostrar. Por ejemplo, si el servidor se ejecuta en el puerto
8083 y la carpeta a publicar es C:\Programas\Servidor\Publicado.

En esa carpeta se encuentra el siguiente contenido:

```
Publicado
    |
    |- index.html
    |- otro.html
```

entonces desde el navegador se debe poder ir a la dirección:

```
http://localhost:8083/index.html
```

### Servidor de operaciones hanoi
Adicionalmente, el servidor podrá realizar ciertas operaciones
de manera nativa. En este caso queremos que nos devuelva el
x paso de una solución de hanoi de n anillos indicándole de 
qué torre a qué torre.

```
http://localhost:8083/__op__/hanoi/1_3_3_4
```

Esta dirección solicita al servidor de ejecutar una operación
especial, en este caso, hanoi. Un hanoi que comienza en torre
1 a torre 3 y tiene 3 anillos, y queremos el paso 4.

Sabemos que los 7 movimientos para 3 anillos de 1 a 3 son:

1. De 1 a 3
2. De 1 a 2
3. De 3 a 2
4. De 1 a 3
5. De 2 a 1
6. De 2 a 3
7. De 1 a 3

El 4to movimiento es de 1 a 3 entonces luego de este movimiento
se debe mostrar el estado del hanoi en json:

```json
{
  "hanoi": {
    "torres": [
      {
        "id": 1,
        "anillos": []
      },
      {
        "id": 2,
        "anillos": [
          {
            "tamano": 2
          },
          {
            "tamano": 1
          }
        ]
      },
      {
        "id": 3,
        "anillos": [
          {
            "tamano": 3
          }
        ]
      }
    ]
  }
}
```

Esa es la respuesta que se debe tener.

### Cliente de operaciones hanoi

Se le puede pedir a ChatGPT u otro que le fabrique un cliente
en Javascript que muestre el Hanoi. En esta carpeta se 
encuentra un [ejemplo](clienteHanoi.htm), solo que la estructura de hanoi está
en inglés, se debe cambiar un poco para que sea en español.

Este cliente puede ir yendo paso a paso con un botón mostrando
cómo va cambiando el hanoi hasta que se resuelve.

## Presentación

La presentación del práctico se debe realizar hasta el 11 de
abril de 2025