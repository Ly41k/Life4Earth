package repositories

interface AuthRepository {
    fun login(login: String, password: String)
}
