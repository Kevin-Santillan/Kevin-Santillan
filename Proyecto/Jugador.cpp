//
// Created by kevin on 21/05/21.
//

#include "Jugador.h"


using namespace std;
Jugador::Jugador(int largo, int altura,
                 sf::RenderWindow* window):
                 Figura(largo,altura,window), puntaje(0){

}

void Jugador::dibujar() {
    Figura::set_posicion(10,10);
    rectangulo.setPosition(posicion_x,posicion_y);
    rectangulo.setSize(sf::Vector2f(largo,altura));
    rectangulo.setFillColor(sf::Color::White);
    window->draw(rectangulo);

}

void Jugador::mover() {

}

int Jugador::get_puntaje() {
    return puntaje;
}
