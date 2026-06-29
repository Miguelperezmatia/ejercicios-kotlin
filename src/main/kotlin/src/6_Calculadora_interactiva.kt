import segundoNumero

/*
    Hágase un programa que permita realizar sumas, restas, productos, divisiones enteras y resto entero de números enteros
    largos positivos o cero con un máximo de 9 dígitos.

    MENU PRINCIPAL

    En el programa principal se tendrá un menú de las siguientes características:

    OPCION ACCION
    ======================================================
       1     Mostrar numeros y operacion
       2     Mostrar resultado
       3     Modificar primer numero
       4     Modificar segundo numero
       5     Modificar operacion
     otra    Terminar


    OPCION 1

    Se mostrarán los dos números a operar (inicialmente tienen el valor de 0) y la operación a realizar (inicialmente tiene el valor de ‘+’)

    *********************************************************
    * * MOSTRAR NUMEROS Y OPERACION *
    *********************************************************
    PRIMER NUMERO: 0
    SEGUNDO NUMERO: 0
    OPERACION: +
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    OPCION 2

    Se mostrará el resultado de aplicar la operación actual (+, -, *, % o /) aplicada a
    los valores actuales del primer numero y del segundo número:

    *********************************************************
    * * MOSTRAR RESULTADO *
    *********************************************************
    0 + 0 = 0
    OPERACION REALIZADA
    ---------------------------------------------------------
    - Pulsa enter para continuar ...

    En el caso de que la operación sea la de división entera (/) y el segundo número fuera 0, se mostraría como resultado de la operación
    la siguiente línea:
    5 / 0 = No se puede dividir entre 0

    En el caso de que la operación sea la del resto entero (%) y el segundo número fuera 0, se mostraría como resultado de la operación
    la siguientelínea:
    5 % 0 = No se puede obtener el resto entre 0


    OPCION 3

    Se mostrará el submenú para modificar el valor actual del primer numero

    OPCION 4

    Se mostrará el submenú para modificar el valor actual del segundo numero

    OPCION 5

    Se modificará la operación actual introduciéndola por consola.
    *********************************************************
    * * LEER OPERACIÓN *
    *********************************************************
    ESCRIBE UNA OPERACION (+,-,*,/,%): *
    OPERACION MODIFICADA
    ---------------------------------------------------------
    - Pulsa enter para continuar ...

    NOTA: Se valida que el carácter introducido es ‘+’, ‘-’ , ‘*’ o ‘/’.


    SUBMENU

    Se tendrá un submenú para poder modificar el valor de un número entero largo positivo o cero. El submenú tendrá las siguientes opciones:

    OPCION ACCION
    ====== ==================================================
       1    Añadir digito
       2    Quitar ultimo digito
       3    Quitar digitos pares
       4    Sumar todos los digitos
      otra  Terminar
    ----------------------------------------------------------

    OPCION 1
    Añade un dígito del 0 al 9 por la derecha al valor actual siempre que dicho numero tenga menos de 9 dígitos
    *********************************************************
    * * AÑADIR DIGITO *
    **********************************************************
    NUMERO A MODIFICAR: 0
    ESCRIBE UN DIGITO DEL 0 AL 9: 5
    NUEVO NUMERO: 5
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    Si se vuelve a elegir la opción de “Añadir dígito”:
    *********************************************************
    * * AÑADIR DIGITO *
    **********************************************************
    NUMERO A MODIFICAR: 5
    ESCRIBE UN DIGITO DEL 0 AL 9: 7
    NUEVO NUMERO: 57
    ---------------------------------------------------------
    - Pulsa enter para continuar ...

    Después de añadir al valor 57 los siguientes dígitos: 0, 0, 1, 2, 1, 4, 8 (el número ya tendría 9 dñigitos), se intenta añadir un nuevo dígito,
    se mostraría la siguiente salida:

    *********************************************************
    * * AÑADIR DIGITO *
    **********************************************************
    NUMERO A MODIFICAR: 570012148
    EL NUMERO YA TIENE 9 DIGITOS
    ---------------------------------------------------------
    - Pulsa enter para continuar ...



    OPCION 2

    Quitar el último dígito al número actual.
    *********************************************************
    * * QUITAR DIGITO *
    *********************************************************
    *
    NUMERO A MODIFICAR: 570012148
    NUEVO NUMERO: 57001214
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    OPCION 3

    Quitar los dígitos pares. Si todos los dígitos del número actual fueran
    pares, el nuevo valor del número sería 0.

    *********************************************************
    * * QUITAR DIGITOS PARES *
    **********************************************************
    NUMERO A MODIFICAR: 57001214
    NUEVO NUMERO: 5711
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    OPCION 4

    Se muestra como resultado la suma de todos los dígitos del número actual.
    *********************************************************
    * * SUMAR DIGITOS *
    **********************************************************
    NUMERO A SUMAR SUS DIGITOS: 5711
    LA SUMA DE LOS DIGITOS DEL NUMERO ES: 14
    ---------------------------------------------------------
    - Pulsa enter para continuar ...
*/

