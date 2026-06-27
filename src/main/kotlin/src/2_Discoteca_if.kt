/*
    Crea una variable con la edad de un usuario y otra booleana (true/false) que indique si trae invitación.

    Utiliza condicionales para imprimir si la persona puede entrar a la fiesta (solo si es mayor de 18 O si trae invitación)
    o si debe quedarse fuera.

    Intenta usar la estructura if
*/


fun main()
{
    var edad = 0
    var esInvitado = true

    try
    {
        println("Introduce tu edad: ")
        edad = readln().toInt()

        if (edad < 0)
            throw IllegalArgumentException("Error. La edad no puede ser negativa")

        println("Introduce true si eres invitado, escribe false en caso contrario: ")
        esInvitado = readln().toBoolean()

    } catch (e: NumberFormatException)
    {
        println("Error ${e.message}")
        println("Debes introducir un formato válido")
        return

    } catch(e: IllegalArgumentException)
    {
        println("${e.message}")
        return
    }

        if (edad >= 18 && esInvitado)
            println("Eres mayor de edad y traes invitación, puedes pasar a la fiesta")

        else if (edad >= 18)
            println("Eres mayor de edad, puedes pasar a la fiesta")

        else if (esInvitado)
            println("Traes invitación, puedes entrar a la fiesta")

        else
            println("No puedes entrar a la fiesta")
}