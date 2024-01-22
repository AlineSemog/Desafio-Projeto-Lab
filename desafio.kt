
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String, val nivelExperiencia: Nivel)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val descricao: String = "")

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {
    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 45, "Fundamentos básicos.")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 60, "Princípios de OOP.")

    val formacaoKotlin = Formacao("Formação Kotlin")
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    val usuario1 = Usuario("Dhiego", "dhiego@email.com", Nivel.BASICO)
    val usuario2 = Usuario("Aline", "aline@email.com", Nivel.INTERMEDIARIO)

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)


    formacaoKotlin.removerConteudo(conteudo1)

 
    println("Inscritos na formação ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nome }}")
}