var primerNumero = 0L
var segundoNumero = 0L
var operacion = "+"

fun main()
{

    while(true)
    {
        mostrarMenu()

        val opcion = leerOpcion()
        println()

        ejecutarAcciones(opcion, primerNumero, segundoNumero, operacion)

        if(opcion != "1" && opcion != "2" && opcion != "3" && opcion != "4" && opcion != "5")
            break
    }

    finalizarPrograma()
}

fun finalizarPrograma() {
    println("Programa finalizado.")
}

fun ejecutarAcciones(opcion: String, primerNumero: Long, segundoNumero: Long, operacion: String)
{
    when(opcion)
    {
        "1" -> mostrarNumerosYOperacion(primerNumero, segundoNumero, operacion)
        "2" -> mostrarResultado(primerNumero, segundoNumero, operacion)
        "3" -> modificarPrimerNumero()
        "4" -> modificarSegundoNumero()
        "5" -> modificarOperacion()
        else -> terminar()
    }
}



fun terminar() {
    println("Saliendo de la calculadora...")
    Thread.sleep(2000)
}

fun modificarOperacion()
{
    val s = """|*********************************************************
               |* LEER OPERACIÓN *
               |*********************************************************
               |
    """.trimMargin()

    println(s)

    while(true)
    {
        print("* ESCRIBE UNA OPERACION (+,-,*,/,%): ")
        operacion = readln()
        if(operacion == "+" || operacion == "-" || operacion == "*" || operacion == "/" || operacion == "%")
            break
        println("Error. Introduce una operación válida")
    }

    val s2 = """|OPERACION MODIFICADA
                |---------------------------------------------------------   
                |            
             """.trimMargin()

    println(s2)
    detenerEnter()
}

fun modificarSegundoNumero()
{
    segundoNumero = aplicarLogicaSubmenu(segundoNumero)
}


fun modificarPrimerNumero()
{
    primerNumero = aplicarLogicaSubmenu(primerNumero)
}

fun aplicarLogicaSubmenu(numero: Long): Long
{
    var numeroModificado = numero

    while(true)
    {
        mostrarSubmenu()
        val opcion = leerOpcion()
        numeroModificado = ejecutarAccionesSubmenu(opcion, numeroModificado)
        if(opcion != "1" && opcion != "2" && opcion != "3" && opcion != "4")
            break
    }

    println("Programa finalizado.")
    return numeroModificado
}

fun ejecutarAccionesSubmenu(opcion: String, num: Long) : Long
{
    return when (opcion)
    {
        "1" -> anadirDigito(num)
        "2" -> quitarUltimoDigito(num)
        "3" -> quitarDigitosPares(num)
        "4" -> sumarDigitos(num)
        else -> num
    }
}

fun sumarDigitos(num: Long): Long {
    TODO("Not yet implemented")
}

fun quitarDigitosPares(num: Long): Long {
    TODO("Not yet implemented")
}


fun quitarUltimoDigito(num: Long): Long {
    TODO("Not yet implemented")
}

