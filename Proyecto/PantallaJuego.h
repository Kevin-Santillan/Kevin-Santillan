//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_PANTALLAJUEGO_H
#define PROYECTO_PANTALLAJUEGO_H
#include <iostream>
#include <SFML/Graphics.hpp>
#include "Jugador.h"
#include "Pelota.h"



using namespace std;
class PantallaJuego {
private:
    int posicion_x;
    int posicion_y;
    int largo;
    int altura;
    sf::RenderWindow *window;
public:
    PantallaJuego();
    void dibujar();
    void eventos();
    void dibujar_red();
    void actualizar_puntaje();
    void colision();
};


#endif //PROYECTO_PANTALLAJUEGO_H
