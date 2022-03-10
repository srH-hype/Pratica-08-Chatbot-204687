package imperial.heriberto.chatbot.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import imperial.heriberto.chatbot.R
import imperial.heriberto.chatbot.data.Message
import imperial.heriberto.chatbot.utils.Constans.SEND_ID
import imperial.heriberto.chatbot.utils.Constans.RECEIVE_ID
import kotlinx.android.synthetic.main.message_item.view.*

class MessangingAdapter:RecyclerView.Adapter<MessangingAdapter.MessageViewHoLder>() {
    var messagelist = mutableListOf<Message>()

    inner class MessageViewHoLder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHoLder{
        return MessageViewHoLder(LayoutInflater.from(parent.context).inflate(R.layout.message_item,parent,false))
    }
    override fun onBindViewHolder(holder: MessageViewHoLder, position: Int) {

        val currentMessage=messagelist[position]

        when (currentMessage.id) {
            SEND_ID->{
                holder.itemView.tv_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility = View.GONE
            }
            RECEIVE_ID->{
                holder.itemView.tv_bot_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.visibility = View.GONE
            }
        }
    }
    override fun getItemCount (): Int {
        return messagelist.size
    }

    fun insertMessage(message:Message){
        this.messagelist.add(message)
        notifyItemInserted(messagelist.size)
        notifyDataSetChanged()
    }

}