fun anadirDigito(num : Long): Long
{
    val s = """|*********************************************************
               |* AÑADIR DÍGITO *
               |**********************************************************º
               |
               |NÚMERO A MODIFICAR: $num""".trimMargin()

    println(s)
    println("Escribe un dígito del 0 al 9 ")


    val digito = leerNumero()
    val nuevoNumero = obtenerNuevoNumero(num, digito)
    return nuevoNumero
}

fun obtenerNuevoNumero(num: Long, digito: Int)  : Long
{
    val numeroCadena = num.toString()

    if(numeroCadena.length == 9)
    {
        println("No se puede añadir el dígito $digito porque tu número ya tiene 9 dígitos: $num")
        detenerEnter()
        return num
    }

    val nuevoNumero = num * 10 + digito
    val s = """|NUEVO NUMERO: $nuevoNumero
               |---------------------------------------------------------
               |
            """.trimMargin()

    println(s)

    detenerEnter()
    return nuevoNumero
}


fun leerNumero(): Int
{
    var digito = 0

    while(true)
    {
        try
        {
            println("Introduce un número entre el 0 y el 9 (ambos incluidos).")
            digito = readln().toInt()

            if (digito >= 0 && digito <= 9)
                break

            println("Error.")

        }   catch(e: NumberFormatException)
        {
            println("Error: ${e.message}")
            println("Escribe un formato válido")
        }
    }

    return digito
}


fun mostrarSubmenu()
{
    println("""|OPCION      ACCION
               |========================================================
               |  1         Añadir digito
               |  2         Quitar ultimo digito
               |  3         Quitar digitos pares
               |  4         Sumar todos los digitos
               | otra       Terminar
               |----------------------------------------------------------
               |
    """.trimMargin())
}



fun mostrarResultado(primerNumero: Long, segundoNumero: Long, operacion: String)
{
    var resultado = 0L
    try
    {
        resultado = calcularResultado(primerNumero, segundoNumero, operacion)
    } catch (e: IllegalArgumentException)
    {
        println(e.message)
        detenerEnter()
        return
    }

    val s =
        """|*********************************************************
           |* MOSTRAR RESULTADO *
           |*********************************************************
           |
           | $primerNumero $operacion $segundoNumero = $resultado
           |
           |  OPERACION REALIZADA
           |---------------------------------------------------------""".trimMargin()

    println(s)
    detenerEnter()
}

fun calcularResultado(primerNumero: Long, segundoNumero: Long, operacion: String) : Long
{
    if (segundoNumero == 0L && operacion == "/")
       throw IllegalArgumentException("$primerNumero $operacion 0 = No se puede dividir entre 0")

    if (segundoNumero == 0L && operacion == "%")
        throw IllegalArgumentException("$primerNumero $operacion 0 = No se puede obtener el resto entre 0")

    when (operacion)
    {
        "+" -> return primerNumero + segundoNumero
        "-" -> return primerNumero - segundoNumero
        "*" -> return primerNumero * segundoNumero
        "/" -> return primerNumero / segundoNumero
        "%" -> return primerNumero % segundoNumero
    }

    return Long.MAX_VALUE
}

fun mostrarNumerosYOperacion(primerNumero: Long, segundoNumero: Long, operacion: String)
{
    val s =
        """|*********************************************************
           |* MOSTRAR NUMEROS Y OPERACION *
           |*********************************************************
            
           |PRIMER NUMERO: $primerNumero
           |SEGUNDO NUMERO: $segundoNumero
           |OPERACION: $operacion
           |---------------------------------------------------------
           |
        """.trimMargin()

    println(s)
    detenerEnter()

}

fun detenerEnter()
{
    print("Pulsa enter para continuar: ")
    readln()
}

fun leerOpcion() : String
{
    print("Elige una opción: ")
    return readln()
}

fun mostrarMenu()
{
    val s =
        """|OPCION      ACCION
           |======================================================
           |  1         Mostrar numeros y operacion
           |  2         Mostrar resultado
           |  3         Modificar primer numero
           |  4         Modificar segundo numero
           |  5         Modificar operacion
           | otra       Terminar
           | """.trimMargin()

    println(s)
}
