/*
    Hágase un programa que permita gestionar el inventario de una pequeña tienda. El programa debe permitir registrar productos,
    consultar el stock, modificar cantidades y eliminar artículos.
    Cada producto en el sistema debe almacenar obligatoriamente la siguiente información:

    ID: Un número entero único que identifica al producto (ej. 101).
    Nombre: El nombre del artículo (texto).
    Precio: Un número decimal positivo que representa el valor unitario.
    Cantidad: Un número entero positivo o cero que representa el stock disponible.


    MENÚ PRINCIPAL

    En el programa principal se tendrá un menú continuo con las siguientes características:

    OPCION   ACCION
    ======================================================
       1     Añadir nuevo producto
       2     Mostrar inventario completo
       3     Buscar producto por nombre
       4     Actualizar stock de un producto
       5     Eliminar producto
     otra    Terminar


    OPCIÓN 1: Añadir nuevo producto

    Se pedirán los datos del producto por consola. Si el ID introducido ya existe en el sistema, se debe mostrar un error y
    cancelar la operación. Si el ID es nuevo, el producto se registra.

    *********************************************************
    * AÑADIR NUEVO PRODUCTO *
    *********************************************************
    INTRODUCE EL ID (NUMERO): 101
    INTRODUCE EL NOMBRE: Teclado Mecanico
    INTRODUCE EL PRECIO: 45.50
    INTRODUCE LA CANTIDAD: 10

    PRODUCTO REGISTRADO CORRECTAMENTE.
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    Comportamiento de error (si el ID 101 ya existiera):

    ERROR: YA EXISTE UN PRODUCTO CON EL ID 101. OPERACION CANCELADA.


    OPCIÓN 2: Mostrar inventario completo

    Se mostrará una lista con todos los productos registrados, junto con el valor total del inventario
    (la suma de multiplicar el precio por la cantidad de cada producto).
    Si no hay productos, se informará de ello.

    *********************************************************
    * INVENTARIO COMPLETO *
    *********************************************************
    ID: 101 | NOMBRE: Teclado Mecanico | PRECIO: 45.5 | STOCK: 10
    ID: 102 | NOMBRE: Raton Inalambrico | PRECIO: 20.0 | STOCK: 5
    ID: 105 | NOMBRE: Monitor 24" | PRECIO: 120.0 | STOCK: 0

    VALOR TOTAL DEL INVENTARIO: 555.0 EUROS
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    OPCIÓN 3: Buscar producto por nombre

    Se pedirá al usuario que escriba un texto. El programa mostrará todos los productos cuyo nombre coincida exactamente
    con el texto introducido (ignorando si se escribió en mayúsculas o minúsculas).

    *********************************************************
    * BUSCAR PRODUCTO *
    *********************************************************
    ESCRIBE EL NOMBRE A BUSCAR: raton inalambrico

    RESULTADO ENCONTRADO:
    ID: 102 | NOMBRE: Raton Inalambrico | PRECIO: 20.0 | STOCK: 5
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    Si no se encuentra nada:

    NO SE HA ENCONTRADO NINGUN PRODUCTO CON ESE NOMBRE.


    OPCIÓN 4: Actualizar stock
    Se solicitará el ID del producto que se desea modificar. Si el ID no existe, se muestra un error.
    Si existe, se preguntará la nueva cantidad disponible (que no puede ser negativa) y se actualizará.

    *********************************************************
    * ACTUALIZAR STOCK *
    *********************************************************
    INTRODUCE EL ID DEL PRODUCTO: 101
    PRODUCTO ACTUAL: Teclado Mecanico (Stock: 10)
    INTRODUCE EL NUEVO STOCK: 15

    STOCK ACTUALIZADO CORRECTAMENTE.
    ---------------------------------------------------------
    - Pulsa enter para continuar ...


    OPCIÓN 5: Eliminar producto

    Se pedirá el ID del producto a borrar. Si el ID existe, se elimina el producto del sistema.
    Si no existe, se notifica el error.

    *********************************************************
    * ELIMINAR PRODUCTO *
    *********************************************************
    INTRODUCE EL ID DEL PRODUCTO A BORRAR: 105
    PRODUCTO 'Monitor 24"' ELIMINADO DEL SISTEMA.
    ---------------------------------------------------------
    - Pulsa enter para continuar ...
*/


class Producto(val id:Int, val nombre: String, var precio: Double, var cantidad:Int)
{



}

fun main()
{
    val productos = crearListaProductos()
    
    while(true)
    {
        mostrarMenuInventario()
        val opcion = elegirOpcion()
        ejecutarAccionesInventario(opcion, productos)
        if (opcion != "1" && opcion != "2" && opcion != "3" && opcion != "4" && opcion != "5")
            break
    }

    finalizarEjecucion()
}

fun crearListaProductos() : MutableList<Producto>
{
    return mutableListOf()
}

fun finalizarEjecucion()
{
    println("Programa finalizado")
}

fun elegirOpcion() : String
{
    print("Elige una opción: ")
    return readln()
}

fun ejecutarAccionesInventario(o: String, productos: MutableList<Producto>)
{
    when(o)
    {
        "1" -> anadirProducto(productos)
        "2" -> mostrarInventario(productos)
        "3" -> buscarProducto(productos)
        "4" -> actualizarStockProducto(productos)
        "5" -> eliminarProducto(productos)
        else -> terminar()
    }
}

fun eliminarProducto(productos: MutableList<Producto>)
{

}

fun actualizarStockProducto(productos: MutableList<Producto>)
{

}

fun buscarProducto(productos: MutableList<Producto>)
{

}

fun mostrarInventario(productos: MutableList<Producto>)
{

}

fun anadirProducto(productos: MutableList<Producto>)
{

}

private fun mostrarMenuInventario()
{
    val s = """|OPCION   ACCION
               |======================================================
               |   1     Añadir nuevo producto
               |   2     Mostrar inventario completo
               |   3     Buscar producto por nombre
               |   4     Actualizar stock de un producto
               |   5     Eliminar producto
               |  otra   Terminar""".trimMargin()

    println(s)
}

private fun terminar()
{
    println("Saliendo del inventario...")
    Thread.sleep(2000)
}