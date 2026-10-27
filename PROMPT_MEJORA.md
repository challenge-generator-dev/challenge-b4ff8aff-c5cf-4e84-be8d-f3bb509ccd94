# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/microservice/Application.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/microservice/infrastructure/config/RouterConfig.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/microservice/infrastructure/config/LoggingAspect.java` — `org.aspectj.lang`: El import org.aspectj.lang.JoinPoint pertenece a org.aspectj.lang, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/microservice/infrastructure/config/LoggingAspect.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.clientId`: Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.requestType`: Se invoca `requestType` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.description`: Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.metadata`: Se invoca `metadata` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.requestId`: Se invoca `requestId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.status`: Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.requestId`: Se invoca `requestId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.save`: Se invoca `save` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestEntity.getRequestId`: Se invoca `getRequestId` sobre `ClientRequestEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.findById`: Se invoca `findById` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.findAll`: Se invoca `findAll` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.deleteById`: Se invoca `deleteById` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestEntity.setRequestId`: Se invoca `setRequestId` sobre `ClientRequestEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.clientId`: Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.requestType`: Se invoca `requestType` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.description`: Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.status`: Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.createdAt`: Se invoca `createdAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.updatedAt`: Se invoca `updatedAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.metadata`: Se invoca `metadata` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.id`: Se invoca `id` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.clientId`: Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.status`: Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.description`: Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.requestType`: Se invoca `requestType` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.metadata`: Se invoca `metadata` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.createdAt`: Se invoca `createdAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.updatedAt`: Se invoca `updatedAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java` — `ClientRequest.clientId`: Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java` — `ClientRequest.id`: Se invoca `id` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.id`: Se invoca `id` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.clientId`: Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.status`: Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.get`: Se invoca `get` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.description`: Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.createdAt`: Se invoca `createdAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Experiencia comprobable en al menos un marco de trabajo (Framework) en su lenguaje de programación principal (por ejemplo, Spring Framework en Java o ASP .net core en C#) y puede realizar el enrutamiento de solicitudes, controlar las variables de entorno, generar registros de rastros (Logs) y conectarse con bases de datos utilizando un Mapeador Relacional de Objetos (ORM).

### Misión / candidato
El candidato es un desarrollador Backend Advanced con experiencia en estructuras de datos y patrones GRASP. Está listo para profundizar en frameworks como Spring Boot.

### Reto
- Tema: Experiencia en Frameworks
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de un microservicio con enrutamiento, logs y persistencia
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del entorno y enrutamiento de solicitudes — objetivo: Configurar el entorno del microservicio y enrutar las solicitudes según las variables de entorno. — entregable (NO resolver): Entorno del microservicio configurado y solicitudes enrutadas según las variables de entorno.
- Fase 2: Generación de logs y trazabilidad — objetivo: Implementar la generación de logs para registrar los eventos del microservicio y garantizar la trazabilidad de las operaciones. — entregable (NO resolver): Logs generados que registran los eventos del microservicio y permiten la trazabilidad de las operaciones.
- Fase 3: Persistencia de datos con ORM — objetivo: Implementar la persistencia de datos utilizando un ORM y asegurar la consistencia de los datos. — entregable (NO resolver): Datos persistidos utilizando un ORM, asegurando la consistencia y disponibilidad.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.microservice</groupId>
    <artifactId>client-request-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>client-request-service</name>
    <description>Microservicio para gestionar solicitudes de clientes con trazabilidad y persistencia</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.3</version>
        </dependency>

        <!-- Logging -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.5.6</version>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.11.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/microservice/Application.java ===
package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.TimeZone;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
@ConfigurationPropertiesScan
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        var app = new SpringApplication(Application.class);
        app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
        app.run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setReadTimeout(Duration.ofSeconds(10));
        restTemplate.setConnectTimeout(Duration.ofSeconds(5));
        return restTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.info("Microservicio iniciado correctamente");
        logger.info("Perfil activo: {}", System.getProperty("spring.profiles.active", "default"));
    }

    @PreDestroy
    public void onShutdown() {
        logger.info("Microservicio detenido");
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: client-request-service
  profiles:
    active: dev
  datasource:
    url: jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:client_requests}
    username: ${DB_USER:postgres}
    password: ${DB_PASSWORD:postgres}
    driver-class-name: org.postgresql.Driver
    hikari:
      connection-timeout: 30000
      maximum-pool-size: 10
      minimum-idle: 2
      idle-timeout: 600000
      max-lifetime: 1800000
      pool-name: ClientRequestHikariPool
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        format_sql: true
        jdbc:
          lob:
            non_contextual_creation: true
        temp:
          use_jdbc_metadata_defaults: false
  mvc:
    format:
      date-time: iso
      date: iso
      time: iso

server:
  port: ${SERVER_PORT:8080}
  servlet:
    context-path: /api/v1
  error:
    include-message: always
    include-binding-errors: always
    include-stacktrace: never
    include-exception: false

logging:
  level:
    root: INFO
    com.microservice: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %X{requestId} - %msg%n"
  file:
    name: logs/client-request-service.log
    max-size: 10MB
    max-history: 7
    total-size-cap: 1GB

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,loggers
  endpoint:
    health:
      show-details: always
  info:
    env:
      enabled: true

