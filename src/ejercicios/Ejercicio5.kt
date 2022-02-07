package ejercicios

import net.xqj.exist.ExistXQDataSource

fun main() {
    val s = ExistXQDataSource();
    s.setProperty("serverName", "localhost")


    val conn = s.getConnection()
    println("Connexió feta")
    val sent = "for \$ruta in doc(\"/IdeaProjects/AccesoDatosT9/Rutes.xml\")//ruta order by \$ruta/desnivell return \$ruta"

    val cons = conn.prepareExpression (sent)
    val rs = cons.executeQuery ()

    while (rs.next())
        println(rs.getItemAsString(null))
}


