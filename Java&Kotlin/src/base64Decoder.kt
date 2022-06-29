import org.apache.commons.codec.binary.Base64

fun main(args: Array<String>) {


    val string =
        "IyBCYXNlYmFsbEdhbWUK7J6Q67CUIFN3aW5n7J2EIOyCrOyaqe2VmOyXrCDs\\noJzsnpHtlZwg7Iir7J6Q7JW86rWs6rKM7J6ECg=="


    val charset = charset("UTF-8")

    val a = String(Base64.decodeBase64(string),charset)


    println(a)
}