// === ARCHIVO: src/main/java/com/microservice/domain/model/ClientRequest.java ===
package com.microservice.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ClientRequest(
    @NotNull(message = "El ID de la solicitud no puede ser nulo")
    UUID requestId,

    @NotBlank(message = "El ID del cliente no puede estar vacío")
    @Size(max = 50, message = "El ID del cliente no puede exceder 50 caracteres")
    String clientId,

    @NotBlank(message = "El tipo de solicitud no puede estar vacío")
    @Size(max = 30, message = "El tipo de solicitud no puede exceder 30 caracteres")
    String requestType,

    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser positivo")
    BigDecimal amount,

    @NotBlank(message = "El estado de la solicitud no puede estar vacío")
    @Size(max = 20, message = "El estado no puede exceder 20 caracteres")
    String status,

    @NotNull(message = "La fecha de creación no puede ser nula")
    LocalDateTime createdAt,

    LocalDateTime updatedAt,

    @NotBlank(message = "El requestId de trazabilidad no puede estar vacío")
    @Size(max = 100, message = "El requestId de trazabilidad no puede exceder 100 caracteres")
    String traceId
) {
    public ClientRequest {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
        if (traceId == null || traceId.isBlank()) {
            traceId = UUID.randomUUID().toString();
        }
    }

    public ClientRequest withStatus(String newStatus) {
        return new ClientRequest(
            this.requestId,
            this.clientId,
            this.requestType,
            this.amount,
            newStatus,
            this.createdAt,
            LocalDateTime.now(),
            this.traceId
        );
    }
}

// === ARCHIVO: src/main/java/com/microservice/domain/ports/in/ClientRequestUseCase.java ===
package com.microservice.domain.ports.in;

import com.microservice.domain.model.ClientRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRequestUseCase {
    ClientRequest createRequest(@Valid ClientRequest request);
    Optional<ClientRequest> getRequestById(UUID requestId);
    List<ClientRequest> getAllRequests();
    ClientRequest updateRequestStatus(UUID requestId, String newStatus);
    void deleteRequest(UUID requestId);
    List<ClientRequest> getRequestsByClientId(String clientId);
    List<ClientRequest> getRequestsByStatus(String status);
}

// === ARCHIVO: src/main/java/com/microservice/domain/ports/out/ClientRequestPersistencePort.java ===
package com.microservice.domain.ports.out;

import com.microservice.domain.model.ClientRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRequestPersistencePort {
    ClientRequest save(ClientRequest request);
    Optional<ClientRequest> findById(UUID requestId);
    List<ClientRequest> findAll();
    void deleteById(UUID requestId);
    List<ClientRequest> findByClientId(String clientId);
    List<ClientRequest> findByStatus(String status);
}

// === ARCHIVO: src/main/java/com/microservice/infrastructure/persistence/repository/ClientRequestRepository.java ===
package com.microservice.infrastructure.persistence.repository;

import com.microservice.infrastructure.persistence.entity.ClientRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequestEntity, UUID> {

    List<ClientRequestEntity> findByClientId(String clientId);

    List<ClientRequestEntity> findByStatus(String status);

    @Query("SELECT cr FROM ClientRequestEntity cr WHERE cr.clientId = :clientId AND cr.status = :status")
    List<ClientRequestEntity> findByClientIdAndStatus(
            @Param("clientId") String clientId,
            @Param("status") String status
    );

    @Query("SELECT cr FROM ClientRequestEntity cr WHERE cr.createdAt >= :startDate")
    List<ClientRequestEntity> findByCreatedAtAfter(
            @Param("startDate") java.time.LocalDateTime startDate
    );

    boolean existsByClientIdAndStatus(String clientId, String status);
}

