# Proyecto de Consumo de API Pokémon

Este proyecto es una prueba técnica de implementación y consumo de la API de Pokémon, desarrollado con Java y Spring Boot. Se utiliza WebClient para realizar las solicitudes HTTP, y Swagger para documentar y probar las APIs.

## Requisitos

- **Java**: Asegúrate de tener instalado **Java 17** en tu entorno de desarrollo.
- **Spring Boot**: El proyecto está construido sobre **Spring Boot 3.3.3**.

## Estructura del Proyecto

El proyecto sigue una estructura estándar de Spring Boot:

- `src/main/java`: Código fuente principal.
- `src/main/resources`: Archivos de configuración y recursos.

## Endpoints Disponibles

El proyecto expone endpoints que buscan resolver el desafio propuesto.

## Testing de APIs

Para facilitar el testing de las APIs, se integro Swagger en el proyecto. Se puede acceder a la interfaz de Swagger en la siguiente URL: <a href="http://localhost:8080/swagger-ui/index.html">swagger-ui</a>

## Configuración de Seguridad

El proyecto requiere autenticación básica para acceder a algunos de los endpoints. Las credenciales de ejemplo que puedes utilizar para probar la API son:

- **Usuario**: `Diego`
- **Contraseña**: `12345`

## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio.
2. Asegúrate de tener configurado tu entorno con Java 17 y Maven.
3. Ejecuta el siguiente comando para iniciar la aplicación:

   ```bash
   mvn spring-boot:run
