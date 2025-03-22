package org.polihania.harrypotter.core.ui_kit.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun LoadingContent() {
    Column {
        ShimmerItem(
            modifier = Modifier.padding(bottom = 16.dp),
            style = ShimmerStyle(
                fieldHeight = 24.dp,
                fieldSpacing = 16.dp,
                isCard = true
            )
        )
        ShimmerItem(
            style = ShimmerStyle(
                fieldHeight = 32.dp,
                fieldSpacing = 16.dp,
                fieldCount = 3,
                isCard = true
            )
        )
    }
}


@Composable
fun ShimmerItem(
    modifier: Modifier = Modifier,
    style: ShimmerStyle = ShimmerStyle(),
) {
    val backgroundModifier = getBackgroundModifier(modifier, style)

    Row(backgroundModifier) {
        ShimmerBox(size = 36.dp)
        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            ShimmerFields(style)
        }
    }
}

@Composable
private fun getBackgroundModifier(
    modifier: Modifier,
    style: ShimmerStyle,
): Modifier {
    val backgroundColor = MaterialTheme.colorScheme.background
    return if (style.isCard) {
        modifier
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .padding(16.dp)
    } else {
        modifier
            .background(backgroundColor)
            .padding(16.dp)
    }
}

@Composable
private fun ShimmerBox(size: Dp) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .shimmerEffect()
    )
}

@Composable
private fun ShimmerFields(style: ShimmerStyle) {
    repeat(style.fieldCount) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(style.fieldHeight)
                .clip(CircleShape)
                .shimmerEffect()
        )
        if (it < style.fieldCount - 1) {
            Spacer(modifier = Modifier.height(style.fieldSpacing))
        }
    }
}

fun Modifier.shimmerEffect(
    colors: List<Color> = listOf(Color(0xFFCACACA), Color(0xFFF5F5F5))
): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(label = "")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ), label = ""
    )

    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}

@Immutable
data class ShimmerStyle(
    val fieldHeight: Dp = 16.dp,
    val fieldSpacing: Dp = 6.dp,
    val fieldCount: Int = 2,
    val isCard: Boolean = false,
)