// === ARCHIVO: src/main/java/com/microservice/application/usecase/ClientRequestService.java ===
package com.microservice.application.usecase;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.in.ClientRequestUseCase;
import com.microservice.domain.ports.out.ClientRequestPersistencePort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientRequestService implements ClientRequestUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestService.class);

    private final ClientRequestPersistencePort persistencePort;

    public ClientRequestService(ClientRequestPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    @Transactional
    public ClientRequest createRequest(@Valid ClientRequest request) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        MDC.put("clientId", request.clientId());

        logger.info("Iniciando creacion de solicitud para cliente: {}", request.clientId());

        ClientRequest requestWithId = new ClientRequest(
                requestId,
                request.clientId(),
                request.requestType(),
                request.description(),
                "PENDING",
                LocalDateTime.now(),
                LocalDateTime.now(),
                request.metadata()
        );

        ClientRequest savedRequest = persistencePort.save(requestWithId);

        logger.info("Solicitud creada exitosamente con ID: {}", savedRequest.requestId());
        MDC.clear();

        return savedRequest;
    }

    @Override
    public Optional<ClientRequest> getRequestById(UUID requestId) {
        MDC.put("requestId", requestId.toString());
        logger.debug("Obteniendo solicitud por ID: {}", requestId);

        Optional<ClientRequest> result = persistencePort.findById(requestId);

        result.ifPresent(req -> 
                logger.debug("Solicitud encontrada: tipo={}, cliente={}", 
                        req.requestType(), req.clientId())
        );

        MDC.clear();
        return result;
    }

    @Override
    public List<ClientRequest> getAllRequests() {
        logger.debug("Obteniendo todas las solicitudes");
        List<ClientRequest> requests = persistencePort.findAll();
        logger.info("Total de solicitudes recuperadas: {}", requests.size());
        return requests;
    }

    @Override
    @Transactional
    public ClientRequest updateRequestStatus(UUID requestId, String newStatus) {
        MDC.put("requestId", requestId.toString());
        logger.info("Actualizando estado de solicitud a: {}", newStatus);

        Optional<ClientRequest> existingRequest = persistencePort.findById(requestId);

        if (existingRequest.isEmpty()) {
            logger.error("Solicitud no encontrada para actualizacion: {}", requestId);
            MDC.clear();
            throw new IllegalArgumentException("Solicitud no encontrada: " + requestId);
        }

        ClientRequest request = existingRequest.get();
        ClientRequest updatedRequest = request.withStatus(newStatus);

        logger.debug("Solicitud actualizada: {} -> {}", request.status(), newStatus);

        ClientRequest savedRequest = persistencePort.save(updatedRequest);
        logger.info("Estado de solicitud actualizado exitosamente");

        MDC.clear();
        return savedRequest;
    }

    @Override
    @Transactional
    public void deleteRequest(UUID requestId) {
        MDC.put("requestId", requestId.toString());
        logger.info("Eliminando solicitud: {}", requestId);

        if (!persistencePort.findById(requestId).isPresent()) {
            logger.error("Solicitud no encontrada para eliminacion: {}", requestId);
            MDC.clear();
            throw new IllegalArgumentException("Solicitud no encontrada: " + requestId);
        }

        persistencePort.deleteById(requestId);
        logger.info("Solicitud eliminada exitosamente");

        MDC.clear();
    }

    @Override
    public List<ClientRequest> getRequestsByClientId(String clientId) {
        MDC.put("clientId", clientId);
        logger.debug("Obteniendo solicitudes para cliente: {}", clientId);

        List<ClientRequest> requests = persistencePort.findByClientId(clientId);
        logger.info("Total de solicitudes para cliente {}: {}", clientId, requests.size());

        MDC.clear();
        return requests;
    }

    @Override
    public List<ClientRequest> getRequestsByStatus(String status) {
        MDC.put("status", status);
        logger.debug("Obteniendo solicitudes con estado: {}", status);

        List<ClientRequest> requests = persistencePort.findByStatus(status);
        logger.info("Total de solicitudes con estado {}: {}", status, requests.size());

        MDC.clear();
        return requests;
    }
}

