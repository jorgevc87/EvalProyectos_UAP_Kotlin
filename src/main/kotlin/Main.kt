import java.text.DecimalFormat
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.roundToInt

val decimalFomatter = DecimalFormat("#0.000")

val presupuesto = 120.00

//Listado de proyectos:
val proyectosDisponibles = arrayListOf<Proyecto>(
    Proyecto(nombre = "P1", utilidad = 24.00, costo = 16.00),
    Proyecto(nombre = "P2", utilidad = 18.00, costo = 7.00),
    Proyecto(nombre = "P3", utilidad = 49.00, costo = 30.00),
    Proyecto(nombre = "P4", utilidad = 90.00, costo = 55.00),
    Proyecto(nombre = "P5", utilidad = 73.00, costo = 35.00),
    Proyecto(nombre = "P6", utilidad = 32.00, costo = 18.00),
    Proyecto(nombre = "P7", utilidad = 55.00, costo = 31.00),
    //Proyecto(nombre = "p2", utilidad = 0.00, costo = 0.00)
)

fun main(args: Array<String>) {

    println("Presupuesto: $presupuesto")
    println("\nProyectos:")

    //Imprimir listado de proyectos
    proyectosDisponibles.forEach {
        //println("${it.nombre} - utilidad: ${it.utilidad} - costo: ${it.costo} - rentabilidad: ${it.rentabilidad}")
        println(
            "${it.nombre} - utilidad: ${decimalFomatter.format(it.utilidad)} - costo: ${decimalFomatter.format(it.costo)} - rentabilidad: ${
                decimalFomatter.format(
                    it.rentabilidad
                )
            }"
        )
    }

    //maximaUtilidad()
    maximaRentabilidad()
}

fun maximaUtilidad() {
    //Titulos
    println("\n\n---------MÉTODO MÁXIMA UTLIDAD---------")
    println("Ordenados por máxima utilidad--")
    //Ordenar proyectos deacuerdo a utilidad:
    val proyectosOrdenadosPorUtilidad = proyectosDisponibles.sortedByDescending {
        it.utilidad
    }

    //Imprimiendo proyectos ordenados por utilidad
    proyectosOrdenadosPorUtilidad.forEachIndexed { index, proyecto ->
        println(
            "${index + 1}.- ${proyecto.nombre} - utilidad: ${decimalFomatter.format(proyecto.utilidad)} - costo: ${
                decimalFomatter.format(
                    proyecto.costo
                )
            }"
        )
    }

    println("\n")

    //Inicia seleccion
    val maxUtilidad_ProyectoSeleccionados = arrayListOf<Proyecto>()
    var maxUtilidad_CostoAcumulado = 0.00
    var maxUtilidad_UtilidadAcumulada = 0.00

    proyectosOrdenadosPorUtilidad.forEachIndexed { index, proyecto ->
        println("Iteración ${index}")

        if ((maxUtilidad_CostoAcumulado + proyecto.costo) <= presupuesto) {
            maxUtilidad_CostoAcumulado += proyecto.costo
            maxUtilidad_UtilidadAcumulada += proyecto.utilidad

            maxUtilidad_ProyectoSeleccionados.add(proyecto)

            var strProyectosSeleccionado = ""
            maxUtilidad_ProyectoSeleccionados.forEach {
                strProyectosSeleccionado += "${it.nombre}, "
            }

            println(
                "Costo acumulado: ${decimalFomatter.format(maxUtilidad_CostoAcumulado)} - Utilidad acumulada: ${
                    decimalFomatter.format(
                        maxUtilidad_UtilidadAcumulada
                    )
                }"
            )

            //Obtener proyectos restantes
            val proyectosDisponiblesTemp = arrayListOf<Proyecto>()
            proyectosDisponiblesTemp.addAll(proyectosDisponibles)
            proyectosDisponiblesTemp.removeAll(maxUtilidad_ProyectoSeleccionados)
            var strProyectosRestantes = ""

            proyectosDisponiblesTemp.forEach {
                strProyectosRestantes += "${it.nombre}, "
            }

            println("Proyectos en la bolsa: $strProyectosSeleccionado - Proyectos restantes: $strProyectosRestantes\n")
        }
    }

    println("---------RESPUESTA---------")
    var strProyectosSeleccionadoRespuesta = ""
    maxUtilidad_ProyectoSeleccionados.forEach {
        strProyectosSeleccionadoRespuesta += "${it.nombre}, "
    }

    println(
        "Proyectos seleccionados: $strProyectosSeleccionadoRespuesta - Costo acumulado: ${
            decimalFomatter.format(
                maxUtilidad_CostoAcumulado
            )
        } - Utilidad acumulada: ${decimalFomatter.format(maxUtilidad_UtilidadAcumulada)}"
    )
}

