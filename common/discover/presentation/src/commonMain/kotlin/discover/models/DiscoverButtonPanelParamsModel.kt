package discover.models

data class DiscoverButtonPanelParamsModel(
    val padding: Int,
    val itemSize: Int,
    val iconSize: Int = itemSize - padding,
    val icon: DiscoverButtonIcons,
    val durationMillis: Int,
)

data class DiscoverButtonPanelModel(
    val buttonQuantity: Int = 0,
    val items: List<ParamsModel> = emptyList()
) {
    data class ParamsModel(
        val icon: DiscoverButtonIcons,
        val durationMillis: Int,
    )
}