// === ARCHIVO: src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java ===
package com.microservice.infrastructure.persistence.adapter;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.out.ClientRequestPersistencePort;
import com.microservice.infrastructure.persistence.entity.ClientRequestEntity;
import com.microservice.infrastructure.persistence.repository.ClientRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClientRequestJpaAdapter implements ClientRequestPersistencePort {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestJpaAdapter.class);

    private final ClientRequestRepository repository;

    public ClientRequestJpaAdapter(ClientRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ClientRequest save(ClientRequest request) {
        logger.debug("Persistiendo solicitud: {}", request.requestId());

        ClientRequestEntity entity = toEntity(request);
        ClientRequestEntity savedEntity = repository.save(entity);

        logger.debug("Solicitud persistida exitosamente: {}", savedEntity.getRequestId());
        return toDomain(savedEntity);
    }

    @Override
    public Optional<ClientRequest> findById(UUID requestId) {
        logger.debug("Buscando solicitud por ID: {}", requestId);
        return repository.findById(requestId).map(this::toDomain);
    }

    @Override
    public List<ClientRequest> findAll() {
        logger.debug("Recuperando todas las solicitudes");
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(UUID requestId) {
        logger.debug("Eliminando solicitud por ID: {}", requestId);
        repository.deleteById(requestId);
    }

    @Override
    public List<ClientRequest> findByClientId(String clientId) {
        logger.debug("Buscando solicitudes por clientId: {}", clientId);
        return repository.findByClientId(clientId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientRequest> findByStatus(String status) {
        logger.debug("Buscando solicitudes por status: {}", status);
        return repository.findByStatus(status).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private ClientRequestEntity toEntity(ClientRequest domain) {
        ClientRequestEntity entity = new ClientRequestEntity();
        entity.setRequestId(domain.requestId());
        entity.setClientId(domain.clientId());
        entity.setRequestType(domain.requestType());
        entity.setDescription(domain.description());
        entity.setStatus(domain.status());
        entity.setCreatedAt(domain.createdAt());
        entity.setUpdatedAt(domain.updatedAt());
        entity.setMetadata(domain.metadata());
        return entity;
    }

    private ClientRequest toDomain(ClientRequestEntity entity) {
        return new ClientRequest(
                entity.getRequestId(),
                entity.getClientId(),
                entity.getRequestType(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getCreatedAt() != null ? entity.getCreatedAt() : LocalDateTime.now(),
                entity.getUpdatedAt() != null ? entity.getUpdatedAt() : LocalDateTime.now(),
                entity.getMetadata()
        );
    }
}

// === ARCHIVO: src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java ===
package com.microservice.infrastructure.persistence.entity;


import com.microservice.domain.model.ClientRequest;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "client_requests", indexes = {
    @Index(name = "idx_client_id", columnList = "clientId"),
    @Index(name = "idx_status", columnList = "status"),
    @Index(name = "idx_created_at", columnList = "createdAt")
})
public class ClientRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String clientId;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(length = 500)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "request_type", length = 100)
    private String requestType;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    public ClientRequestEntity() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public static ClientRequestEntity fromDomain(com.microservice.domain.model.ClientRequest domain) {
        if (domain == null) {
            return null;
        }
        ClientRequestEntity entity = new ClientRequestEntity();
        entity.setId(domain.id());
        entity.setClientId(domain.clientId());
        entity.setStatus(domain.status());
        entity.setDescription(domain.description());
        entity.setRequestType(domain.requestType());
        entity.setMetadata(domain.metadata());
        if (domain.createdAt() != null) {
            entity.setCreatedAt(domain.createdAt());
        }
        if (domain.updatedAt() != null) {
            entity.setUpdatedAt(domain.updatedAt());
        }
        return entity;
    }

    public com.microservice.domain.model.ClientRequest toDomain() {
        return new com.microservice.domain.model.ClientRequest(
            this.id,
            this.clientId,
            this.status,
            this.description,
            this.requestType,
            this.metadata,
            this.createdAt,
            this.updatedAt
        );
    }
}

// === ARCHIVO: src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java ===
package com.microservice.infrastructure.web.controller;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.in.ClientRequestUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client-requests")
public class ClientRequestController {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestController.class);
    private final ClientRequestUseCase clientRequestUseCase;

    public ClientRequestController(ClientRequestUseCase clientRequestUseCase) {
        this.clientRequestUseCase = clientRequestUseCase;
    }

    @PostMapping
    public ResponseEntity<ClientRequest> createRequest(@Valid @RequestBody ClientRequest request) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Creating new client request for clientId: {}", request.clientId());
        try {
            ClientRequest created = clientRequestUseCase.createRequest(request);
            logger.info("Client request created successfully with id: {}", created.id());
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            logger.error("Error creating client request: {}", e.getMessage(), e);
            throw e;
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientRequest> getRequestById(@PathVariable UUID id) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching client request with id: {}", id);
        try {
            return clientRequestUseCase.getRequestById(id)
                .map(request -> {
                    logger.info("Client request found: {}", id);
                    return ResponseEntity.ok(request);
                })
                .orElseGet(() -> {
                    logger.warn("Client request not found: {}", id);
                    return ResponseEntity.notFound().build();
                });
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientRequest>> getAllRequests() {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching all client requests");
        try {
            List<ClientRequest> requests = clientRequestUseCase.getAllRequests();
            logger.info("Retrieved {} client requests", requests.size());
            return ResponseEntity.ok(requests);
        } finally {
            MDC.remove("requestId");
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ClientRequest> updateRequestStatus(
            @PathVariable UUID id,
            @RequestParam String newStatus) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Updating status for client request id: {} to status: {}", id, newStatus);
        try {
            ClientRequest updated = clientRequestUseCase.updateRequestStatus(id, newStatus);
            logger.info("Client request status updated successfully: {}", id);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            logger.error("Error updating client request status: {}", e.getMessage(), e);
            throw e;
        } finally {
            MDC.remove("requestId");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable UUID id) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Deleting client request with id: {}", id);
        try {
            clientRequestUseCase.deleteRequest(id);
            logger.info("Client request deleted successfully: {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting client request: {}", e.getMessage(), e);
            throw e;
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ClientRequest>> getRequestsByClientId(@PathVariable String clientId) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching client requests for clientId: {}", clientId);
        try {
            List<ClientRequest> requests = clientRequestUseCase.getRequestsByClientId(clientId);
            logger.info("Retrieved {} requests for clientId: {}", requests.size(), clientId);
            return ResponseEntity.ok(requests);
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ClientRequest>> getRequestsByStatus(@PathVariable String status) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching client requests with status: {}", status);
        try {
            List<ClientRequest> requests = clientRequestUseCase.getRequestsByStatus(status);
            logger.info("Retrieved {} requests with status: {}", requests.size(), status);
            return ResponseEntity.ok(requests);
        } finally {
            MDC.remove("requestId");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Unhandled exception in controller: {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred processing the request: " + e.getMessage());
    }
}

// === ARCHIVO: src/main/java/com/microservice/infrastructure/config/RouterConfig.java ===
package com.microservice.infrastructure.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RouterConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(RouterConfig.class);

    @Value("${app.api.prefix:api}")
    private String apiPrefix;

    @Value("${app.api.version:v1}")
    private String apiVersion;

    @Value("${app.cors.allowed-origins:*}")
    private String allowedOrigins;

    @Value("${app.cors.allowed-methods:GET,POST,PUT,DELETE,OPTIONS}")
    private String allowedMethods;

    @Value("${app.cors.max-age:3600}")
    private long corsMaxAge;

    @Value("${app.routing.case-sensitive:false}")
    private boolean caseSensitive;

    @Value("${app.routing.trailing-slash:false}")
    private boolean trailingSlash;

    private Map<String, String> routeMappings;

    @PostConstruct
    public void init() {
        routeMappings = new HashMap<>();
        routeMappings.put("/client-requests", "/api/" + apiVersion + "/client-requests");
        routeMappings.put("/health", "/actuator/health");
        routeMappings.put("/metrics", "/actuator/metrics");
        logger.info("RouterConfig initialized with prefix: {} and version: {}", apiPrefix, apiVersion);
        logger.info("Route mappings: {}", routeMappings);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(trailingSlash);
        configurer.setUseCaseSensitiveMatch(caseSensitive);
        logger.debug("Path match configured - caseSensitive: {}, trailingSlash: {}", caseSensitive, trailingSlash);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = allowedOrigins.split(",");
        String[] methods = allowedMethods.split(",");
        
        registry.addMapping("/**")
            .allowedOrigins(origins)
            .allowedMethods(methods)
            .allowedHeaders("*")
            .allowCredentials(false)
            .maxAge(corsMaxAge);
        
        logger.info("CORS configured with allowed origins: {} and methods: {}", allowedOrigins, allowedMethods);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("Interceptors registered in RouterConfig");
    }

    public String getApiPrefix() {
        return apiPrefix;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getFullApiPath() {
        return "/" + apiPrefix + "/" + apiVersion;
    }

    public Map<String, String> getRouteMappings() {
        return new HashMap<>(routeMappings);
    }

    public String resolveRoute(String path) {
        return routeMappings.getOrDefault(path, getFullApiPath() + path);
    }

    public boolean isRouteEnabled(String path) {
        return routeMappings.containsKey(path);
    }
}

// === ARCHIVO: src/main/java/com/microservice/infrastructure/config/LoggingAspect.java ===
package com.microservice.infrastructure.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Aspect
@Component
public class LoggingAspect {

    private static final String REQUEST_ID = "requestId";
    private static final String USER_ID = "userId";
    private static final String CLASS_NAME = "className";
    private static final String METHOD_NAME = "methodName";
    private static final String EXECUTION_TIME = "executionTime";

    @Pointcut("execution(* com.microservice.application.usecase..*(..)) || " +
              "execution(* com.microservice.infrastructure.web.controller..*(..)) || " +
              "execution(* com.microservice.domain.ports.in..*(..)))")
    public void applicationLayerMethods() {}

    @Around("applicationLayerMethods()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();

        String requestId = MDC.get(REQUEST_ID);
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
            MDC.put(REQUEST_ID, requestId);
        }

        MDC.put(CLASS_NAME, className);
        MDC.put(METHOD_NAME, methodName);

        Logger logger = getLogger(signature.getDeclaringType());

        logMethodEntry(logger, className, methodName, args);

        long startTime = System.currentTimeMillis();
        Object result = null;
        Throwable thrown = null;

        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable t) {
            thrown = t;
            throw t;
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            MDC.put(EXECUTION_TIME, String.valueOf(executionTime));

            if (thrown != null) {
                logMethodException(logger, className, methodName, thrown, executionTime);
            } else {
                logMethodExit(logger, className, methodName, result, executionTime);
            }

            MDC.remove(CLASS_NAME);
            MDC.remove(METHOD_NAME);
            MDC.remove(EXECUTION_TIME);

            if (MDC.get(REQUEST_ID) != null && MDC.get(REQUEST_ID).equals(requestId)) {
                if (!isNestedCall()) {
                    MDC.remove(REQUEST_ID);
                }
            }
        }
    }

    private void logMethodEntry(Logger logger, String className, String methodName, Object[] args) {
        if (logger.isDebugEnabled()) {
            String argsString = sanitizeArgs(args);
            logger.debug("Entering method: {}.{}() | Args: [{}]", className, methodName, argsString);
        } else {
            logger.info("Entering method: {}.{}()", className, methodName);
        }
    }

    private void logMethodExit(Logger logger, String className, String methodName, 
                                Object result, long executionTime) {
        if (logger.isDebugEnabled()) {
            String resultString = sanitizeResult(result);
            logger.debug("Exiting method: {}.{}() | Result: {} | Time: {}ms", 
                        className, methodName, resultString, executionTime);
        } else {
            logger.info("Exiting method: {}.{}() | Time: {}ms", className, methodName, executionTime);
        }
    }

    private void logMethodException(Logger logger, String className, String methodName, 
                                     Throwable thrown, long executionTime) {
        logger.error("Exception in method: {}.{}() | Exception: {} | Message: {} | Time: {}ms",
                    className, methodName, thrown.getClass().getSimpleName(), 
                    thrown.getMessage(), executionTime, thrown);
    }

    private String sanitizeArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return "";
        }
        return Arrays.stream(args)
                .map(this::sanitizeObject)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    private String sanitizeResult(Object result) {
        if (result == null) {
            return "null";
        }
        return sanitizeObject(result);
    }

    private String sanitizeObject(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof byte[] || obj instanceof Byte[]) {
            return "[binary data]";
        }
        if (obj instanceof char[] || obj instanceof Character[]) {
            return "[char data]";
        }
        String str = obj.toString();
        if (str.length() > 200) {
            return str.substring(0, 200) + "...[truncated]";
        }
        return str;
    }

    private Logger getLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }

    private boolean isNestedCall() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int applicationLayerCount = 0;
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.contains("com.microservice.application") || 
                className.contains("com.microservice.infrastructure.web") ||
                className.contains("com.microservice.domain")) {
                applicationLayerCount++;
            }
        }
        return applicationLayerCount > 1;
    }

    public static void setUserId(String userId) {
        if (userId != null && !userId.isEmpty()) {
            MDC.put(USER_ID, userId);
        }
    }

    public static void clearUserId() {
        MDC.remove(USER_ID);
    }

    public static String getRequestId() {
        return MDC.get(REQUEST_ID);
    }

    public static String getUserId() {
        return MDC.get(USER_ID);
    }
}