fun maximaRentabilidad() {
    //Titulos
    println("\n\n---------MÉTODO MÁXIMA RENTABILIDAD---------")
    println("Ordenados por máxima rentabilidad--")
    //Ordenar proyectos deacuerdo a rentabilidad:
    val proyectosOrdenadosPorUtilidad = proyectosDisponibles.sortedByDescending {
        it.rentabilidad
    }

    //Imprimiendo proyectos ordenados por utilidad
    proyectosOrdenadosPorUtilidad.forEachIndexed { index, proyecto ->
        //println("${index + 1}.- ${proyecto.nombre} - rentabilidad: ${proyecto.rentabilidad} - utilidad: ${proyecto.utilidad} - costo: ${proyecto.costo}")
        println(
            "${index + 1}.- ${proyecto.nombre} - rentabilidad: ${decimalFomatter.format(proyecto.rentabilidad)} - utilidad: ${
                decimalFomatter.format(
                    proyecto.utilidad
                )
            } - costo: ${decimalFomatter.format(proyecto.costo)}"
        )
    }

    println("\n")

    //Inicia seleccion
    val maxUtilidad_ProyectoSeleccionados = arrayListOf<Proyecto>()
    var maxUtilidad_CostoAcumulado = 0.00
    var maxUtilidad_UtilidadAcumulada = 0.00

    proyectosOrdenadosPorUtilidad.forEachIndexed { index, proyecto ->
        println("Iteración ${index}")

        if ((maxUtilidad_CostoAcumulado + proyecto.costo) <= presupuesto) {
            maxUtilidad_CostoAcumulado += proyecto.costo
            maxUtilidad_UtilidadAcumulada += proyecto.utilidad

            maxUtilidad_ProyectoSeleccionados.add(proyecto)

            var strProyectosSeleccionado = ""
            maxUtilidad_ProyectoSeleccionados.forEach {
                strProyectosSeleccionado += "${it.nombre}, "
            }

            println(
                "Costo acumulado: ${decimalFomatter.format(maxUtilidad_CostoAcumulado)} - Utilidad acumulada: ${
                    decimalFomatter.format(
                        maxUtilidad_UtilidadAcumulada
                    )
                }"
            )

            //Obtener proyectos restantes
            val proyectosDisponiblesTemp = arrayListOf<Proyecto>()
            proyectosDisponiblesTemp.addAll(proyectosDisponibles)
            proyectosDisponiblesTemp.removeAll(maxUtilidad_ProyectoSeleccionados)
            var strProyectosRestantes = ""

            proyectosDisponiblesTemp.forEach {
                strProyectosRestantes += "${it.nombre}, "
            }

            println("Proyectos en la bolsa: $strProyectosSeleccionado - Proyectos restantes: $strProyectosRestantes\n")
        }
    }

    println("---------RESPUESTA---------")
    var strProyectosSeleccionadoRespuesta = ""
    maxUtilidad_ProyectoSeleccionados.forEach {
        strProyectosSeleccionadoRespuesta += "${it.nombre}, "
    }

    println(
        "Proyectos seleccionados: $strProyectosSeleccionadoRespuesta - Costo acumulado: ${
            decimalFomatter.format(
                maxUtilidad_CostoAcumulado
            )
        } - Utilidad acumulada: ${decimalFomatter.format(maxUtilidad_UtilidadAcumulada)}"
    )
}

data class Proyecto(
    val nombre: String, val utilidad: Double, val costo: Double, val rentabilidad: Double = utilidad / costo
)