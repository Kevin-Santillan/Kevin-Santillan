//
// Created by kevin on 21/05/21.
//

#include "Figura.h"

Figura::Figura(int _largo, int _altura,
               sf::RenderWindow *_window):
               posicion_x(0),posicion_y(0),
               largo(_largo),altura(_altura),
               desplazamiento_x(0), desplazamiento_y(0)
               {

}

void Figura::set_posicion(int x, int y) {
    posicion_x=x;
    posicion_y=y;
}
