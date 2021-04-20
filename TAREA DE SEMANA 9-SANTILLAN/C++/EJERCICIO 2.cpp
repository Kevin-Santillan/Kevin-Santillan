/*2-La clase tendrá como atributos el nombre y la edad de una persona.
Implementar los métodos necesarios para inicializar los atributos,
mostrar los datos e indicar si la persona es mayor de edad o no.*/
 
#include <iostream>
#include <time.h>
using namespace std;
class Persona{
    private:
        string nombre;
        int edad;
    public:
        Persona(string,int);
        void ingresarD();
        void mostrar();
        void mayor();
 
};
 
Persona::Persona(string _nombre, int _edad){
    nombre=_nombre;
    edad=_edad;
}
 
void Persona::ingresarD(){
    cout<<"Ingrese nombre: ";
    cin>>nombre;
    do{
        cout<<"Ingrese edad: ";
    	cin>>edad;
		if(edad<0 || edad>100)
			cout<<"ERROR\n";	
	}while(edad<0 || edad>100);

}
 
void Persona::mostrar(){
    cout<<"\nNombre:\t"<<nombre<<"\n"<<"Edad:\t"<<edad;
}
 
void Persona::mayor(){
    if(edad>=18){
        cout<<"\nEs mayor de edad";
    }else{
        cout<<"\nEs menor de edad";
    }
}
 
void datos(int op){
    if(op==1){
        srand(time(NULL));
        Persona p1= Persona("Juan",(0+rand()%(35)));
        p1.mostrar();
        p1.mayor();
    }else if(op==2){
        Persona p1("juan",20);
        p1.ingresarD();
        p1.mostrar();
        p1.mayor();
    }
}
 
int main(){
    int op;
    do{
        cout<<"Automatico(1) o manual(2)\n";
        cin>>op;
    }while(op!=1&&op!=2);
    datos(op);
    return 0;
}