// === ARCHIVO: src/main/resources/logback-spring.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
    
    <property name="LOG_FILE" value="${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}}/client-request-service.log}"/>
    <property name="CONSOLE_LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %highlight(%-5level) %cyan(%logger{36}) - %magenta(%X{requestId:-N/A}) %magenta(%X{userId:-N/A}) - %msg%n"/>
    <property name="FILE_LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %X{requestId:-N/A} %X{userId:-N/A} - %msg%n"/>
    <property name="LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %highlight(%-5level) %cyan(%logger{36}) - %msg%n"/>
    
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
            <charset>UTF-8</charset>
        </encoder>
    </appender>
    
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_FILE}</file>
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
            <charset>UTF-8</charset>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz</fileNamePattern>
            <maxFileSize>10MB</maxFileSize>
            <maxHistory>30</maxHistory>
            <totalSizeCap>1GB</totalSizeCap>
        </rollingPolicy>
    </appender>
    
    <appender name="ASYNC_FILE" class="ch.qos.logback.classic.AsyncAppender">
        <appender-ref ref="FILE"/>
        <queueSize>512</queueSize>
        <discardingThreshold>0</discardingThreshold>
        <includeCallerData>false</includeCallerData>
    </appender>
    
    <appender name="ASYNC_CONSOLE" class="ch.qos.logback.classic.AsyncAppender">
        <appender-ref ref="CONSOLE"/>
        <queueSize>256</queueSize>
        <discardingThreshold>0</discardingThreshold>
        <includeCallerData>false</includeCallerData>
    </appender>
    
    <logger name="com.microservice" level="INFO" additivity="false">
        <appender-ref ref="ASYNC_CONSOLE"/>
        <appender-ref ref="ASYNC_FILE"/>
    </logger>
    
    <logger name="com.microservice.application" level="DEBUG" additivity="false">
        <appender-ref ref="ASYNC_CONSOLE"/>
        <appender-ref ref="ASYNC_FILE"/>
    </logger>
    
    <logger name="com.microservice.infrastructure" level="INFO" additivity="false">
        <appender-ref ref="ASYNC_CONSOLE"/>
        <appender-ref ref="ASYNC_FILE"/>
    </logger>
    
    <logger name="com.microservice.domain" level="INFO" additivity="false">
        <appender-ref ref="ASYNC_CONSOLE"/>
        <appender-ref ref="ASYNC_FILE"/>
    </logger>
    
    <logger name="org.springframework" level="INFO"/>
    <logger name="org.springframework.web" level="INFO"/>
    <logger name="org.springframework.boot" level="INFO"/>
    <logger name="org.springframework.data.jpa" level="INFO"/>
    <logger name="org.hibernate.SQL" level="DEBUG"/>
    <logger name="org.hibernate.type.descriptor.sql.BasicBinder" level="TRACE"/>
    
    <logger name="ch.qos.logback" level="WARN"/>
    <logger name="org.postgresql" level="WARN"/>
    
    <springProfile name="dev">
        <logger name="com.microservice" level="DEBUG"/>
        <logger name="com.microservice.application" level="DEBUG"/>
    </springProfile>
    
    <springProfile name="prod">
        <logger name="com.microservice" level="INFO"/>
        <logger name="com.microservice.application" level="INFO"/>
    </springProfile>
    
    <springProfile name="test">
        <logger name="com.microservice" level="DEBUG"/>
        <root level="WARN">
            <appender-ref ref="CONSOLE"/>
        </root>
    </springProfile>
    
    <root level="INFO">
        <appender-ref ref="ASYNC_CONSOLE"/>
        <appender-ref ref="ASYNC_FILE"/>
    </root>
    
    <statusListener class="ch.qos.logback.core.status.OnConsoleStatusListener"/>
