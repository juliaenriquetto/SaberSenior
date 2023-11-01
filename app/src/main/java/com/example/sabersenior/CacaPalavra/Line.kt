package com.example.sabersenior.CacaPalavra

import android.graphics.Paint
import android.graphics.PointF

class Line(
    val start : PointF,
    val end : PointF,
    val paint : Paint
) {
    val isPoint get() = start.x == end.x && start.y == end.y
}