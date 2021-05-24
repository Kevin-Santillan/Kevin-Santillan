//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_PANTALLAFINAL_H
#define PROYECTO_PANTALLAFINAL_H
#include <iostream>
#include <SFML/Graphics.hpp>


using namespace std;
class PantallaFinal {
private:
    int posicion_x;
    int posicion_y;
    int largo;
    int ancho;
    sf::RenderWindow *window;
public:
    PantallaFinal();
    void dibujar();
    void eventos();
    void actualizar_mensaje();
};


#endif //PROYECTO_PANTALLAFINAL_H