</configuration>

// === ARCHIVO: src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java ===
package com.microservice.application.usecase;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.out.ClientRequestPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ClientRequestService - Tests Unitarios")
class ClientRequestServiceTest {

    @Mock
    private ClientRequestPersistencePort persistencePort;

    @InjectMocks
    private ClientRequestService clientRequestService;

    private ClientRequest sampleRequest;
    private UUID sampleRequestId;
    private String sampleClientId;
    private String sampleStatus;

    @BeforeEach
    void setUp() {
        sampleRequestId = UUID.randomUUID();
        sampleClientId = "CLIENT-001";
        sampleStatus = "PENDING";
        
        sampleRequest = new ClientRequest(
            sampleRequestId,
            sampleClientId,
            "Test request description",
            sampleStatus,
            java.time.LocalDateTime.now(),
            java.time.LocalDateTime.now()
        );
    }

    @Nested
    @DisplayName("Create Request Tests")
    class CreateRequestTests {

        @Test
        @DisplayName("Debe crear una solicitud exitosamente")
        void shouldCreateRequestSuccessfully() {
            ClientRequest newRequest = new ClientRequest(
                null,
                sampleClientId,
                "New request description",
                "PENDING",
                null,
                null
            );

            ClientRequest savedRequest = new ClientRequest(
                UUID.randomUUID(),
                sampleClientId,
                "New request description",
                "PENDING",
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
            );

            when(persistencePort.save(any(ClientRequest.class))).thenReturn(savedRequest);

            ClientRequest result = clientRequestService.createRequest(newRequest);

            assertThat(result).isNotNull();
            assertThat(result.id()).isNotNull();
            assertThat(result.clientId()).isEqualTo(sampleClientId);
            assertThat(result.status()).isEqualTo("PENDING");

            verify(persistencePort, times(1)).save(any(ClientRequest.class));
        }

