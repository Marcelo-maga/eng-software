fun main() {
    var email1 = EmailV1(
        "marcelomaga@gmail.com",
        "marcos@gmail.com",
        null,
        null,
        null,
        null
    )

    email1.enviar();

    var email2 = EmailV2("marcelomaga@gmail.com", "marcos@gmail.com")
    email2.enviar();

    var email3 = EmailBuilder()
        .remetente("marcelomaga@gmail.com")
        .destinatario("marcos@gmail.com")
        .cc(listOf("marcelomaga@gmail.com"))
        .assunto("teste")
        .mensagem("teste")
        .anexos(listOf(java.io.File("teste.txt")))
        .build()

    email3.enviar();
}

class EmailV1(
    // Problema 1: exesso de parametros no construtor
    // Problema 2: construtor "misteriosos" para quem vizualiza o construtor
    // Problema 3: parametros opcionais devem ser colocas mesmo assim, null
    // Problema 4: na maioria das linguagens, os parametros tem q ser colocados na ordem exatas
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

class EmailV2(
    // Com valores default (padrão) para os parametros opcionais
    var remetente: String = "",
    var destinatario: String = "",
    var cc: List<String> = listOf(),
    var assunto: String = "",
    var mensagem: String = "",
    var anexos: List<java.io.File> = listOf()
) {
    fun enviar() {
        println("Enviando email V2 $remetente para $destinatario")
    }
}

class EmailBuilder() {
    private var email: EmailV2 = EmaialV2()

    fun build(): EmailV2 {
        return email
    }

    fun remetente(remetente: String): EmailBuilder {
        email.remetente = remetente
        return this
    }

    fun destinatario(destinatario: String): EmailBuilder {
        email.destinatario = destinatario
        return this
    }

    fun cc(cc: List<String>): EmailBuilder {
        email.cc = cc
        return this
    }

    fun assunto(assunto: String): EmailBuilder {
        email.assunto = assunto
        return this
    }

    fun mensagem(mensagem: String): EmailBuilder {
        email.mensagem = mensagem
        return this
    }

    fun anexos(anexos: List<java.io.File>): EmailBuilder {
        email.anexos = anexos
        return this
    }
}
