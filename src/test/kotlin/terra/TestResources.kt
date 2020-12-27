package terra

object TestResources {

    fun resourceAsStringRelativeTo(path: String, clazz: Class<*>): String =
            clazz.getResource(path).readText()

}