package com.example.sabersenior.CacaPalavra

import java.io.Serializable

class Game(
    val puzzle : Array<Array<Char>>,
    val words : Array<String>
) : Serializable