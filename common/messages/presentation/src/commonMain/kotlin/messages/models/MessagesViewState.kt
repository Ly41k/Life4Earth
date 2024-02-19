package messages.models

data class MessagesViewState(
    val messageGroup: List<MessageGroupItem> = getMockkData()
)

private fun getMockkData(): List<MessageGroupItem> {
    return listOf(
        MessageGroupItem(
            groupName = "Kotlin Developing g g jkgjhfhjk hdfgh dfhkg dfkgh dkfgh kdfhg kdfhg hdhgk dhkfg hghh dkhfghk dfg",
            latestChanges = "12.01.2024",
            latestMessage = "Last message dfjkhg hdfhjgh dfgh fghk dfkhg dhkfgh dfgh d hgdkfgh dkfg dfgh kdkgh ",
            lastMessageStatus = MessageStatusTypes.SENT,
            unreadCount = 5
        ),

        MessageGroupItem(
            firstName = "Joseph",
            lastName = "Davis",
            latestChanges = "Yesterday",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.NONE,
            unreadCount = 5
        ),

        MessageGroupItem(
            groupName = "Aurora Developers",
            latestChanges = "12.01.2024",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.SENT,
            unreadCount = 0
        ),

        MessageGroupItem(
            firstName = "Jack",
            lastName = "Nicholson",
            latestChanges = "Feb. 12",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.READ,
            unreadCount = 5
        ),

        MessageGroupItem(
            firstName = "Marlon",
            lastName = "Brando",
            latestChanges = "08:82",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.NONE,
            unreadCount = 5
        ),

        MessageGroupItem(
            firstName = "Al",
            lastName = "Pacino",
            latestChanges = "Yesterday",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.READ,
            unreadCount = 5
        ),

        MessageGroupItem(
            firstName = "Tom",
            lastName = "Hanks",
            latestChanges = "17:39",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.SENT,
            unreadCount = 5
        ),

        MessageGroupItem(
            firstName = "Paul",
            lastName = "Newman",
            latestChanges = "Yesterday",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.READ,
            unreadCount = 5
        ),

        MessageGroupItem(
            groupName = "React Developers",
            latestChanges = "12.01.2024",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.SENT,
            unreadCount = 999
        ),

        MessageGroupItem(
            groupName = "Android Developers",
            latestChanges = "12.01.2024",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.SENT,
            unreadCount = 33
        ),

        MessageGroupItem(
            groupName = "Java Developers",
            latestChanges = "12.01.2024",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.SENT,
            unreadCount = 555
        ),

        MessageGroupItem(
            groupName = "MultiPlatform Developers",
            latestChanges = "12.01.2024",
            latestMessage = "Last message",
            lastMessageStatus = MessageStatusTypes.SENT,
            unreadCount = 1000
        )
    )
}
