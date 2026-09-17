# proyecto-biblioteca

## Integrantes

* Miguel Ángel Abril
* Brandol Andrés Gómez
* Karen Liseth Gutiérrez

# Sistema de Gestión de Biblioteca

Este proyecto consiste en un sistema de gestión de biblioteca desarrollado en Java. El objetivo es permitir el registro y la administración de libros mediante una interfaz sencilla.

El proyecto fue desarrollado como parte del proceso formativo del SENA, aplicando conceptos de Programación Orientada a Objetos (POO), estructuras de datos, interfaz gráfica y control de versiones con Git y GitHub.

El objetivo era crear un sistema que permitiera gestionar los libros de una biblioteca de manera organizada, facilitando su creación, consulta, filtrado y eliminación.

## Funcionalidades

El sistema está diseñado para permitir:

* Crear y registrar libros.
* Registrar título, autor, código, género, año de publicación y copias disponibles.
* Validar que los campos estén llenos.
* Validar que el año y las copias sean valores numéricos.
* No permitir códigos de libros repetidos.
* Mostrar los libros registrados en una tabla.
* Filtrar libros por autor.
* Eliminar libros solicitando una confirmación antes de realizar la acción.

## Tecnologías y herramientas utilizadas

En la creación de este sistema utilizamos:

* Java.
* Java Swing para la interfaz gráfica.
* IntelliJ IDEA como entorno de desarrollo.
* Git para el control de versiones.
* GitHub para el trabajo colaborativo.

## Estructura del proyecto

Para el proyecto utilizamos una estructura con cuatro clases:

* `Libros.java`
* `Biblioteca.java`
* `VentanaPrincipal.java`
* `Main.java`

### Libros.java

Esta clase representa los libros del sistema y contiene los siguientes atributos:

* Título.
* Autor.
* Código.
* Género.
* Año de publicación.
* Copias disponibles.

La clase utiliza atributos privados y métodos getters y setters para aplicar el concepto de encapsulamiento.

### Biblioteca.java

Esta clase se encarga de administrar los libros registrados y utiliza diferentes estructuras de datos:

* **ArrayList:** para almacenar los libros.
* **HashMap:** para organizar los libros por autor.
* **HashSet:** para evitar códigos repetidos.

### VentanaPrincipal.java

Contiene la interfaz gráfica del sistema utilizando componentes de Java Swing:

* `JFrame`
* `JPanel`
* `JTextField`
* `JButton`
* `JTable`
* `JScrollPane`
* `JOptionPane`

### Main.java

Es la clase principal desde donde se ejecuta la aplicación y se abre la ventana principal del sistema.

## Registro de libros

El sistema cuenta con un formulario para registrar libros con los siguientes campos:

* Título.
* Autor.
* Código.
* Género.
* Año de publicación.
* Copias disponibles.

Además, tiene una tabla para visualizar los libros registrados y botones para realizar diferentes acciones con ellos.

## Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Abrir `Main.java`.
3. Ejecutar el método `main`.
4. Se abrirá la ventana principal del sistema.

## Uso de la IA

Cada integrante utilizó la inteligencia artificial como apoyo de diferentes maneras durante el desarrollo del proyecto.

Karen: La utilizó como apoyo para organizar la interfaz y para recibir explicaciones sobre su funcionamiento.

Brandol: La utilizó como apoyo para investigar cómo iban quedando los códigos y qué elementos se podían agregar a los métodos que ya estaban estructurados.

Miguel: La utilizó como apoyo para investigar más sobre `HashMap` y `HashSet`, ya que no tenía completamente claros estos conceptos.
