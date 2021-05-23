//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_PANTALLAINICIAL_H
#define PROYECTO_PANTALLAINICIAL_H
#include <iostream>
#include <SFML/Graphics.hpp>



using namespace std;
class PantallaInicial {
private:
    int posicion_x;
    int posicion_y;
    int largo;
    int altura;
    sf::RenderWindow *window;
public:
    PantallaInicial();
    void dibujar();
    void eventos();

};



#endif //PROYECTO_PANTALLAINICIAL_H
