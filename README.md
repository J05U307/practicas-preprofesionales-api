# 🏫 Sistema de Gestión de Prácticas Preprofesionales – Backend

API REST desarrollada con **Java 17 + Spring Boot** para gestionar el proceso completo de prácticas preprofesionales dentro de una institución universitaria.

El sistema permite administrar estudiantes, empresas, convenios, supervisores, cartas de presentación, informes y el proceso de aprobación, además de manejar autenticación con **JWT**.

---

## 🚀 Tecnologías y herramientas utilizadas
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (JWT)
- Maven
- MySQL / Oracle
- Modelo en capas: Controller – Service – Repository

---

## 🔐 Autenticación y Seguridad
El backend implementa:
- Login con usuario/contraseña
- Generación de JWT
- Filtros de autorización
- Roles y permisos (ADMIN, ESTUDIANTE, SUPERVISOR, etc.)

---

## 📦 Módulos principales del sistema

### 👨‍🎓 Estudiantes
- Registro de datos personales
- Estado de práctica
- Documentos enviados

### 🏢 Empresas
- Registro de empresas externas
- Contactos y convenios

### 📄 Documentos
- Cartas de presentación
- Informes parciales
- Informe final
- Seguimiento de revisiones

### 🧑‍🏫 Supervisores
- Asignación de supervisor
- Observaciones del proceso
- Aprobaciones

### 🔐 Seguridad
- Login
- Token JWT
- Protección de rutas  


👨‍💻 Autor

Josue Cusquisiban
