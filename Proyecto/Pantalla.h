//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_PANTALLA_H
#define PROYECTO_PANTALLA_H
#include <SFML/Graphics.hpp>
#include <string>

using namespace std;
class Pantalla {
protected:
    int posicion_x;
    int posicion_y;
    int largo;
    int altura;
    sf::RenderWindow* window;
    sf::Font* font;
public:
    Pantalla(int posicion_x, int posicion_y,
             int largo, int altura,
             sf::RenderWindow* window,
             sf::Font* font);
    virtual void dibujar() = 0;
    virtual void eventos(sf::Event event,
                         string& pantalla_actual) = 0;

};


#endif //PROYECTO_PANTALLA_H
