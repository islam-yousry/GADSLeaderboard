package com.example.gadsleaderboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboard.Model.Hours
import com.example.gadsleaderboard.Service.NetworkCalls
import com.example.gadsleaderboard.ViewModel.LeaderBoardViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HoursFragment : Fragment() {

    private lateinit var viewModel: LeaderBoardViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_hours,container,false)

        val hoursAdapter = HoursAdapter()
        val learningLeadersRecycleView: RecyclerView = rootView.findViewById(R.id.hours_recycle_view)
        learningLeadersRecycleView.apply{
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = hoursAdapter
        }


        viewModel = ViewModelProvider(this).get(LeaderBoardViewModel::class.java)
        viewModel.getHoursList()?.observe(viewLifecycleOwner,object: Observer<List<Hours>> {
            override fun onChanged(hoursList: List<Hours>) {
                hoursAdapter.sumbitList(hoursList)
                hoursAdapter.notifyDataSetChanged()
            }
        })

        return rootView
    }
}