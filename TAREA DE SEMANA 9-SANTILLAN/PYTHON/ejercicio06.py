"""Crea una clase llamada Cuenta que tendrá los siguientes atributos:
titular (que es una persona) y cantidad (puede tener decimales). El titular
 será obligatorio y la cantidad es opcional. Construye los siguientes métodos para la clase:
a. Un constructor, donde los datos pueden estar vacíos.
b. Los setters y getters para cada uno de los atributos. El atributo no se puede modificar
    directamente, sólo ingresando o retirando dinero.
c. mostrar(): Muestra los datos de la cuenta.
Sesión Actividades de aprendizaje Resultado de aprendizaje Semana Indicador de logro Canal de entrega
30-31 Actividad01: Desarrollar los programas propuestos RA2 9 Presentar ejercicios resueltos. Aula Virtual
d. ingresar(cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
e. retirar(cantidad): se retira una cantidad a la cuenta. La cuenta puede estar en números rojos."""


class Cuenta():

    def __init__(self, titular, cantidad=0):
        self.titular = titular
        self.cantidad = cantidad

    @property
    def titular(self):
        return self.__titular

    @property
    def cantidad(self):
        return self.__cantidad

    @titular.setter
    def titular(self, titular):
        self.__titular = titular

    def mostrar(self):
        return "Cuenta\n" + "Titular:" + self.titular.mostrar() + " - Cantidad:" + str(self.cantidad)

    def ingresar(self, cantidad):
        if cantidad > 0:
            self.__cantidad = self.__cantidad + cantidad

    def retirar(self, cantidad):
        if cantidad > 0:
            self.__cantidad = self.__cantidad - cantidad
