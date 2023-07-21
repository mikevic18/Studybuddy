package com.university_of_liverpool_mihai_tranca.studybuddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class LectureAdapter(
    private var lectures: List<Lecture>,
    private val onItemClickListener: (Lecture) -> Unit
) : RecyclerView.Adapter<LectureAdapter.LectureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lecture, parent, false)
        return LectureViewHolder(view)
    }

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        val lecture = lectures[position]
        holder.bind(lecture)
        holder.itemView.setOnClickListener { onItemClickListener(lecture) }
    }

    override fun getItemCount(): Int {
        return lectures.size
    }
    fun updateData(newLectures: List<Lecture>) {
        lectures = newLectures
        notifyDataSetChanged()
    }

    inner class LectureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lectureImage: ImageView = itemView.findViewById(R.id.lectureImage)
        private val lectureTitle: TextView = itemView.findViewById(R.id.lectureTitle)
        private val lectureDuration: TextView = itemView.findViewById(R.id.lectureDuration)

        fun bind(lecture: Lecture) {
            lectureTitle.text = lecture.title
            lectureDuration.text = lecture.duration

            // Load image using Glide from the provided URL
            Glide.with(itemView.context)
                .load(lecture.imageUrl) // Replace "imageUrl" with the URL string from Lecture data
                .centerCrop()
                .into(lectureImage)
        }
    }
}


