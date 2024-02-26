import ktor.ktorModule
import org.koin.dsl.module

val coreModule = module {
    includes(ktorModule)
}