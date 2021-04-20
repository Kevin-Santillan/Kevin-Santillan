/*Se pide desarrollar la clase que administre una agenda. Se debe almacenar para cada 
contacto el nombre, el teléfono y el email. Además, deberá mostrar un menú con las siguientes opciones

a. Añadir contacto
b. Lista de contactos
c. Buscar contacto
d. Editar contacto
e. Cerrar agenda
*/

#include <iostream>
#include<conio.h>
#include <time.h>

using namespace std;
class Agenda{
	private:
		struct Contacto{
			string nombre;
			int telefono;
			string email;
		}persona[100];
		int tamanio;	
	public:
		Agenda();
		void aniadir();
		void mostrar();
		void buscar();
		void editar();
}p1;

Agenda::Agenda(){
	tamanio=1;
}


void Agenda::aniadir(){
	cout<<"\n--------ANYADIR CONTACTO-------\n";
	cout<<"\nINGRESE NOMBRE: ";cin>>persona[tamanio].nombre;
	cout<<"\nINGRESE TELEFONO: ";cin>>persona[tamanio].telefono;
	cout<<"\nINGRESE EMAIL.: ";cin>>persona[tamanio].email;
	tamanio++;
}

void Agenda::mostrar(){
	cout<<"\n------LISTA DE CONTACTOS------\n";
	for(int i=1;i<tamanio;i++)
		cout<<"\n "<<i<<"."<<persona[i].nombre<<" / "<<persona[i].telefono<<" / "<<persona[i].email<<endl;
}
void Agenda::buscar(){
	string name;
	string correo;
	cout<<"\n--------BUSCAR CONTACTO-------\n";
	cout<<"\nIngrese el nombre: ";cin>>name;
	cout<<"\nIngrese el correo de la persona: ";cin>>correo;
	for(int i=1;i<tamanio;i++){
		if(persona[i].nombre==name){
			if(persona[i].email==correo){
				cout<<"\nSi se encuentra el contacto con numero: "<<persona[i].telefono<<endl;
			}else cout<<"\nno se encuentra agendado la persona\n";
		}
	}
}
void Agenda::editar(){
	int elegir;
	cout<<"\n******* EDITAR CONTACTO *******\n";
	cout<<"\nINGRESE LA OPCION DEL CONTACTO QUE DESEA MODIFICAR\n";
	for(int i=1;i<tamanio;i++)
		cout<<"\n "<<i<<"."<<persona[i].nombre<<" / "<<persona[i].telefono<<" / "<<persona[i].email<<endl;
	do{
		cout<<"\nElEGIR: ";cin>>elegir;
		if(elegir<1 || elegir>(tamanio-1))
			cout<<"\nERROR, ESCOGER BIEN\n";
	}while(elegir<1 || elegir>(tamanio-1));
	cout<<"\nINGRESE EL NUEVO NOMBRE: ";cin>>persona[elegir].nombre;
	cout<<"\nINGRESE EL NUEVO TELEFONO: ";cin>>persona[elegir].telefono;
	cout<<"\nINGRESE EL NUEVO EMAIL.: ";cin>>persona[elegir].email;
}
void opcionElegida(int op){
	if(op==1){
		p1.aniadir();
	}else if(op==2){
		p1.mostrar();
	}else if(op==3){
		p1.buscar();		
	}else if(op==4){
		p1.editar();
	}
}

int main(){
	int opcion=0;
	p1=Agenda();
	
	do{
		if(opcion==1 || opcion==2 || opcion==3 || opcion==4){
			opcionElegida(opcion);
		};		
		cout<<"\n\t*** BIENVENIDO AL MENU ***\n";
		cout<<"\n\t1.ANYADIR CONTACTO\n";
		cout<<"\t2.LISTA DE CONTACTOS\n";
		cout<<"\t3.BUSCAR CONTACTO\n";
		cout<<"\t4.EDITAR CONTACTO\n";
		cout<<"\t5.SAlir.\n";
		cout<<"\n\tOpcion : ";
		cin>>opcion;
		if(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5)
			cout<<"\n\tERROR, ingrese otra vez\n";
	}while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5);
	if(opcion==5){
		cout<<"************ QUE tenga UN  BUEN DIA ***********";
	}
	
	getch();
	return 0;
	
}




