/*Haz una clase llamada Persona que siga las siguientes condiciones:

a. Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura.
No queremos que se accedan directamente a ellos. Piensa que modificador de acceso es el más adecuado,
también su tipo. Si quieres añadir algún atributo puedes hacerlo.

b. Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo
(0 números, cadena vacía para String, etc.). Sexo sera hombre por defecto, usa una constante para ello.

c. Se implantaran varios constructores:
	i. Un constructor por defecto.
	ii. Un constructor con el nombre, edad y sexo, el resto por defecto.
	iii. Un constructor con todos los atributos como parámetro.

d. Los métodos que se implementaran son:
	i. calcularIMC(): calculara si la persona esta en su peso ideal (peso en kg/(altura^2 en m)), si esta fórmula
	devuelve un valor menor que 20, la función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos),
	significa que esta por debajo de su peso ideal la función devuelve un 0 y si devuelve un valor mayor que 25 
	significa que tiene sobrepeso, la función devuelve un 1. Te recomiendo que uses constantes para devolver estos valores.
	ii. esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
	iii. comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. Si no es correcto, sera H. No sera visible al exterior.
	iv. toString(): devuelve toda la información del objeto.
	v. generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente. Este método
	sera invocado cuando se construya el objeto. Puedes dividir el método para que te sea más fácil. No será visible al exterior.
	vi. Métodos set de cada parámetro, excepto de DNI.

e. Ahora, crea una clase ejecutable que haga lo siguiente:
	i. Pide por teclado el nombre, la edad, sexo, peso y altura.
	ii. Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores variables pedidas por teclado, el segundo
	objeto obtendrá todos los anteriores menos el peso y la altura y el último por defecto, para este último utiliza los métodos
	set para darle a los atributos un valor.
	iii. Para cada objeto, deberá comprobar si esta en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
	iv. Indicar para cada objeto si es mayor de edad.
	v. Por último, mostrar la información de cada objeto.

f. Puedes usar métodos en la clase ejecutable, para que os sea mas fácil.*/


#include<iostream>
#include<conio.h>
#include<math.h>  
#include <time.h>

using namespace std;

class Persona{
	private:
		string nombre;
		int edad;
		int DNI;
		string sexo;
		float peso;
		float altura;
		
	public:
		Persona(string _nombre,int _edad,string _sexo,float _peso,float _altura){
			nombre=_nombre;
			edad=_edad;
			DNI=74946824;
			sexo=_sexo;
			peso=_peso;
			altura=_altura;
		}
		Persona(string _nombre, int _edad,string _sexo){
			nombre=_nombre;
			edad=_edad;
			DNI=74946824;
			sexo=_sexo;
			peso=0.0;
			altura=0.0;
		}
		Persona(){
			nombre="0";
			edad=0;
			DNI=74946824;
			sexo="H";
			peso=0.0;
			altura=0.0;
		}
		
		void setnombre(string _nombre){
			nombre=_nombre;
		}
		void setedad(int _edad){
			edad=_edad;
		}
		void setsexo(string _sexo){
			sexo=_sexo;
		}
		void setpeso(float _peso){
			peso=_peso;
		}
		void setaltura(float _altura){
			altura=_altura;
		}
		
		int calcularIMC(){
			int k;
			if(peso==0.0 || altura==0.0){
				k=2;
				return k;
			}else{
				float formula=(peso/(pow(altura,2)));
				if(formula<20){
					k=-1;
					return k;
				}else if(formula>=20 && formula<=25){
					k=0;
					return k;
				}else if(formula>25){
					k=1;
					return k;
				}
			}		
		}
		bool MayorDeEdad(){
		
			bool mayordeedad = edad>18;
			return mayordeedad;

		}
		void comprobarSexo(string _sexo){
			sexo=_sexo;
			if(sexo!="H" && sexo!="h" && sexo!="m" && sexo!="M"){
				sexo="H";
			}
			cout<<sexo;		
		}
		void toString(){
			cout<<"\n********DATOS********\n";
			cout<<"\n\nNOMBRE: "<<nombre<<endl;
			cout<<"\nEDAD: "<<edad<<endl;
			cout<<"\nDNI: "<<DNI<<endl;
			cout<<"\nSEXO: "<<sexo<<endl;
			cout<<"\nPESO: "<<peso<<endl;
			cout<<"\nALTURA: "<<altura<<endl;
		}
		void generaDNI(){
			srand(time(NULL));
			DNI=(9999999+rand()%(100000000-1));
		}
		
		
};

