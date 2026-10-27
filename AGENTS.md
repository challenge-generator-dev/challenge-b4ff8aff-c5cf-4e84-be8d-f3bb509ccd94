# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de un microservicio con enrutamiento, logs y persistencia**.

| | |
|---|---|
| Tema | Experiencia en Frameworks |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.postgresql:postgresql 42.7.3
- ch.qos.logback:logback-classic 1.5.6
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-aop n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.junit.jupiter:junit-jupiter-api 5.10.2
- org.mockito:mockito-core 5.11.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración del entorno y enrutamiento de solicitudes**: Entorno del microservicio configurado y solicitudes enrutadas según las variables de entorno.
- **Fase 2 — Generación de logs y trazabilidad**: Logs generados que registran los eventos del microservicio y permiten la trazabilidad de las operaciones.
- **Fase 3 — Persistencia de datos con ORM**: Datos persistidos utilizando un ORM, asegurando la consistencia y disponibilidad.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (43)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/microservice/Application.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/microservice/infrastructure/config/RouterConfig.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/microservice/infrastructure/config/LoggingAspect.java` — `org.aspectj.lang`
      El import org.aspectj.lang.JoinPoint pertenece a org.aspectj.lang, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/microservice/infrastructure/config/LoggingAspect.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.clientId`
      Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.requestType`
      Se invoca `requestType` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.description`
      Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.metadata`
      Se invoca `metadata` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.requestId`
      Se invoca `requestId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/application/usecase/ClientRequestService.java` — `ClientRequest.status`
      Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.requestId`
      Se invoca `requestId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.save`
      Se invoca `save` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestEntity.getRequestId`
      Se invoca `getRequestId` sobre `ClientRequestEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.findById`
      Se invoca `findById` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.findAll`
      Se invoca `findAll` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestRepository.deleteById`
      Se invoca `deleteById` sobre `ClientRequestRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequestEntity.setRequestId`
      Se invoca `setRequestId` sobre `ClientRequestEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.clientId`
      Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.requestType`
      Se invoca `requestType` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.description`
      Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.status`
      Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.createdAt`
      Se invoca `createdAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.updatedAt`
      Se invoca `updatedAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java` — `ClientRequest.metadata`
      Se invoca `metadata` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.id`
      Se invoca `id` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.clientId`
      Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.status`
      Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.description`
      Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.requestType`
      Se invoca `requestType` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.metadata`
      Se invoca `metadata` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.createdAt`
      Se invoca `createdAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java` — `ClientRequest.updatedAt`
      Se invoca `updatedAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java` — `ClientRequest.clientId`
      Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java` — `ClientRequest.id`
      Se invoca `id` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.id`
      Se invoca `id` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.clientId`
      Se invoca `clientId` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.status`
      Se invoca `status` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.get`
      Se invoca `get` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.description`
      Se invoca `description` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java` — `ClientRequest.createdAt`
      Se invoca `createdAt` sobre `ClientRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (15)

- `pom.xml`
- `src/main/java/com/microservice/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/microservice/domain/model/ClientRequest.java`
- `src/main/java/com/microservice/domain/ports/in/ClientRequestUseCase.java`
- `src/main/java/com/microservice/domain/ports/out/ClientRequestPersistencePort.java`
- `src/main/java/com/microservice/infrastructure/persistence/repository/ClientRequestRepository.java`
- `src/main/java/com/microservice/application/usecase/ClientRequestService.java`
- `src/main/java/com/microservice/infrastructure/persistence/adapter/ClientRequestJpaAdapter.java`
- `src/main/java/com/microservice/infrastructure/persistence/entity/ClientRequestEntity.java`
- `src/main/java/com/microservice/infrastructure/web/controller/ClientRequestController.java`
- `src/main/java/com/microservice/infrastructure/config/RouterConfig.java`
- `src/main/java/com/microservice/infrastructure/config/LoggingAspect.java`
- `src/main/resources/logback-spring.xml`
- `src/test/java/com/microservice/application/usecase/ClientRequestServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/microservice`
- `src/main/java/com/microservice/application`
- `src/main/java/com/microservice/domain`
- `src/main/java/com/microservice/infrastructure`
- `src/main/java/com/microservice/infrastructure/config`
- `src/main/java/com/microservice/infrastructure/persistence`
- `src/main/java/com/microservice/infrastructure/web`
- `src/main/resources`
- `src/test/java/com/microservice`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Experiencia comprobable en al menos un marco de trabajo (Framework) en su lenguaje de programación principal (por ejemplo, Spring Framework en Java o ASP .net core en C#) y puede realizar el enrutamiento de solicitudes, controlar las variables de entorno, generar registros de rastros (Logs) y conectarse con bases de datos utilizando un Mapeador Relacional de Objetos (ORM).
- Mision: El candidato es un desarrollador Backend Advanced con experiencia en estructuras de datos y patrones GRASP. Está listo para profundizar en frameworks como Spring Boot.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
