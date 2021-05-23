//
// Created by kevin on 21/05/21.
//

#ifndef PROYECTO_JUEGO_H
#define PROYECTO_JUEGO_H
#include <iostream>
#include <SFML/Graphics.hpp>
#include "PantallaInicial.h"
#include "PantallaJuego.h"
#include "PantallaFinal.h"

using namespace std;
class Juego : public PantallaJuego{
private:
    int posicion_x;
    int posicion_y;
    int largo;
    int altura;
    sf::RenderWindow window;
public:
    void ejecutar();
    void reiniciar();
    void inicializar();
    void adicionar_pantalla();
};;



#endif //PROYECTO_JUEGO_H
