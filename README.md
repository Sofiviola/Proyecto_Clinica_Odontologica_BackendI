# Proyecto_Clinica_Odontologica_BackendI
## Trabajo integrador Backend I:
### Sistema de reserva de turnos
Se desea implementar un sistema que permita administrar la reserva de turnos para una clínica odontológica. Los requerimientos que debe cumplir son los siguientes:

- Administración de datos de odontólogos: Listar, Agregar, Modificar y Eliminar odontólogos. Registrar apellido, nombre y matrícula de los mismos.
- Administración de datos de los pacientes: Listar, Agregar, Modificar y Eliminar pacientes. De cada uno se almacenan: nombre, apellido, domicilio, DNI y fecha de alta.
- Registrar turno: Se tiene que poder permitir asignar a un paciente un turno con un odontólogo a una determinada fecha y hora. 
- Login: Validar el ingreso al sistema mediante un login con usuario y password. Permitiendo a cualquier usuario logueado (ROLE_USER)  registrar un turno pero solo a quienes tengan un rol de administración (ROLE_ADMIN) poder gestionar odontólogos y pacientes. Un usuario podrá tener un solo rol y los mismos se ingresarán directamente en la base de datos.

### Requerimientos técnicos
La aplicación debe ser desarrollada en capas:
* Capa de entidades de negocio (Model): Son las clases Java de nuestro negocio modelado a través del paradigma orientado a objetos.
* Capa de acceso a datos (Repository): Son las clases que se encargaran de acceder a la base de datos.
* Capa de Datos (base de datos): Es la base de datos de nuestro sistema modelado a través de un modelo entidad-relación. Utilizaremos la base H2 por su practicidad. 
* Capa de negocio(Service): Son las clases service que se encargan de desacoplar el acceso a datos de la vista.
* Capa de presentación(Controller): Son las pantallas web que tendremos que desarrollar utilizando el framework de Spring boot MVC con los controladores: HTML + JavaScript.
