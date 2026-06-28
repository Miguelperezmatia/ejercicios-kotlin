/*
    Crea una clase llamada Smartphone. Debe tener propiedades como marca, modelo y bateriaActual (de 0 a 100).
    Luego, añádele un metodo (función) llamado usarApp() que reste 10 puntos de batería cada vez que se ejecute, e
    imprima un aviso si la batería baja de 20.
    Crea un teléfono en tu fun main() y úsalo.
*/

class Smartphone(val marca: String, val modelo: String, var bateriaActual: Int) {
    fun usarApp() {
        if (this.bateriaActual < 0)
            return

        this.bateriaActual -= 10
        println("Se ha consumido un 10 % de batería")

        if (this.bateriaActual == 0) {
            println("Batería actual: ${this.bateriaActual}")
            println("Apagando el dispositivo")
            this.bateriaActual -= 1
            return
        }

        if (this.bateriaActual < 20) {
            println("Cuidado, la batería ha bajado del 20 %")
            println("Batería actual: ${this.bateriaActual}")
        }
    }
}


    fun main()
    {
        val s = Smartphone(marca="Samsung", modelo="XZ2", bateriaActual=50)

        s.usarApp()     //  Se ha consumido un 10 % de batería

        s.usarApp()     //  Se ha consumido un 10 % de batería

        s.usarApp()     //  Se ha consumido un 10 % de batería

        s.usarApp()     /*
                            Se ha consumido un 10 % de batería

                            Cuidado, la batería ha bajado del 20 %
                            Batería actual: 10
                        */


        s.usarApp()     /*
                            Se ha consumido un 10 % de batería
                            Batería actual: 0
                            Apagando el dispositivo
                        */

        s.usarApp()
    }

