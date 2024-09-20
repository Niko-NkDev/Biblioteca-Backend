# Proyecto: [Biblioteca-Backend]

## Descripción

La aplicación "Biblioteca Backend" es una solución para la gestión de libros y autores, diseñada para permitir la administración eficiente de una biblioteca. A través de una API REST desarrollada en Java y utilizando una base de datos MySQL, la aplicación permite realizar operaciones como la creación, actualización, eliminación y consulta de registros de libros y autores. El propósito principal de esta aplicación es proporcionar un sistema robusto y escalable que facilite la organización y el acceso a la información bibliográfica en una biblioteca o cualquier entorno similar.

## Requisitos

Antes de comenzar, asegúrate de tener instaladas las siguientes dependencias en tu máquina:

- **Java Development Kit (JDK)** 11 o superior.
- **Apache Maven** 3.6.0 o superior.
- **Docker** (si la aplicación se despliega con contenedores).
- **Git** (para clonar el repositorio).

## Instalación

### 1. Clonar el Repositorio

Primero, clona el repositorio desde GitHub:


git clone https://github.com/Niko-NkDev/Biblioteca-Backend.git

cd Biblioteca-Backend


# Biblioteca Backend Application

Este proyecto es una aplicación para la gestión de libros y autores. Incluye una API REST desarrollada en Java con Maven, y una base de datos MySQL.

## Crear Imagen Docker de la Aplicación

### 1. Crear el ejecutable del proyecto
Ejecuta el siguiente comando en la terminal para generar el archivo `.jar` de la aplicación:


- mvn clean install -DskipTests

### 2. Crear el Dockerfile

Asegúrate de estar en la raíz del proyecto y crea un archivo llamado Dockerfile con el siguiente contenido:

# Usar una imagen base de OpenJDK
- FROM openjdk:17-jdk-slim

- VOLUME /tmp

- EXPOSE 8080

- ADD ./target/biblioteca-0.0.1-SNAPSHOT.jar biblioteca.jar

- ENTRYPOINT ["java", "-jar", "/biblioteca.jar"]

### 3. Construir la imagen Docker

Ejecuta el siguiente comando para construir la imagen Docker de la aplicación:

- docker build -t biblioteca:1.0 .

### 4. Verificar la creación de la imagen

Para asegurarte de que la imagen se creó correctamente, ejecuta:

- docker images

Debes ver un resultado similar a:

REPOSITORY   TAG       IMAGE ID       CREATED         SIZE

biblioteca   1.0       693ec956bf8d   3 minutes ago   455MB


### 5. Crear un contenedor Docker

Para ejecutar la aplicación dentro de un contenedor Docker, usa el siguiente comando:

- docker run --net=host -p 8080:8080 1e2973221774

(Reemplaza 1e2973221774 con el ID de la imagen que obtuviste en el paso anterior.)


## Crear Imagen Docker de MySQL

### 1. Descargar la imagen de MySQL

Ejecuta el siguiente comando para descargar la imagen de MySQL desde Docker Hub:

- docker pull mysql

### 2. Crear el contenedor MySQL

Crea un contenedor Docker para MySQL usando el siguiente comando:

- docker run --name bd_biblioteca -e MYSQL_ROOT_PASSWORD=n1c0l4s123 -d mysql

### 3. Verificar los contenedores en ejecución

Lista los contenedores activos con:

- docker ps -a

### 4. Conectarse a la consola de MySQL

Para conectarte a MySQL desde el contenedor, primero inspecciona la IP del contenedor y luego ejecuta:

- mysql -u root -h 172.17.0.2 -pn1c0l4s123


### Crear la base de datos

Dentro de la consola de MySQL, crea la base de datos necesaria para la aplicación:

create database db_biblioteca;

### Colección para Probar los Servicios REST

Para facilitar la prueba de los servicios REST de Autores y Libros, se ha incluido una colección de Postman en el proyecto:

-  REST API biblioteca.postman_collection

Importa esta colección en Postman y podrás consumir fácilmente los servicios expuestos por la API.


Este archivo `README.md` ofrece una guía paso a paso para crear las imágenes Docker y configurar el entorno necesario para la aplicación y la base de datos MySQL.
