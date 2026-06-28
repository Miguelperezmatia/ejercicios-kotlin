/*
    Crea un pequeño sistema de gestión del estado de pedidos.
    Implementa una clase que defina un pedido con las siguientes características:

    - El pedido tiene un identificador y un estado.

    - El estado es un Enum con estos valores: PENDIENTE, ENVIADO, ENTREGADO y CANCELADO.

    - Implementa las funciones que sirvan para modificar el estado:
        - Pedido enviado
        - Pedido cancelado
        - Pedido entregado

    - Implementa una función para mostrar un texto descriptivo según el estado actual.

    - Crea diferentes pedidos y muestra cómo se interactúa con ellos.
*/

enum class Estado
{
    PENDIENTE,
    ENVIADO,
    ENTREGADO,
    CANCELADO
}

class Pedido (val identificador : Int, var estado: Estado)
{
    fun enviarPedido()
    {
        when (estado)
        {
            Estado.ENVIADO -> println("No se puede enviar el pedido porque el envío ya ha sido mandado al cliente")
            Estado.ENTREGADO -> println("No se puede enviar el pedido porque el cliente ya lo ha recibido")
            Estado.CANCELADO -> println("No se puede enviar el pedido porque el cliente lo ha cancelado")
            Estado.PENDIENTE ->
                {
                    println("Enviando el pedido...")
                    Thread.sleep(2000)
                    println("Pedido enviado")
                    estado = Estado.ENVIADO
                }

        }

        println(mostrarPedido())

    }

    fun cancelarPedido()
    {
        when (estado)
        {
            Estado.CANCELADO -> println("No se puede cancelar el pedido porque el sistema ya lo había cancelado con anterioridad")
            Estado.ENTREGADO -> println("No se puede cancelar el pedido porque el cliente ya lo ha recibido")

            Estado.ENVIADO, Estado.PENDIENTE ->
            {
                println("Cancelando el pedido...")
                Thread.sleep(2000)
                println("Pedido cancelado")
                estado = Estado.CANCELADO
            }
        }

        println(mostrarPedido())

    }

    fun entregarPedido()
    {
        when (estado)
        {
            Estado.ENTREGADO -> println("No se puede entregar el pedido porque ya ha sido entregado al cliente")
            Estado.CANCELADO -> println("No se puede entregar el pedido porque ya había sido cancelado con anterioridad")
            Estado.PENDIENTE -> println("No se puede entregar el pedido. Primero hay que enviarlo")

            Estado.ENVIADO ->
            {
                println("Entregando el pedido...")
                Thread.sleep(2000)
                println("Pedido entregado")
                estado = Estado.ENTREGADO
            }

        }
            println(mostrarPedido())
    }

    fun mostrarPedido(): String
    {
        return "Pedido: Identificador: $identificador, estado: $estado"
    }
}

fun main()
{
    val pedidoUno = Pedido(1, Estado.ENVIADO)
    pedidoUno.entregarPedido()

    val pedidoDos = Pedido(2, Estado.PENDIENTE)
    pedidoDos.enviarPedido()
    pedidoDos.entregarPedido()


    val pedidoTres = Pedido(3, Estado.CANCELADO)
    pedidoTres.cancelarPedido()

    val pedidoCuatro = Pedido(4, Estado.ENTREGADO)
    pedidoCuatro.cancelarPedido()
}

