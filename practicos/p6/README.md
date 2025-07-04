Solicitud HTTP (POST Request)

```json
POST /evaluar HTTP/1.1
Host: ejemplo.com
Content-Type: application/json
Content-Length: 22

{
"ecuacion": "34+6"
}
```        
        
📥 Respuesta HTTP (HTTP Response)

```json
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 21

{
"resultado": 40.0
}
```
Formulario ejemplo

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Ecuación</title>
</head>
<body>
    <form action="arbolaaaritmetico.htm" method="post">
        <label for="ecuacion">Ecuación:</label>
        <input type="text" id="ecuacion" name="ecuacion" required>
        <button type="submit">Enviar</button>
    </form>
</body>
</html>
```