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

## Descripción

El repositorio PatronBridge implementa el patrón de diseño Bridge en Java. Este patrón permite separar la abstracción de su implementación, de modo que ambos puedan variar de forma independiente. En este caso, se aplica para el proceso de encriptación de mensajes, ofreciendo diferentes algoritmos de encriptación como AES, DES y Base64, además de la opción de no encriptar.

## Problema en particular

El problema es que queremos tener la capacidad de encriptar mensajes usando diferentes algoritmos (AES, DES, Base64, o sin encriptación). Sin embargo, si creamos una clase para cada combinación de mensajes y algoritmos de encriptación, terminaríamos con muchas clases. Por ejemplo:

    MensajeAES
    MensajeDES
    MensajeBase64
    MensajeSinEncriptar

Esto se vuelve difícil de escalar, especialmente si en el futuro se agregan más tipos de mensajes o más algoritmos de encriptación. Aquí es donde entra el patrón Bridge.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- Las clases de encriptación son la implementación del proceso de encriptación en particular, aquí está la interface Encriptar que contiene el método que por obligación debe ser implementado en cada una de las clases del proceso de encriptación.

- Las clases de la carpeta implementación, contienen la interfaz del puente y el puente (lo cual es extraño porque existe un sólo puente y esta interfaz tal vez debería existir es para los diferentes tipos de mensajes que puedan haber). el puente como tal, recibiendo el mensaje y la clase de implementación pero haciendo uso del método de desencriptación de cada una de estas clases.

- Finalmente el main en patronbridge, contiene la ejecución del programa y los test.

## Ejemplo de Uso

En el archivo `PatronBridgeMain.java`, se crea una instancia de `PuenteMensajeEncriptacion` para cada tipo de encriptación soportada y luego se encripta un mensaje de ejemplo con cada una:

```java
public static void main(String[] args) {
    InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());
    InterfaceMensajeEncriptacion FormatoDES = new PuenteMensajeEncriptacion(new ProcesoEncriptarDES());
    InterfaceMensajeEncriptacion FormatoBase64 = new PuenteMensajeEncriptacion(new ProcesoEncriptarBase64());
    InterfaceMensajeEncriptacion SinFormato = new PuenteMensajeEncriptacion(new ProcesoSinEncriptar());

    try {
        final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
        String messageAES = FormatoAES.EncryptarMensaje(message, "HG58YZ3CR9123456");
        System.out.println("Formato AES > " + messageAES + "\n");

        String messageDES = FormatoDES.EncryptarMensaje(message, "XMzDdG4D03CKm2Ix");
        System.out.println("Formato DES > " + messageDES + "\n");

        String messageBase64 = FormatoBase64.EncryptarMensaje(message, null);
        System.out.println("Formato Base64 > " + messageBase64 + "\n");

        String messageNO = SinFormato.EncryptarMensaje(message, null);
        System.out.println("Sin Formato > " + messageNO + "\n");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

```

## Conclusión
El repositorio PatronBridge es un ejemplo práctico de cómo implementar el patrón de diseño Bridge en Java para separar la abstracción de la implementación en el contexto de la encriptación de mensajes. Permite la fácil extensión del sistema para soportar nuevos algoritmos de encriptación sin modificar el código cliente.

## Mi entendimiento personal

El patrón bridge es un método creativo para disminuir la cantidad de clases que se utilizarían pensando el código con fuerza bruta, crea un intermediario que disminuye sustancialmente la cantidad de clases necesarias para que el código funcione y además hace que sea mucho más fácil de leer y entender.

Por ejemplo en una clase que implique 6 escenarios abstractos y 6 escenarios específicos, habría que implementar 36 clases para resolver el problema sin usar este patrón, con este patrón sólo se deben implementar 13 clases, las 6 abstractas, los escenarios específicos y el bridge que las conecta.

Aunque es cierto que la lógica en ambos casos es la misma, el código es mucho menos agobiante para el programador y además más fácil de entender.

Este código es interno y es útil para el programador solamente, el usuario final, no se entera de nada.