        @Test
        @DisplayName("Debe propagar excepción cuando persistencePort falla en save")
        void shouldPropagateExceptionWhenPersistencePortFails() {
            ClientRequest newRequest = new ClientRequest(
                null,
                sampleClientId,
                "Test",
                "PENDING",
                null,
                null
            );

            when(persistencePort.save(any(ClientRequest.class)))
                .thenThrow(new RuntimeException("Database connection failed"));

            assertThatThrownBy(() -> clientRequestService.createRequest(newRequest))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Database connection failed");

            verify(persistencePort, times(1)).save(any(ClientRequest.class));
        }
    }

    @Nested
    @DisplayName("Get Request Tests")
    class GetRequestTests {

        @Test
        @DisplayName("Debe obtener solicitud por ID exitosamente")
        void shouldGetRequestByIdSuccessfully() {
            when(persistencePort.findById(sampleRequestId)).thenReturn(Optional.of(sampleRequest));

            Optional<ClientRequest> result = clientRequestService.getRequestById(sampleRequestId);

            assertThat(result).isPresent();
            assertThat(result.get().id()).isEqualTo(sampleRequestId);
            assertThat(result.get().clientId()).isEqualTo(sampleClientId);

            verify(persistencePort, times(1)).findById(sampleRequestId);
        }

        @Test
        @DisplayName("Debe retornar Optional vacío cuando solicitud no existe")
        void shouldReturnEmptyWhenRequestNotFound() {
            UUID nonExistentId = UUID.randomUUID();
            when(persistencePort.findById(nonExistentId)).thenReturn(Optional.empty());

            Optional<ClientRequest> result = clientRequestService.getRequestById(nonExistentId);

            assertThat(result).isEmpty();

            verify(persistencePort, times(1)).findById(nonExistentId);
        }

        @Test
        @DisplayName("Debe obtener todas las solicitudes")
        void shouldGetAllRequests() {
            ClientRequest request2 = new ClientRequest(
                UUID.randomUUID(),
                "CLIENT-002",
                "Second request",
                "COMPLETED",
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
            );

            List<ClientRequest> requests = Arrays.asList(sampleRequest, request2);
            when(persistencePort.findAll()).thenReturn(requests);

            List<ClientRequest> result = clientRequestService.getAllRequests();

            assertThat(result).hasSize(2);
            assertThat(result).containsExactlyInAnyOrder(sampleRequest, request2);

            verify(persistencePort, times(1)).findAll();
        }
    }

    @Nested
    @DisplayName("Update Request Tests")
    class UpdateRequestTests {

        @Test
        @DisplayName("Debe actualizar estado de solicitud exitosamente")
        void shouldUpdateRequestStatusSuccessfully() {
            String newStatus = "APPROVED";
            ClientRequest updatedRequest = new ClientRequest(
                sampleRequestId,
                sampleClientId,
                sampleRequest.description(),
                newStatus,
                sampleRequest.createdAt(),
                java.time.LocalDateTime.now()
            );

            when(persistencePort.findById(sampleRequestId)).thenReturn(Optional.of(sampleRequest));
            when(persistencePort.save(any(ClientRequest.class))).thenReturn(updatedRequest);

            ClientRequest result = clientRequestService.updateRequestStatus(sampleRequestId, newStatus);

            assertThat(result).isNotNull();
            assertThat(result.status()).isEqualTo(newStatus);

            ArgumentCaptor<ClientRequest> requestCaptor = ArgumentCaptor.forClass(ClientRequest.class);
            verify(persistencePort).save(requestCaptor.capture());
            assertThat(requestCaptor.getValue().status()).isEqualTo(newStatus);
        }

