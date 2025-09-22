# CDFInsight-MVP 🚀

**Minimum Viable Product para procesamiento asíncrono de documentos XML con arquitectura enterprise**

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.x-orange.svg)
![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue.svg)

## 📋 Descripción del Proyecto

CDFInsight-MVP es una aplicación web monolítica desarrollada en Spring Boot 3 que permite el procesamiento asíncrono de documentos XML con transformación a JSON en tiempo real. Este proyecto sirve como base tecnológica para futuros desarrollos de sistemas de procesamiento de documentos fiscales (CDF - Comprobantes de Documentos Fiscales).

### Objetivos del MVP
- Establecer arquitectura base para procesamiento asíncrono
- Implementar comunicación en tiempo real con WebSockets
- Validar patrones de Message Queue con RabbitMQ
- Crear fundamentos para escalabilidad enterprise

## 🎯 Casos de Uso

### Funcionalidades Principales
1. **Carga de documentos XML**
   - Upload de archivos `.xml`
   - Input manual via textarea
   - Procesamiento por lotes

2. **Transformación asíncrona**
   - Conversión XML → JSON
   - Procesamiento en background workers
   - Simulación de delay para UX realista

3. **Comunicación tiempo real**
   - Feedback instantáneo al usuario
   - Estado de procesamiento en vivo
   - Entrega de resultados automática

## 🏗️ Arquitectura

### Stack Tecnológico
- **Backend Framework**: Spring Boot 3.x
- **Message Broker**: RabbitMQ (AMQP)
- **Real-time Communication**: WebSocket + STOMP
- **XML Processing**: Jackson XML Mapper
- **Frontend**: Thymeleaf + Vanilla JavaScript
- **Build Tool**: Maven
- **Java Version**: 17+

### Flujo de la Aplicación
```
📁 Usuario → 🌐 WebSocket → 📨 RabbitMQ Queue → ⚙️ Worker → 🔄 JSON → 🌐 WebSocket → 👤 Usuario
```

### Componentes Principales
- **XmlController**: Manejo de WebSocket endpoints
- **XmlProducer**: Publicación de mensajes a RabbitMQ
- **XmlConsumer**: Procesamiento asíncrono de documentos
- **XmlEventHandler**: Gestión de eventos y notificaciones

## 🚀 Inicio Rápido

### Prerrequisitos
- Java 17+
- Maven 3.8+
- Docker (para RabbitMQ)
- IDE preferido (IntelliJ IDEA recomendado)

### Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/tu-equipo/cdfinsight-mvp.git
cd cdfinsight-mvp
```

2. **Levantar RabbitMQ**
```bash
docker run -d --name rabbitmq-cdf \
  -p 5672:5672 \
  -p 15672:15672 \
  rabbitmq:3-management
```

3. **Configurar properties**
```bash
cp src/main/resources/application-template.properties src/main/resources/application.properties
# Ajustar configuraciones según entorno
```

4. **Ejecutar la aplicación**
```bash
mvn spring-boot:run
```

### Acceso a la Aplicación
- **Aplicación Web**: http://localhost:8080
- **RabbitMQ Management**: http://localhost:15672 (guest/guest)
- **Health Check**: http://localhost:8080/actuator/health

## 🔧 Configuración

### Variables de Entorno Principales
```properties
# WebSocket Configuration
xml.ws.endpoint=/stomp
xml.ws.broker=/topic
xml.ws.app=/app

# RabbitMQ Configuration
xml.amqp.host=localhost
xml.amqp.port=5672
xml.amqp.queue=xml.processing.queue

# Processing Configuration
xml.processing.delay=5000
xml.processing.max-file-size=10MB
```

### Perfiles Disponibles
- **development** (`application-dev.properties`): Configuración local
- **testing** (`application-test.properties`): Entorno de pruebas
- **production** (`application-prod.properties`): Configuración productiva

## 📊 Ejemplos de Uso

### Documento XML de Entrada
```xml
<?xml version="1.0" encoding="UTF-8"?>
<comprobante>
    <emisor>
        <nombre>Empresa Demo S.A. de C.V.</nombre>
        <rfc>EMP123456789</rfc>
    </emisor>
    <total>1500.00</total>
    <moneda>MXN</moneda>
