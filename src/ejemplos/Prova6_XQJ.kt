package ejemplos



import net.xqj.exist.ExistXQDataSource
import org.w3c.dom.Element

fun main() {
    val s = ExistXQDataSource()
    s.setProperty("serverName", "89.36.214.106")
    val conn = s.getConnection()
    val sent ="for \$alumne in //alumne order by \$alumne/cognoms return \$alumne"

    val cons = conn.prepareExpression (sent)

    val rs = cons.executeQuery ()
    while (rs.next()) {
        val el = rs.getObject () as Element
        print(el.getElementsByTagName("nom").item(0).getFirstChild().getNodeValue() + " ")
        print(el.getElementsByTagName("cognoms").item(0).getFirstChild().getNodeValue() + ": ")
        println(el.getElementsByTagName("nota").item(0).getFirstChild().getNodeValue())
    }
    conn.close()
}

