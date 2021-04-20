"""Implementar una clase con los métodos para inicializar los atributos,
imprimir el valor del lado con un tamaño mayor y el tipo de triángulo que es
 (equilátero, isósceles o escaleno).."""
class Triangulo:
    def __init__(self):
        self.lado1=  int(input("Ingrese lado 1 "))
        self.lado2 = int(input("Ingrese lado 2 "))
        self.lado3 = int(input("Ingrese lado 3 "))
    def mostrar(self):

        if (self.lado1 == self.lado2 and self.lado1 == self.lado3):
         print("El triangulo es equilatero, no tiene lado mayor ")

        if ((self.lado1 == self.lado2 and self.lado2 != self.lado3) or (self.lado2 == self.lado3 and self.lado3 != self.lado1) or(
                self.lado3 == self.lado1 and self.lado1 != self.lado2)):
         print("El triangulo es isosceles ")
         if (self.lado1 > self.lado2 and self.lado1 > self.lado3):
          print("El mayor lado es: ",self.lado1)
         if (self.lado2 > self.lado1 and self.lado2 > self.lado3):
          print("El mayor lado es: ",self.lado2)
         if (self.lado3 > self.lado1 and self.lado3 > self.lado2):
          print("El mayor lado es: ",self.lado3)


        if (self.lado1 != self.lado2 and self.lado1 != self.lado3 and self.lado2 != self.lado3):
         print("El triangulo es escaleno  ")
         if (self.lado1 > self.lado2 and self.lado1 > self.lado3):
          print("El mayor lado es: ",self.lado1)
         if (self.lado2 > self.lado1 and self.lado2 > self.lado3):
          print("El mayor lado es: ",self.lado2)
         if (self.lado3 > self.lado1 and self.lado3 > self.lado2):
          print("El mayor lado es: ",self.lado3)
triangulo1=Triangulo()
triangulo1.mostrar()

