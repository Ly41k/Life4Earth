package messages.models

data class MessageGroupItem(
    val firstName: String? = null,
    val lastName: String? = null,
    val groupName: String? = null,
    val isGroup: Boolean = groupName != null,
    val latestChanges: String,
    val latestMessage: String,
    val lastMessageStatus: MessageStatusTypes = MessageStatusTypes.NONE,
    val unreadCount: Int = 0
) {

    fun getAcronyms(): String {
        return (groupName?.let { getGroupNameAcronyms() } ?: getNameAcronyms()).uppercase()
    }

    fun getTitle(): String {
        return if (isGroup) {
            groupName ?: "NoName Group" //TODO Need to use shared resources
        } else {
            getFullName()
        }
    }

    private fun getFullName(): String {
        return "$lastName $lastName".trim()
    }

    private fun getNameAcronyms(): String {
        return firstName?.firstOrNull()?.let { firstLetter ->
            lastName?.firstOrNull()?.let { secondLetter -> "$firstLetter$secondLetter" }
        } ?: lastName?.firstOrNull()?.toString().orEmpty()
    }

    private fun getGroupNameAcronyms(): String {
        return groupName?.firstOrNull().toString()
    }

    fun getUnreadMessageCount(): String? {
        return when {
            unreadCount <= 0 -> null
            unreadCount in 1..99 -> unreadCount.toString()
            else -> "99+" //TODO Need to use shared resources
        }
    }
}

enum class MessageStatusTypes {
    NONE, SENT, DELIVERED, READ
}
