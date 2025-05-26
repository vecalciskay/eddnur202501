# Práctico 5 - Buscador de personas

El objetivo es realizar un programa que muestre
una lista de personas leídas de un archivo.

## Estructura persona
Una persona tiene la siguiente estructura:
* ci: carnet, solo números
* nombre: String, un nombre
* apellido: String, un apellido
* direccion: String, una direccion
* telefono: String, puede contener casi cualquier cosa

## Archivo de lectura
En el archivo se puede leer la lista que tiene la 
información columna por columna en el orden:
* nombre
* apellido
* ci
* direccion
* telefono

Se deben leer todas las personas en una lista 
ordenada. La lista se ordena automáticamente por
nombre, apellido, y ci, en ese orden.

## Interfaz de usuario
* Un panel principal con la lista de personas.
* Un menu para poder cargar la lista 
* Un container (panel) pequeño donde se dibuje el número de personas que hay en la lista con texto
grande. Este panel es un observador de la lista.
* Un panel con un campo de texto para colocar algo
y un botón que busca con el criterio del campo de texto

## Funcionalidades
* Poder cargar el archivo de personas
* Mostrar la lista de personas de manera ordenada
* Poder colocar un criterio de busqueda y la 
aplicación busca por nombre, apellido y dirección.
Junta las listas de los 3 criterios (o nombre o
apellido o direccion) y quita los duplicados si hay
y esa es la lista resultante que muestra en la interfaz
* El archivo se busca en una carpeta que es un
atributo de la clase Configuracion. Implementar
Singleton con esta clase