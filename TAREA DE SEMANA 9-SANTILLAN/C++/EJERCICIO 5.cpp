#include <iostream>
#include<conio.h>
#include <time.h>
using namespace std;
class Persona{
		string nombre;
		int edad;
		int DNI;
	public:
		Persona(){
			nombre="";
			edad=0;
			DNI=0;
		}
		void setnombre(string _nombre){
			nombre=_nombre;
		}
		void setedad(int _edad){
			while(_edad<0){
				cout<<"\nIngrese bien la edad:\nEDAD: ";cin>>_edad;
			}
			edad=_edad;
		}
		void setDNI(int _DNI){
			DNI=_DNI;
		}
		string getnombre(){
			return nombre;
		}
		int getedad(){
			return edad;
		}
		int getDNI(){
			return DNI;
		}
		void mostrar(){
			cout<<"\n*****Mostra los datos de la persona****\n";
			cout<<"\n\nNOMBRE DE LA PERSONA: "<<getnombre();
			cout<<"\n\nEDAD DE LA PERSONA: "<<getedad();
			cout<<"\n\nDNI DE LA PERSONA: "<<getDNI();
		}
		void MayorDeEdad(){
			if(getedad()<18){
				cout<<"\n\nEs menor de edad";
			}else cout<<"\n\nEs mayor de edad";
		}
		
		
		
}p1;


int main(){
	
	p1=Persona();
	
	
	getch();
	return 0;
	
};
