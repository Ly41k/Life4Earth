package utils

object NavigationTree {

    enum class Splash {
        SplashScreen
    }

    enum class Onboarding {
        Onboarding
    }

    enum class Auth {
        AuthFlow, Login, Register, Forgot
    }

    enum class Main {
        Dashboard, Discover, Community, Messages, Favorite, More
    }
}
