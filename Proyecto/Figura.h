//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_FIGURA_H
#define PROYECTO_FIGURA_H
#include <SFML/Graphics.hpp>

using namespace std;
class Figura {
protected:
    int posicion_x;
    int posicion_y;
    int largo;
    int altura;
    int desplazamiento_x;
    int desplazamiento_y;
    sf::RenderWindow* window = nullptr;
public:
    Figura(int largo,int altura,
           sf::RenderWindow* window);
    virtual void dibujar() = 0;
    virtual void mover() = 0;
    void set_posicion(int x, int y);

};


#endif //PROYECTO_FIGURA_H
