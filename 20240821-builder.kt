fun main() {
    var email = Email(
}

class Email(
    var remetente: String,
    var destinatario: String,
    var cc: List<String>?,
    var assunto: String?,
    var mensagem: String?,
    var anexos: List<java.io.File>?
) {
    fun enviar() {
        println("Enviando email $remetente para $destinatario")
    }
}
