import org.apache.commons.codec.binary.Base64

fun main(args: Array<String>) {


    val string =
        "TlNM7J2YIOuqqOuwlOydvCDslrTtlIzrpqzsvIDsnbTshZgg7KCA7J6l7IaM7J6F64uI64ukLgpHaXRodWIgQVBJIO2FjOyKpO2KuOulvCDsnITtlZwgUmVhZG1lIOyehOyLnCDtjpjsnbTsp4Ag7J6F64uI64ukLgo="


    val charset = charset("UTF-8")

    val a = String(Base64.decodeBase64(string),charset)


    println(a)
}