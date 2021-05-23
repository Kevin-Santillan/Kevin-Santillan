//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_JUGADOR_H
#define PROYECTO_JUGADOR_H
#include <iostream>
#include <SFML/Graphics.hpp>
#include "Figura.h"


using namespace std;
class Jugador : public Figura {
private:
    sf::RectangleShape rectangulo;
    int puntaje;
public:
    Jugador(int _largo, int _altura, sf::RenderWindow* _window);
    void dibujar();
    void mover();
    int get_puntaje();

};


#endif //PROYECTO_JUGADOR_H
