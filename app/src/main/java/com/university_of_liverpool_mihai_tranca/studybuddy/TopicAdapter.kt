package com.university_of_liverpool_mihai_tranca.studybuddy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicAdapter(
    private val topics: List<Topic>,
    private val onCheckedChangeListener: (Topic) -> Unit
) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topic, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        holder.bind(topic)
        holder.topicCheckBox.setOnCheckedChangeListener(null) // Avoid triggering listener during recycling
        holder.topicCheckBox.isChecked = topic.isCompleted
        holder.topicCheckBox.setOnCheckedChangeListener { _, isChecked ->
            topic.isCompleted = isChecked
            onCheckedChangeListener(topic)
        }
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    inner class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val topicTitle: TextView = itemView.findViewById(R.id.topicTitle)
        val topicCheckBox: CheckBox = itemView.findViewById(R.id.topicCheckBox)

        fun bind(topic: Topic) {
            topicTitle.text = topic.title
        }
    }
}

