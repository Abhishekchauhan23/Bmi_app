package ab.sample.bottom_nav2.Utils

object BmiCalculator {

    fun Calculation(Height:Double,Weight:Double):Double{
        val OutputValue:Double=Weight/Height
        return OutputValue
    }
}