/*
    Escribe un programa que simule la cuenta de un restaurante. Debes declarar una variable para el total de la cuenta, 
    otra para el porcentaje de propina que quieres dejar, y calcular el total final a pagar.
    Imprime el resultado en consola
*/

fun main()
{
    var totalCuenta = 0.0
    var porcentajePropina = 0


    try
    {
        totalCuenta = leerTotalCuenta()
        porcentajePropina = leerPropina()
        val totalPago = calcularPago(totalCuenta, porcentajePropina)
        imprimirPago(totalPago)

    } catch(e : NumberFormatException)
    {

        println("Error: ${e.message}")
        println("Debes introducir numeros")

    }catch (e : IllegalArgumentException)
    {
        println("Error: ${e.message}")
    } finally
    {
        println("Programa finalizado")
    }

}

fun imprimirPago(totalPago: Double)
{
    println("Total Pago: $totalPago")
}

fun calcularPago(totalCuenta: Double, porcentajePropina: Int) : Double
{
    val propina = porcentajePropina / 100.0 * totalCuenta
    return totalCuenta + propina
}

fun leerPropina() : Int
{
    println("Introduce el porcentaje de propina que quieres pagar: ")
    val propina = readln().toInt()

    if (propina < 0)
        throw IllegalArgumentException("El porcentaje de propina debe ser mayor o igual a 0")

    return propina
}

fun leerTotalCuenta() : Double
{
    println("Introduce el total de tu cuenta: ")
    val total = readln().toDouble()

    if (total <= 0)
        throw IllegalArgumentException("El total de la cuenta debe ser positivo")

    return total
}
