# Implementación de un microservicio con enrutamiento, logs y persistencia

La empresa necesita un microservicio que maneje solicitudes de clientes, registre los eventos en logs, y persista la información en una base de datos utilizando un ORM. El microservicio debe ser capaz de enrutar las solicitudes según las variables de entorno y garantizar la trazabilidad de las operaciones.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Experiencia en Frameworks |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del entorno y enrutamiento de solicitudes

**Objetivo:** Configurar el entorno del microservicio y enrutar las solicitudes según las variables de entorno.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura el entorno del microservicio para que pueda recibir solicitudes.
- Implementa el enrutamiento de solicitudes basado en las variables de entorno.

**Entregable:** Entorno del microservicio configurado y solicitudes enrutadas según las variables de entorno.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las mejores prácticas para configurar el entorno de un microservicio.
- Piensa en cómo las variables de entorno pueden influir en el comportamiento del microservicio.

</details>

### Fase 2: Generación de logs y trazabilidad

**Objetivo:** Implementar la generación de logs para registrar los eventos del microservicio y garantizar la trazabilidad de las operaciones.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa la generación de logs para registrar los eventos del microservicio.
- Asegura que los logs incluyan información relevante para la trazabilidad de las operaciones.

**Entregable:** Logs generados que registran los eventos del microservicio y permiten la trazabilidad de las operaciones.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los niveles de logs y cómo afectan la información registrada.
- Piensa en la importancia de la trazabilidad en un microservicio.

</details>

### Fase 3: Persistencia de datos con ORM

**Objetivo:** Implementar la persistencia de datos utilizando un ORM y asegurar la consistencia de los datos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa la persistencia de datos utilizando un ORM.
- Asegura que los datos persistidos sean consistentes y estén disponibles para futuras consultas.

**Entregable:** Datos persistidos utilizando un ORM, asegurando la consistencia y disponibilidad.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las ventajas y desventajas de diferentes ORMs.
- Piensa en cómo garantizar la consistencia de los datos al persistirlos.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un microservicio y por qué es importante en este contexto?
- **paraQueSirve**: ¿Para qué sirve el enrutamiento de solicitudes en un microservicio?
- **comoSeUsa**: ¿Cómo se usa un ORM para persistir datos en un microservicio?
- **erroresComunes**: ¿Cuáles son los errores comunes al generar logs y cómo los evitas?
- **queDecisionesImplica**: ¿Qué decisiones implica la elección de un ORM y cómo afecta al microservicio?

## Criterios de Evaluacion

- Configuración correcta del entorno del microservicio.
- Enrutamiento de solicitudes según las variables de entorno.
- Generación de logs que registran los eventos y permiten la trazabilidad.
- Persistencia de datos utilizando un ORM con consistencia y disponibilidad.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
