#  <img width="120" height="120" alt="Badge-Conversor" src="https://github.com/user-attachments/assets/1d3d4ac2-d53b-4d45-a726-8cbdb3ccf4f7" /> Conversor de Monedas en Java


Proyecto desarrollado como parte del **challenge de conversión de monedas**, para **Alura y Oracle One**, utilizando Java, consumo de APIs REST y procesamiento de respuestas JSON.

Este proyecto demuestra el uso de distintos enfoques para el consumo de APIs en Java, junto con el análisis de datos en formato JSON mediante la biblioteca Gson.

---

## Descripción del Challenge

El objetivo del desafío es construir una aplicación de consola capaz de:

- Consumir una API de tasas de cambio en tiempo real.
- Obtener y gestionar una clave de API.
- Realizar solicitudes HTTP desde Java.
- Procesar respuestas JSON utilizando la biblioteca Gson.
- Filtrar monedas específicas mediante su *Currency Code*.
- Calcular y mostrar conversiones entre distintas monedas.

La API utilizada es **ExchangeRate-API**, que proporciona tasas de conversión actualizadas y endpoints específicos para consultas por pares de monedas.

---

## Tecnologías Utilizadas

- Java  
- Gson (Google JSON Library)  
- ExchangeRate-API  
- HttpClient (enfoque moderno)  
- HttpURLConnection (enfoque clásico)

---

## Estructura del Proyecto

- **Main**  
  Maneja la interacción con el usuario y el menú de opciones.

- **ConversorService**  
  Contiene la lógica de negocio, el consumo de la API y los cálculos de conversión.

---

## Funcionamiento General

El usuario selecciona una opción de conversión desde un menú interactivo, ingresa un valor numérico y el sistema devuelve el monto convertido según la tasa de cambio actual obtenida desde la API.

### Monedas implementadas

- USD — Dólar estadounidense  
- ARS — Peso argentino  
- BRL — Real brasileño  
- COP — Peso colombiano  

---

## Consumo de la API

La aplicación implementa **dos enfoques distintos** para realizar solicitudes HTTP, ambos plenamente funcionales.

### Enfoque principal: HttpClient

Se utiliza la clase `HttpClient` junto con `HttpRequest` para realizar solicitudes modernas, claras y estructuradas.  

Este enfoque representa la forma recomendada de consumir APIs en versiones modernas de Java.

---

### Enfoque alternativo: HttpURLConnection

Se incluye una implementación alternativa utilizando `HttpURLConnection`, que representa el enfoque clásico de Java para el consumo de APIs REST.

Este método se mantiene con fines **educativos y comparativos**, permitiendo contrastar ambas formas de trabajo.

> **Decisión técnica:**  
> Mantener ambos enfoques permite demostrar comprensión tanto del modelo moderno como del tradicional de consumo HTTP en Java.

---

## Procesamiento de JSON

La biblioteca **Gson** se utiliza para:

- Parsear la respuesta JSON de la API.
- Acceder a la estructura mediante `JsonObject` y `JsonElement`.
- Navegar dinámicamente el atributo `conversion_rates`.
- Obtener tasas de conversión a partir del *Currency Code* seleccionado.

---

## Configuración del Proyecto

La clave de la API se obtiene desde una **variable de entorno**, evitando exponer credenciales sensibles en el código fuente.

```bash
API_KEY=tu_clave_aqui
>
