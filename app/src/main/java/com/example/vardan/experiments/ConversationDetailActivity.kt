package com.example.vardan.experiments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.vardansharma.simplesttodoappever.utils.inflate
import kotlinx.android.synthetic.main.activity_conversation_detail.*

class ConversationDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation_detail)
        toolbar.title = "Puma shoes"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        chat_recyclerview.layoutManager = LinearLayoutManager(this)
        chat_recyclerview.adapter = ChatAdapter()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        super.onStop()
    }


    class ChatAdapter : RecyclerView.Adapter<ChatVH>() {
        override fun getItemCount(): Int = 100

        override fun onBindViewHolder(holder: ChatVH, position: Int) {
            holder.text.text = position.toString()
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ChatVH {
            val view = parent!!.inflate(R.layout.item_chat)
            return ChatVH(view)
        }
    }

    class ChatVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView!!.findViewById(R.id.txt_chat_msg)

    }
}