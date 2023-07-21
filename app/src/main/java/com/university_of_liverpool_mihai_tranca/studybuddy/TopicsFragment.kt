package com.university_of_liverpool_mihai_tranca.studybuddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TopicsFragment : Fragment() {
    private lateinit var lecture: Lecture
    private lateinit var topicsAdapter: TopicAdapter
    private lateinit var loadingProgressBar: ProgressBar
    private var studentId = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_topics, container, false)
        loadingProgressBar = view.findViewById(R.id.progressBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.visibility = View.GONE
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        topicsAdapter = TopicAdapter(lecture.topics) { topic ->
            updateTopicStatus(topic)
        }
        recyclerView.adapter = topicsAdapter
        fetchStudentInfo(studentId) { studentInfo ->
            studentInfo?.let {
                for (topicStatus in it.topics) {
                    val topic = lecture.topics.find { topic -> topic.topicId == topicStatus.topicId }
                    topic?.isCompleted = topicStatus.isComplete
                }
                loadingProgressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                topicsAdapter.notifyDataSetChanged()
            }
        }
    }
    private fun updateTopicStatus(topic: Topic) {
        val updatedTopicStatus = TopicCompletionStatus(topic.topicId, topic.isCompleted)
        updateTopicStatus(studentId, updatedTopicStatus) { success ->
            val message = if (success) "Topic updated successfully!" else "Failed to update topic!"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    fun setLecture(lecture: Lecture) {
        this.lecture = lecture
    }

}