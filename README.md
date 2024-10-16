# Documentación del Repositorio PatronBridge

## Explicación del profe

Permite mantener más objetos dentro de la cantidad disponible de RAM compartiendo las partes comunes del estado entre varios objetos en lugar de mantener toda la información en cada objeto.

La idea es que podamos utilizar objetos utilizados en otras instancias para ahorrar espacio.

El patrón es importante porque el ahorro de recursos es primordial, ya que elimina recursos repetidos.

El patrón me ayuda a no crear objetos iguales que saturen la memoria.

El patrón centra su estarategia en dividir los objetos en dos partes:

- Estado Intrínseco: Partes del objeto que se repiten y muchos objetos tienen en común.
- Estaddo Extrínseco: Parte única de cada objeto que es distinta a todas las demás por lo que no es candidata a ser reutilizada o compartida.

NOTA: Flyweight se apoya en factory method.

-> Problema en el caso de los videojuegos.

- El jeugo se daña porque hay demasiadas partículas (balas de metralladoras, objetos, etc)
- Las particulas guardan información identica como color, pero también información diferente como coordenadas.

La idea es que no almacenemos el estado extrínseco dentro del objeto en cambio que reutilicemos los estados intrínsecos.
