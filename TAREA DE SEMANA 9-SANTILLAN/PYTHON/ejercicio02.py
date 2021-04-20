"""La clase tendrá como atributos el nombre y la edad de una persona.
Implementar los métodos necesarios para inicializar los atributos,
mostrar los datos e indicar si la persona es mayor de edad o no."""
class Persona:
    # declaramos el metodo __init__
    def __init__(self):
        self.nombre=input("Ingrese el nombre: ")
        self.edad=int(input("Ingrese la edad: "))
    def mostrar(self):
        if self.edad>=18:
         print("es mayor de edad")
        else :
            print("es menor de edad")
persona1=Persona()
persona1.mostrar()