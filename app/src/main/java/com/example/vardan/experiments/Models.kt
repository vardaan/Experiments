package com.myntra.android.saha

data class Member(val name: String, val id: String)

data class Conversation(val id: String, val title: String, val imageUrl: String, val members: List<Member> = emptyList())
