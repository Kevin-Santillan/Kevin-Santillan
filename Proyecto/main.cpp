#include <iostream>
#include <SFML/Graphics.hpp>
#include "Juego.h"
#include "Jugador.h"

using namespace std;
int main()
{
    //pantalla
    sf::RenderWindow window(sf::VideoMode(800, 600), "Juego del Ping Pong");
    //creamos al jugador(para que se muestre, si seguimos
    // avanzando, luego lo heredare a pantalla de juego
    // luego a juego y mediante el juego inicializo)
    //Jugador j1(20,50,&window);

    while (window.isOpen())
    {
        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
                window.close();
        }

        //color de pantalla
        window.clear(sf::Color::Green);
        //crear objeto, lo pongo aqui
        //para que me muestre en la pantalla
        //luego lo pondre en jugador
        //y esto heredara a pantalla de juego que luego
        //heredara a Juego y luego el juego que es el principal
        //heredara al main.
        //j1.dibujar();

        window.display();
}

    return 0;
}
