package naviagation

abstract class BaseNavigation(
    open val route: String,
    open val objectName: String = "",
    open val objectPath: String = ""
)
