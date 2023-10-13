Sistema de gestion de tareas 

Se desarrollo una API REST para la gestion de tareas o actividades con Spring Boot y empleando una DB en memoria H2. Se diseno una interfaz funcional para gestionar las operaciones de creacion, actualizacion de estados y eleiminacion de actividades empleando la libreria de Reactjs.


Herramientas

- Java 11

- SpringBoot

- H2

- Maven

- Swagger2

- Reactjs


Para instalar

Clonamos o desacargamos el repositorio git clone https://github.com/thenoise2000/TasksManagement
Dirijase a la raiz del proyecto: cd ApiTasks
Compilamos: mvn clean install
Ejecutamos mvn spring-boot:run

Para comprobar que la app esta funcionando correctamente dirijase a la direccion web:
http://localhost:8080/swagger-ui/#/


Para desplegarlo ejecute

comando
  mvn spring-boot:run
  
- Frontend 

Para desplegar el Frontend descargue e instale Nodejs 

Vaya a la raiz de la carpeta FrontTasks y ejecute el comando npm install

a continuacion ejecute el comando npm run dev

vaya a localhost:3000 para realizar las operaciones 


