/*
8-Crearemos una supeclase llamada Electrodomestico con las siguientes características:
a.Sus atributos son precio base, color, consumo energético (letras entre A y F) y peso. Indica que se podrán heredar.
b.	Por defecto, el color sera blanco, el consumo energético sera F, el precioBase es de 100 € y el peso de 5 kg. Usa constantes para ello.
c.	Los colores disponibles son blanco, negro, rojo, azul y gris. No importa si el nombre esta en mayúsculas o en minúsculas.
d.	Los constructores que se implementaran serán
	i.	Un constructor por defecto.
	ii.	Un constructor con el precio y peso. El resto por defecto.
	iii.	Un constructor con todos los atributos.
e.	Los métodos que implementara serán:
	i.	Métodos get de todos los atributos.
	ii.	comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta, sino es correcta usara la letra por defecto. Se invocara al crear el objeto y no sera visible.
	iii.	comprobarColor(String color): comprueba que el color es correcto, sino lo es usa el color por defecto. Se invocara al crear el objeto y no sera visible.
	iv.	precioFinal(): según el consumo energético, aumentara su precio, y según su tamaño, también. Esta es la lista de precios:

*/

#include <iostream>
using namespace std;
class Electrodomestico{
    protected:
        float precioB;
        string color;
        char consumoE;
        float peso;
    public:
        Electrodomestico(){
            precioB=100.0;
            color="Blanco";
            consumoE='E';
            peso=5.0;
        }
        Electrodomestico(float _precioB, float _peso){
            precioB=_precioB;
            color="Blanco";
            consumoE='E';
            peso=_peso;
        }
        Electrodomestico(float _precioB, string _color, char _consumoE, float _peso){
            precioB=_precioB;
            color=_color;
            consumoE=_consumoE;
            peso=_peso;
        }
        float getprecioB(){
            return precioB;
        }
        string getcolor(){
            return color;
        }
        char getconsumoE(){
            return consumoE;
        }
        float getpeso(){
            return peso;
        }
        char testconsumoE(char _consumoE){
            if (_consumoE=='A'||_consumoE=='B'||_consumoE=='C'||_consumoE=='D'||_consumoE=='E'||_consumoE=='F'){
                consumoE=_consumoE;
                return _consumoE;
            }else{
                _consumoE='E';
                consumoE=_consumoE;
                return _consumoE;
            }
        }
        string testcolor(string _color){
            if (_color=="Blanco"||_color=="Negro"||_color=="Rojo"||_color=="Azul"||_color=="Gris"){
                color=_color;
                return _color;
            }else{
                _color="Blanco";
                color=_color;
                return _color;
            }
        }
        float precioF(float* PPconsumo, float* PPpeso){
            float final, precioConsumo;
            final=precioB;
            if (consumoE=='A'){
                final=final+100;
                *PPconsumo=100;
            }else if (consumoE=='B'){
                final=final+80;
                *PPconsumo=80;
            }else if (consumoE=='C'){
                final=final+60;
                *PPconsumo=60;
            }else if (consumoE=='D'){
                final=final+50;
                *PPconsumo=50;
            }else if (consumoE=='E'){
                final=final+30;
                *PPconsumo=30;
            }else if (consumoE=='F'){
                final=final+10;
                *PPconsumo=10;
            }
            if (peso>0&&peso<=19){
                final=final+10;
                *PPpeso=10;
            }else if (peso>=20&&peso<=49){
                final=final+50;
                *PPpeso=50;
            }else if (peso>=50&&peso<=79){
                final=final+80;
                *PPpeso=80;
            }else if (peso>=80){
                final=final+100;
                *PPpeso=100;
            }
            return final;
        }
        void mostrar(){
            float muestra;
            float PPconsumo, PPpeso;
            muestra=precioF(&PPconsumo,&PPpeso);
            cout<<"\nPrecio base: "<<getprecioB()<<"$";
            cout<<"\nColor:"<<getcolor();
            cout<<"\nConsumo Electrico: "<<getconsumoE()<<"\t"<<PPconsumo<<"$";
            cout<<"\nPeso: "<<getpeso()<<"\t"<<PPpeso<<"$";
            cout<<"\nPrecio final:\t"<<muestra<<"$";
            
        }
        
};
int main(){
    float _precioB;
    string _color;
    char _consumoE;
    float _peso;
    cout<<"\nELECTRODOMESTICO";
    cout<<"\nIngrese precio:\t"; cin>>_precioB;
    cout<<"\nIngrese color:\nColores disponibles\n<Blanco> <Negro> <Rojo> <Azul> <Gris>\n----------> "; cin>>_color;
    cout<<"\nIngrese consumo electrico:\n<A> <B> <C> <D> <E> <F>\n----------> "; cin>>_consumoE;
    cout<<"\nIngrese el peso:\n----------> "; cin>>_peso;
    
    Electrodomestico p1=Electrodomestico(_precioB,_color,_consumoE,_peso);
    _consumoE=p1.testconsumoE(_consumoE);
    _color=p1.testcolor(_color);
    p1.mostrar();
    return 0;
}