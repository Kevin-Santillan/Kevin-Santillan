/*3-Implementar una clase con los métodos para inicializar los atributos,
imprimir el valor del lado con un tamaño mayor y el tipo de triángulo
que es (equilátero, isósceles o escaleno)..*/
 
#include <iostream>
#include <time.h>
using namespace std;
class Triangulo{
    private:
        float lado1;
        float lado2;
        float lado3;
    public:
        Triangulo(float,float,float);
        void mostrarL();
        void mostrarM();
        void tipoT();
};
 
Triangulo::Triangulo(float _lado1, float _lado2, float _lado3){
    lado1=_lado1;
    lado2=_lado2;
    lado3=_lado3;
}
 
void Triangulo::mostrarL(){
    cout<<"\nLado1:\t"<<lado1;
    cout<<"\nLado2:\t"<<lado2;
    cout<<"\nLado3:\t"<<lado3;
}
 
void Triangulo::mostrarM(){
    int mayor;
    if((lado1>=lado2)&&(lado1>=lado3)){
        mayor=lado1;
    }else if(lado2>lado3){
        mayor=lado2;
    }else{
        mayor=lado3;
    }
    cout<<"\nEl lado mayor es: "<<mayor<<"u";
}
 
void Triangulo::tipoT(){
    if((lado1==lado2)&&(lado2==lado3)){
        cout<<"\nEl triangulo es equilatero";
    }else if((lado1==lado2)||(lado2==lado3)||(lado1==lado3)){
        cout<<"\nEl triangulo es isosceles";
    }else{
        cout<<"\nEl triangulo es escaleno";
    }
}
 
int main(){
    srand(time(NULL));
    Triangulo p1= Triangulo((1+rand()%(11-1)),(1+rand()%(11-1)),(1+rand()%(11-1)));
    p1.mostrarL();
    p1.mostrarM();
    p1.tipoT();
    return 0;
}