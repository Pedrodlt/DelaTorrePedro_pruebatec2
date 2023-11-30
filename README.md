# DelaTorrePedro_pruebatec2
Desarrollo de una Aplicación de Gestión de Turnos
El objetivo de esta prueba es evaluar tus conocimientos en Java y Java Web, incluyendo sintaxis, estructuras repetitivas, estructuras selectivas, manejo de colecciones y operaciones CRUD (Crear, Leer, Actualizar y Borrar) utilizando JPA (Java Persistence API)  para interactuar con una base de datos, JSP para interactuar con el usuario y programación funcional como complemento.

Pasos para ejecutar la aplicación:
- Clonar el repositorio.
- Ejecutar en un IDE preferido para Java.
- Será necesario tener una BBDD con el nombre "turnero" en un gestor de Base de datos, en este caso MySQL.
- URL: jdbc:mysql://localhost:3306/turnero?serverTimezone=UTC
- USER: Root
- PASSWORD: 898989
- En caso de no utilizar estas credenciales, se deberá modificar en el archivo persistence.xml y actualizar los datos.
Una vez codificada la Base de datos, ejecutar la aplicación completa.
*Como extra, se ha añadido en la carpeta resources los archivos SQL con las tablas turnero_ciudadano y turnero_turno ya rellenas con datos*

## Uso de la aplicación: 
- Una vez ejecutada la aplicación, elegir una de las opciones del menú lateral.
- Se podrá Crear un nuevo ciudadano, Listar los ciudadanos existentes, Registrar un nuevo turno, Listar todos los turnos, Buscar turnos filtrados por fecha y Buscar turnos filtrados por fecha y por estado.
- Una vez creado un usuario (en caso de que el DNI ya exista, no dejará continuar y saltará un mensaje de error), se puede pasar a Registrar un nuevo turno.
- **Registar nuevo turno:** se deberán introducir cada uno de los datos del formulario, si hay datos vacíos no dejará continuar. En caso de que el número de turno ya exista, saltará un mensaje de error. En caso de que el Id del Ciudadano no exista, saltará un mensaje de error.
- **Filtrar turnos por fecha:** se deberá introducir una fecha y la aplicación filtrará los turnos existentes para el día introducido, pudiendo ver un listado de ellos. En este listado se podrán ver los turnos para el día introducido, tanto los que están en estado "En espera" como los "Ya atendidos".
- **Filtrar turnos por fecha y estado:** se deberá introducir una fecha, en caso de no introducirla, la aplicación no dejará continuar. Una vez introducida la fecha y el estado, se mostrará un listado de los turnos.
- Tanto en el listado de Todos los turnos, como en los listados de Filtrados por fecha y Filtrados por fecha + estado, se podrá editar el turno. Al seleccionar la opción de "Editar", la aplicación nos redigirá al formulario de edición, donde aparecerán los datos del turno en cuestión, y se podrá cambiar el estado de "En espera" a "Ya atendidos". Una vez realizado el cambio, nos redigiremos al listado de Todos los turnos para comprobar que el cambio de estado se ha realizado correctamente.
