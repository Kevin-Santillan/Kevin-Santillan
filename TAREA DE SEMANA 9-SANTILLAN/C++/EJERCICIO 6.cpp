/*Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular (que es una persona) y 
cantidad (puede tener decimales). El titular será obligatorio y la cantidad es opcional. Construye 
los siguientes métodos para la clase:

a. Un constructor, donde los datos pueden estar vacíos.
b. Los setters y getters para cada uno de los atributos. El atributo no se puede modificar directamente, sólo ingresando o retirando dinero.
c. mostrar(): Muestra los datos de la cuenta.
d. ingresar(cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
e. retirar(cantidad): se retira una cantidad a la cuenta. La cuenta puede estar en números rojos.*/




#include <iostream>
#include<conio.h>
#include <time.h>
using namespace std;
class Cuenta{
	private:
		string titular;
		float cantidad;
	public:
		Cuenta(){
			titular="";
			cantidad=1000;				
		}
		void settitular(string _titular){
			titular=_titular;
		}
		string gettitular(){
			return titular;
		}
		void ingresar(){
			float aumento;
			cout<<"\n1.INGRESE DINERO: ";cin>>aumento;
			if(aumento>=0)
				cantidad+=aumento;	
		}
		void retirar(){
			float retiro;
			cout<<"\n2.RETIRAR DINERO: ";cin>>retiro;
			cantidad-=retiro;
		}
		float getcantidad(){
			return cantidad;
		}
		void MostrarCuenta(){
			cout<<"\n\n******LA CUENTA******\n";
			cout<<"\nEL TITULAR: "<<gettitular();
			if(cantidad<0)
				cout<<"\n\nLA CUENTA: "<<getcantidad()<<" la cuenta esta en rojo\n";
			if(cantidad>=0)
				cout<<"\n\nLA CUENTA: "<<getcantidad();
		}
		
		
};

int main(){
	int opcion;
	Cuenta cuenta=Cuenta();
	cuenta.settitular("kevin");
	
	cout<<"\n****OPCION*****\n";
	cout<<"\n1.INGRESAR DINERO\n\n2.RETIRAR DINERO\n\n3.SALIR\n\nOPCION: ";
	cin>>opcion;
	if(opcion==1)
		cuenta.ingresar();
	if(opcion==2)
		cuenta.retirar();
	cuenta.MostrarCuenta();
		
	
	
	
	
	getch();
	return 0;
	
};