</comprobante>
```

### JSON de Salida
```json
{
  "comprobante": {
    "emisor": {
      "nombre": "Empresa Demo S.A. de C.V.",
      "rfc": "EMP123456789"
    },
    "total": "1500.00",
    "moneda": "MXN"
  }
}
```

## 🧪 Testing

### Ejecutar pruebas
```bash
# Todas las pruebas
mvn test

# Pruebas de integración
mvn test -Dtest="*IntegrationTest"

# Pruebas con Testcontainers
mvn test -Dspring.profiles.active=test
```

### Cobertura de Código
```bash
mvn jacoco:report
# Ver reporte en: target/site/jacoco/index.html
```

## 📈 Métricas y Monitoreo

### Endpoints de Actuator
- `/actuator/health` - Estado de la aplicación
- `/actuator/metrics` - Métricas de rendimiento
- `/actuator/info` - Información del build
- `/actuator/rabbitmq` - Estado de RabbitMQ

### Logging
- **Nivel de desarrollo**: DEBUG
- **Nivel de producción**: INFO
- **Formato**: JSON estructurado para agregación

## 🔮 Roadmap Futuro

### Fase 2: Validación y Persistencia
- [ ] Validación XSD para documentos fiscales
- [ ] Integración con MongoDB/PostgreSQL
- [ ] Historial de procesamiento
- [ ] API REST complementaria

### Fase 3: Seguridad y Multiusuario
- [ ] Autenticación JWT
- [ ] Autorización por roles
- [ ] Sesiones de usuario independientes
- [ ] Auditoría de operaciones

### Fase 4: Escalabilidad
- [ ] Microservicios architecture
- [ ] Kubernetes deployment
- [ ] Load balancing
- [ ] Caching con Redis

### Fase 5: Business Logic
- [ ] Cálculos fiscales automáticos
- [ ] Integración con SAT
- [ ] Reportería avanzada
- [ ] Dashboard analytics

## 👥 Equipo de Desarrollo

### Contributors
- **[Nombre 1]** - Backend Developer & Architecture
- **[Nombre 2]** - Frontend Developer & UX
- **[Nombre 3]** - DevOps & Infrastructure

### Metodología
- **Scrum** con sprints de 2 semanas
- **Git Flow** para versionado
- **Code Review** obligatorio
- **CI/CD** con GitHub Actions

## 📚 Documentación Técnica

### APIs y Endpoints
- [WebSocket API Documentation](docs/websocket-api.md)
- [RabbitMQ Queue Configuration](docs/rabbitmq-setup.md)
- [XML Processing Patterns](docs/xml-processing.md)

### Guías de Desarrollo
- [Coding Standards](docs/coding-standards.md)
- [Testing Guidelines](docs/testing-guide.md)
- [Deployment Guide](docs/deployment.md)

## 🤝 Contribución

### Proceso de Contribución
1. Fork del repositorio
2. Crear feature branch (`git checkout -b feature/nueva-funcionalidad`)
3. Commit con mensaje descriptivo
4. Push al branch (`git push origin feature/nueva-funcionalidad`)
5. Crear Pull Request

### Estándares de Código
- Seguir Google Java Style Guide
- Cobertura de pruebas mínima: 80%
- Documentación JavaDoc en métodos públicos
- Validación SonarQube clean

## 📄 Licencia

Este proyecto es de uso interno del equipo para fines educativos y de desarrollo profesional.

## 🆘 Soporte

Para dudas técnicas o reportar issues:
- **GitHub Issues**: [Crear nuevo issue](https://github.com/tu-equipo/cdfinsight-mvp/issues)
- **Slack**: `#cdfinsight-mvp` channel
- **Email**: equipo-desarrollo@empresa.com

---

**CDFInsight-MVP** - Construyendo el futuro del procesamiento de documentos fiscales 🚀