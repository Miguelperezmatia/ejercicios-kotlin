/*
    Escribe una función llamada mostrarPerfil que reciba dos parámetros: el nombre de un usuario (Texto) y su biografía (Texto).

    El truco es que la biografía debe permitir ser nula (usando String?), simulando que el usuario no quiso escribir nada. 
    Si la biografía es nula, imprime "Sin biografía", de lo contrario, imprime el texto.
*/


fun main()
{
    mostrarPerfil("Miguel",null)

    /*
        Salida:

        Nombre: Miguel
        Biografía: Sin biografía
    */

    println()

    mostrarPerfil("Alvaro", "37 años, de Madrid, camarero")

    /*
        Salida:

        Nombre: Alvaro
        Biografía: 37 años, de Madrid, camarero
    */
}

fun mostrarPerfil(nombre : String, biografia : String?)
{
    var bio = biografia

    biografia?.let {
        bio = it
    } ?: run {
        bio = "Sin biografía"
    }

    val resultado = "Nombre: $nombre \nBiografía: $bio"

    println(resultado)
}