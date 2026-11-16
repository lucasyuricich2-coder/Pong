# Pong
🎮 Pong Game

Juego de Pong multijugador desarrollado en Java.

📌 Descripción

Pong Game es una adaptación del clásico videojuego Pong, desarrollada utilizando Java y la biblioteca Swing.

El proyecto permite jugar partidas multijugador en una misma computadora, ofreciendo diferentes modalidades de juego, personalización de jugadores y un sistema de puntuación.

El objetivo consiste en controlar las paletas para devolver la pelota y conseguir puntos, evitando que esta atraviese el área de juego.

✨ Características principales

- Modo 1 vs. 1: enfrentamiento entre dos jugadores.
- Modo 2 vs. 2: partidas por equipos de dos jugadores.
- Free For All: modalidad competitiva para cuatro jugadores, cada uno con su propia paleta.
- Personalización: permite introducir nombres y seleccionar colores para los jugadores.
- Sistema de puntuación: seguimiento individual de los puntos y determinación del ganador.
- Sistema de pausa: permite detener y reanudar la partida.
- Menú principal: navegación entre las opciones del juego.
- Reinicio: posibilidad de iniciar una nueva partida.

🕹️ Controles

Modo 1 vs. 1

Jugador| Movimiento
Jugador 1| W / S
Jugador 2| ↑ / ↓

Modo 2 vs. 2

Jugador| Movimiento
Jugador 1| W / S
Jugador 2| ↑ / ↓
Jugador 3| R / F
Jugador 4| O / L

Free For All (4 jugadores)

Jugador| Ubicación| Movimiento
Jugador 1| Izquierda| W / S
Jugador 2| Derecha| ↑ / ↓
Jugador 3| Arriba| A / D
Jugador 4| Abajo| J / L

Controles generales

- ESPACIO: pausar o reanudar la partida.
- BACKSPACE: regresar al menú principal.

🛠️ Tecnologías utilizadas

- Java 21: lenguaje de programación utilizado para desarrollar la lógica del juego.
- Java Swing: creación de ventanas, menús, cuadros de diálogo e interfaz gráfica.
- Java AWT: representación gráfica, colores, dimensiones y gestión de eventos del teclado.
- Maven: herramienta de gestión y configuración del proyecto.

📁 Estructura del proyecto

Pong/
│
├── pom.xml
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── PongGame.java
│   │       ├── GameFrame.java
│   │       ├── GamePanel.java
│   │       ├── MainMenu.java
│   │       ├── ModeMenu.java
│   │       ├── LoginDialog.java
│   │       ├── Ball.java
│   │       ├── Paddle.java
│   │       ├── Score.java
│   │       └── com/
│   │           └── mycompany/
│   │               └── pong/
│   │                   └── Pong.java
│   │
│   └── test/
│       └── java/
│
└── Pong/
    ├── pom.xml
    └── src/
        └── ...

⚙️ Requisitos

Para ejecutar el proyecto se necesita:

- Java Development Kit (JDK) 21.
- Apache Maven.
- Un entorno compatible con aplicaciones gráficas de Java Swing.

🚀 Ejecución

1. Descargar el proyecto desde GitHub.
2. Extraer el archivo ZIP.
3. Abrir el proyecto desde un entorno de desarrollo compatible con Java y Maven.
4. Ejecutar la clase "PongGame.java", que contiene el método principal de inicio.

También se puede utilizar Maven desde la terminal:

mvn clean compile

📥 Descarga del proyecto

Para descargar la versión correspondiente del proyecto:

1. Ingresar al repositorio de GitHub.
2. Abrir el selector de ramas.
3. Cambiar la rama actual a Master.
4. Pulsar el botón Code.
5. Seleccionar Download ZIP.
6. Extraer el archivo descargado para acceder al código fuente.

Importante: Es necesario seleccionar la rama "Mastef" antes de descargar el proyecto para obtener la versión indicada.

🎯 Objetivo académico

Este proyecto fue desarrollado con fines educativos, como ejercicio práctico de programación en Java.

Su desarrollo permite aplicar conceptos relacionados con programación orientada a objetos, interfaces gráficas, eventos de teclado, estructuras de control, lógica de videojuegos y organización de proyectos.

---

Proyecto: Pong Game
Lenguaje: Java
Versión de Java: 21
Tipo: Proyecto académico