int main(){
	//name,edad,sexo,peso y altura
	string _nombre,_sexo;
	int _edad;
	float _peso,_altura;
	cout<<"***INGRESA DATOS****";
	cout<<"\n\nINGRESE EL NOMBRE: ";cin>>_nombre;
	cout<<"\nINGRESE LA EDAD: ";cin>>_edad;
	cout<<"\nINGRESE EL SEXO(H/M): ";cin>>_sexo;
	cout<<"\nINGRESE EL PESO(kg):";cin>>_peso;
	cout<<"\nINGRESE LA ALTURA(m): ";cin>>_altura;
	
	Persona persona1=Persona(_nombre,_edad,_sexo,_peso,_altura);
	Persona persona2=Persona(_nombre,_edad,_sexo);
	Persona persona3=Persona();
	
	//datos de la persona 1: aqui puedo modificar con el set:
	persona1.generaDNI();
	if(persona1.calcularIMC()==1)
		cout<<"\nLA PERSONA 1 TIENE SOBREPESO";
	if(persona1.calcularIMC()==0)
		cout<<"\nLA PERSONA 1 ESTA POR DEBAJO DE SU PESO IDEAL";
	if(persona1.calcularIMC()==-1)
		cout<<"\nLA PERSONA 1 ESTA EN SU PESO IDEAL";
	if(persona1.calcularIMC()==2)
		cout<<"\nPERSONA 1: Tiene que ingresar el peso y la altura de la persona";
	if(persona1.MayorDeEdad()==1)
		cout<<"\nLA PERSONA 1 ES MAYOR DE EDAD\n";
	if(persona1.MayorDeEdad()==0)
		cout<<"\nLA PERSONA 1 NO ES MAYOR DE EDAD\n";
	persona1.toString();
	
	//datos de la persona 2: aqui puedo modificar con el set:
	persona2.generaDNI();
	if(persona2.calcularIMC()==1)
		cout<<"\nLA PERSONA 2 TIENE SOBREPESO";
	if(persona2.calcularIMC()==0)
		cout<<"\nLA PERSONA 2 ESTA POR DEBAJO DE SU PESO IDEAL";
	if(persona2.calcularIMC()==-1)
		cout<<"\nLA PERSONA 2 ESTA EN SU PESO IDEAL";
	if(persona2.calcularIMC()==2)
		cout<<"\nPERSONA 2: Tiene que ingresar el peso y la altura de la persona";
	if(persona2.MayorDeEdad()==1)
		cout<<"\nLA PERSONA 2 ES MAYOR DE EDAD\n";
	if(persona2.MayorDeEdad()==0)
		cout<<"\nLA PERSONA 2 NO ES MAYOR DE EDAD\n";
	persona2.toString();
	
	//datos de la persona 3: aqui puedo modificar con el set:
	persona3.generaDNI();
	if(persona3.calcularIMC()==1)
		cout<<"\nLA PERSONA 3 TIENE SOBREPESO";
	if(persona3.calcularIMC()==0)
		cout<<"\nLA PERSONA 3 ESTA POR DEBAJO DE SU PESO IDEAL";
	if(persona3.calcularIMC()==-1)
		cout<<"\nLA PERSONA 3 ESTA EN SU PESO IDEAL";
	if(persona3.calcularIMC()==2)
		cout<<"\nPERSONA 3:Tiene que ingresar el peso y la altura de la persona";
	if(persona3.MayorDeEdad()==1)
		cout<<"\nLA PERSONA 3 ES MAYOR DE EDAD\n";
	if(persona3.MayorDeEdad()==0)
		cout<<"\nLA PERSONA 3 NO ES MAYOR DE EDAD\n";
	persona3.toString();
	
	
	
	
	
	getch();
	return 0;
}




























