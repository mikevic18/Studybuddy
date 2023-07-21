package com.university_of_liverpool_mihai_tranca.studybuddy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class LecturesFragment : Fragment() {

    private lateinit var lecturesAdapter: LectureAdapter
    private lateinit var loadingProgressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lectures, container, false)
        loadingProgressBar = view.findViewById(R.id.progressBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingProgressBar.visibility = View.VISIBLE
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.visibility = View.GONE
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        lecturesAdapter = LectureAdapter(emptyList()) { lecture ->
            openTopicsFragment(lecture)
        }
        recyclerView.adapter = lecturesAdapter

        fetchLectures { lectures ->
            if (lectures != null) {
                lecturesAdapter.updateData(lectures)
                loadingProgressBar.visibility=View.GONE
                recyclerView.visibility=View.VISIBLE
            } else {
                Toast.makeText(requireContext(), "Failed to fetch lectures", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun openTopicsFragment(lecture: Lecture) {
        val topicsFragment = TopicsFragment()
        topicsFragment.setLecture(lecture)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, topicsFragment)
            .addToBackStack(null)
            .commit()
    }

}
