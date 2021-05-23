//
// Created by kevin on 21/05/21.
//

#include "Pelota.h"

using namespace std;
Pelota::Pelota(int _posicion_x,int _posicion_y,int _radio,
               int _desplazamiento_x, int _desplazamiento_y,
               sf::RenderWindow* _window):
               posicion_x(_posicion_x), posicion_y(_posicion_y),
               radio(_radio),desplazamiento_x(_desplazamiento_x),
               desplazamiento_y(_desplazamiento_y),
               window(_window){

}
void Pelota::dibujar() {

}

void Pelota::mover() {

}
