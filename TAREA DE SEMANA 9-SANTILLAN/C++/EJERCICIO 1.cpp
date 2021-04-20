/*Se pide desarrollar una clase llamada Alumno que tenga como atributos el 
nombre y la nota del alumno. Definir los métodos para inicializar sus atributos,
imprimirlos y mostrar un mensaje con el resultado de la nota y si ha aprobado o no.*/

#include <iostream>
#include <time.h>
using namespace std;
class Alumno{
    private:
        string nombre;
        int nota;
    public:
        Alumno(string,int);
        void ingresarD();
        void mostrar();
        void aprobar();
 
};
 
Alumno::Alumno(string _nombre, int _nota){
    nombre=_nombre;
    nota=_nota;
}
 
void Alumno::ingresarD(){
    cout<<"Ingrese nombre: ";
    cin>>nombre;
    do{
	    cout<<"Ingrese nota: ";
	    cin>>nota;
		if(nota<0 || nota>20)
			cout<<"ERROR\n";   	
	}while(nota<0 || nota>20);

}
 
void Alumno::mostrar(){
    cout<<"Nombre:\t"<<nombre<<"\n"<<"Nota:\t"<<nota;
}
 
void Alumno::aprobar(){
    if(nota>10.5){
        cout<<"\nAprobo";
    }else{
        cout<<"\nDesaprobo";
    }
}
void datos(int op){
	if(op==1){
		srand(time(NULL));
        Alumno p1= Alumno("Juan",(0+rand()%(21)));
        p1.mostrar();
        p1.aprobar();
    }else if(op==2){
        Alumno p1= Alumno("juan",15);
        p1.ingresarD();
        p1.mostrar();
        p1.aprobar();
    }	
}
 
int main(){
    int op=0;
    do{
        cout<<"Automatico(1) o manual(2)\n";
        cin>>op;
    }while(op!=1 && op!=2);
	datos(op);
    return 0;
}