        @Test
        @DisplayName("Debe lanzar excepción al actualizar solicitud inexistente")
        void shouldThrowExceptionWhenUpdatingNonExistentRequest() {
            UUID nonExistentId = UUID.randomUUID();
            when(persistencePort.findById(nonExistentId)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> 
                clientRequestService.updateRequestStatus(nonExistentId, "APPROVED"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Request not found");

            verify(persistencePort, times(1)).findById(nonExistentId);
            verify(persistencePort, never()).save(any(ClientRequest.class));
        }
    }

    @Nested
    @DisplayName("Delete Request Tests")
    class DeleteRequestTests {

        @Test
        @DisplayName("Debe eliminar solicitud exitosamente")
        void shouldDeleteRequestSuccessfully() {
            when(persistencePort.findById(sampleRequestId)).thenReturn(Optional.of(sampleRequest));
            doNothing().when(persistencePort).deleteById(sampleRequestId);

            clientRequestService.deleteRequest(sampleRequestId);

            verify(persistencePort, times(1)).findById(sampleRequestId);
            verify(persistencePort, times(1)).deleteById(sampleRequestId);
        }

        @Test
        @DisplayName("Debe lanzar excepción al eliminar solicitud inexistente")
        void shouldThrowExceptionWhenDeletingNonExistentRequest() {
            UUID nonExistentId = UUID.randomUUID();
            when(persistencePort.findById(nonExistentId)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> clientRequestService.deleteRequest(nonExistentId))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Request not found");

            verify(persistencePort, times(1)).findById(nonExistentId);
            verify(persistencePort, never()).deleteById(any(UUID.class));
        }
    }

    @Nested
    @DisplayName("Query Tests")
    class QueryTests {

        @Test
        @DisplayName("Debe obtener solicitudes por clientId")
        void shouldGetRequestsByClientId() {
            List<ClientRequest> requests = Arrays.asList(
                sampleRequest,
                new ClientRequest(
                    UUID.randomUUID(),
                    sampleClientId,
                    "Second request",
                    "COMPLETED",
                    java.time.LocalDateTime.now(),
                    java.time.LocalDateTime.now()
                )
            );

            when(persistencePort.findByClientId(sampleClientId)).thenReturn(requests);

            List<ClientRequest> result = clientRequestService.getRequestsByClientId(sampleClientId);

            assertThat(result).hasSize(2);
            assertThat(result).allMatch(r -> r.clientId().equals(sampleClientId));

            verify(persistencePort, times(1)).findByClientId(sampleClientId);
        }

        @Test
        @DisplayName("Debe obtener solicitudes por status")
        void shouldGetRequestsByStatus() {
            List<ClientRequest> requests = Arrays.asList(sampleRequest);

            when(persistencePort.findByStatus(sampleStatus)).thenReturn(requests);

            List<ClientRequest> result = clientRequestService.getRequestsByStatus(sampleStatus);

            assertThat(result).hasSize(1);
            assertThat(result).allMatch(r -> r.status().equals(sampleStatus));

            verify(persistencePort, times(1)).findByStatus(sampleStatus);
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay solicitudes para cliente")
        void shouldReturnEmptyListWhenNoRequestsForClient() {
            when(persistencePort.findByClientId("NON-EXISTENT")).thenReturn(Arrays.asList());

            List<ClientRequest> result = clientRequestService.getRequestsByClientId("NON-EXISTENT");

            assertThat(result).isEmpty();

            verify(persistencePort, times(1)).findByClientId("NON-EXISTENT");
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay solicitudes con ese status")
        void shouldReturnEmptyListWhenNoRequestsWithStatus() {
            when(persistencePort.findByStatus("NON-EXISTENT-STATUS")).thenReturn(Arrays.asList());

            List<ClientRequest> result = clientRequestService.getRequestsByStatus("NON-EXISTENT-STATUS");

            assertThat(result).isEmpty();

            verify(persistencePort, times(1)).findByStatus("NON-EXISTENT-STATUS");
        }
    }

    @Nested
    @DisplayName("Integration Tests - Multiple Operations")
    class IntegrationTests {

        @Test
        @DisplayName("Debe crear, buscar y actualizar solicitud en secuencia")
        void shouldCreateFindAndUpdateRequestInSequence() {
            ClientRequest newRequest = new ClientRequest(
                null,
                sampleClientId,
                "Integration test request",
                "PENDING",
                null,
                null
            );

            UUID createdId = UUID.randomUUID();
            ClientRequest savedRequest = new ClientRequest(
                createdId,
                sampleClientId,
                "Integration test request",
                "PENDING",
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
            );

            when(persistencePort.save(any(ClientRequest.class))).thenReturn(savedRequest);
            when(persistencePort.findById(createdId)).thenReturn(Optional.of(savedRequest));

            ClientRequest created = clientRequestService.createRequest(newRequest);
            Optional<ClientRequest> found = clientRequestService.getRequestById(created.id());
            ClientRequest updated = clientRequestService.updateRequestStatus(created.id(), "COMPLETED");

            assertThat(created.id()).isEqualTo(createdId);
            assertThat(found).isPresent();
            assertThat(found.get().status()).isEqualTo("PENDING");
            assertThat(updated.status()).isEqualTo("COMPLETED");

            verify(persistencePort, times(1)).save(any(ClientRequest.class));
            verify(persistencePort, times(1)).findById(createdId);
            verify(persistencePort, times(2)).save(any(ClientRequest.class));
        }
    }
}
```
