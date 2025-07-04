# Práctico 7 - Arbol Genealógico

El objetivo del práctico es crear un árbol
genealógico pero guardando toda la información
en una tabla de una base de datos aplicando el 
patrón DAO, Abstract Factory y Singleton.

## Estructura

La base de datos solamente tiene 2 tablas.

**Tabla Persona** 

| Id  | Nombre          | FechaNac   | FechaDec (nul) |
|-----|-----------------|------------|----------------|
| 1   | Jorge Perez     | 10/05/1911 | 20/09/2001 |
| 2   | Soraya Miralles | 23/08/1914 | 15/07/1954 |
| 3   | Daniel Perez    | 10/05/1945 | NUL |
| 4   | Lucia Perez     | 23/08/1948 | NUL |
| 5   | Sofia Nogales   | 10/05/1920 | 07/02/2015 |
| 6   | Martin Perez    | 23/08/1957 | NUL |

**Tabla ArbolGenealogico**

| Id | PadreId (nul) | PersonaId | ConyugeId (nul) |
|---|---------------|-----------|-----------------|
| 1 | NUL           | 1         | 2               |
| 2 | 1             | 3         | NUL             |
| 3 | 1             | 4         | NUL             |
 | 4 | NUL           | 1         | 5 |
| 5 | 4             | 6         | NUL |

## Funcionalidad

El programa permite:

* administrar Personas (ABM)
* administrar relaciones
* ver las relaciones en tipo arbol a partir de
una persona (o nulo) hasta 3 niveles.

## Fecha de presentación

La fecha de presentación es el martes 15 de Julio


