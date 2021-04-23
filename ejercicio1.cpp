#include<iostream>
#include<conio.h>
using namespace std;
int main(){
    float x,y,suma,resta,multiplicacion,division;
    int decidir;
    cout<<"INGRESE LOS DATOS : "<<endl;
    cout<<"x: ";cin>>x;
    cout<<"y: ";cin>>y;
    cout<<"DESEA REALIZAR: \n";cout<<"1)SUMA\n";cout<<"2)RESTA\n";cout<<"3)MULTIPLICACION\n";cout<<"4)DIVISION\n";     
    cout<<"******ESCOGER ENTRE LAS OPCIONES******"<<endl;
    cin>>decidir;
    if(decidir<=4 && decidir>=1){
        switch (decidir)
        {
        case 1: suma=x+y;cout<<"LA SUMA ES : "<<suma;
            break;
        case 2: resta=x-y;cout<<"LA RESTA ES : "<<resta;
            break;
        case 3: multiplicacion=x*y;cout<<"LA MULTIPLICACION ES : "<<multiplicacion;
            break;
        case 4: division=x/y;cout<<"LA DIVISION ES : "<<division;
            break;
        default: cout<<"ingrese una de las opciones"<<endl;
        }
    }
    getch();
    return 0;
}