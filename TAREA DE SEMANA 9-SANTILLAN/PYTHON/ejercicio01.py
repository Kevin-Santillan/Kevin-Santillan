"""Se pide desarrollar una clase llamada Alumno que tenga como atributos el nombre y la nota del alumno. Definir los métodos para inicializar sus atributos, imprimirlos y mostrar un mensaje
con el resultado de la nota y si ha aprobado o no."""
class Alumno:
    #inicilizamos los atributos
    def inicializar(self,nombre,nota):
        self.nombre = nombre
        self.nota = nota

    def imprimir(self):
        print("Nombre: ",self.nombre)
        print("Calificacion: ", self.nota)

    def resultado(self):
        if self.nota<10.5:
            print("El alumno reprobó")
        else:
            print("El alumno aprobó")

alumno1=Alumno()
alumno2=Alumno()

alumno1.inicializar("Kevin",10.4)
alumno2.inicializar("Thalia",15)

alumno1.imprimir()
alumno1.resultado()
alumno2.imprimir()
alumno2.resultado()