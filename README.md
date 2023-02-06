#                   TIPOS DE NAVES


## Descripción de la aplicación

Esta es una aplicación en la cual puedes interactuar con cuatro tipos de naves, que son las siguientes.

### Nave Lazandera

Esta es un tipo de nave cohete autopropulsado que sirve para lanzar una carga util al espacio, como por ejemplo un satélite una sonda o una nave tripulada.

En este proyecto cumple las siguientes funciones:

- > Iniciar su despegue
- > Lanzar la carga al espacio

### Nave Tripulada

Esta nave consiste en mandar seres humanos al espacio para tareas de reparación, mantenimiento o investigación.

Sus funciones dentro del proyecto son las siguientes:

- > Definir destino
- > Despegar
- > Orbitar
- > Transportar pasajeros
- > Aterrizar

### Nave no Tripulada

El principal objetivo de esta nave es estudiar otros cuerpos celestes.

Sus funciones principales serán:

- > Definir destino
- > Orbitar
- > Abastecer
- > Investigar
- > Capturar Imagenes

### Nave de Combate

Son naves que se utilizan para defender y colonizar planetas "protegernos del enemigo".

Sus funciones principales en este proyecto serán:

- > Definir destino
- > Despegar
- > Orbitar
- > Transporte de pasajeros
- > Defender
- > Atacar
- > Retirada
- > Aterrizar

### Nave de Rescate

Están destinadas al rescate de personas que estén en peligro.

Sus funciones en el proyecto serán las siguientes:

- > Despegar
- > Definir destino
- > Orbitar
- > Transporte de pasajeros
- > Curación de heridos
- > Aterrizar


## La aplicación te va a permitir realizar las siguientes funciones:

Contara con un menu que te permite realizar tres acciones principales:

###  Crear nave

Me permite seleccionar un tipo de nave a crear, y con base en el tipo me va a pedir que ingrese una información de acuerdo a este tipo.

###  Listar nave

Me permite ver un inventario de las naves que tengo y en caso de querer seleccionar una, me permitirá usar las funciones con las que cuenta esta.

###  Consultar nave

Esta parte contiene un menu para consultas simples especificando las opciones de buscar por tipo, nombre y pais.

###  Salir del programa

Esta opción te permite cerrar el programa

## Consideraciones para correr la aplicación

Para descargar el proyecto debemos hacer un 
> git clone  https://github.com/alejancarvajal/tipos-de-naves.git 


Hay dos formas de iniciar la aplicación, la primera usando una base de datos postgres y la segunda es usando un base de datos h2.

#### POSTGRES
>
> - Debemos descargar e instalar la version de postgres 11 
> - Configurar en esta el nombre de 
>      > usuario: postgres y la contraseña: Aleja2021 
> - Crear una base de datos llamada: 
>    >proyecto_naves
>
> - Nos debemos fijar que en el application.properties se encuentre la siguiente propiedad
>   > spring.profiles.active=dev
 - De esta forma activamos la lectura de las propiedades de dev que tiene toda la configuración de postgres del proyecto.

#### H2
>
> - Para esta base de datos solo necesitamos fijarnos en el application.properties que la propiedad sea 
>   >spring.profiles.active=h2

### Documentación de API

Para la documentación de los servicios que exponemos se agregó un SWAGGER con el siguiente link de acceso:
> http://localhost:8090/tipos-de-naves/api/swagger-ui/index.html#/  

  




