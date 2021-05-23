//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_PELOTA_H
#define PROYECTO_PELOTA_H
#include <SFML/Graphics.hpp>

class Pelota {
private:
    int posicion_x;
    int posicion_y;
    int radio;
    int desplazamiento_x;
    int desplazamiento_y;
    sf::RenderWindow *window;
public:
    Pelota(int _posicion_x,int _posicion_y,int _radio,
           int _desplazamiento_x, int _desplazamiento_y,
           sf::RenderWindow* _window);
    void dibujar();
    void mover();

};


#endif //PROYECTO_PELOTA_H
