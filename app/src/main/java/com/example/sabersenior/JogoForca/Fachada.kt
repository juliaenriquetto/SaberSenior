package com.example.sabersenior.JogoForca

class Fachada {
    private var banquitoPalavras = BancoDePalavras()
    private lateinit var jogo: JogoDaForca

    fun Padrao() {
        this.banquitoPalavras.adiciona("Computador", "Inovação")
        this.banquitoPalavras.adiciona("Moto", "Veículo")
        this.banquitoPalavras.adiciona("Cachorro", "Animal")
        this.banquitoPalavras.adiciona("Jabuti", "Animal")
        this.banquitoPalavras.adiciona("Carro", "Veículo")
        this.banquitoPalavras.adiciona("Celular", "Inovação")
        this.banquitoPalavras.adiciona("Chave", "Segredo")
        this.banquitoPalavras.adiciona("Oculos", "Acessório")
        this.banquitoPalavras.adiciona("Cadeira", "Objeto")
    }

    fun start() {
        this.banquitoPalavras.sorteio()
        jogo = JogoDaForca(this.banquitoPalavras.palavrita(), this.banquitoPalavras.Dicaa())
        jogo.start()
    }

    fun diquinha(): String {
        var output = ""
        output += "Dica: ${jogo.getDica()}"

        return output
    }

    fun palavrota(): String {
        var output = ""
        output += "Palavra: ${jogo.getPalavra()}"

        return output
    }

    fun infos(): String {
        var output = ""

        output += "Tamanho da palavra: ${jogo.getTamanho()}\n"
        output += "Letras diferentes:   ${jogo.LetrasDistintas()}\n"
        output += "Letras utilizadas:      [${jogo.getLetrasUsadas()}]\n"
        output += "Tentativas:         ${jogo.getTentativas()}\n"
        output += "Acertos:            ${jogo.getAcertos()}\n"

        return output
    }

    fun jogar(letra: String) {
        try {
            jogo.Adivinhar(letra)
        }
        catch (e: Throwable) {
            println(e.message)
        }
    }

    fun terminou(): Boolean {
        return jogo.terminou()
    }
}