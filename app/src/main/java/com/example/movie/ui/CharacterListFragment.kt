package com.example.movie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.movie.BreakingBadApplication
import com.example.movie.R
import com.example.movie.model.BBCharacter
import com.example.movie.ui.util.CharacterListAdapter

class CharacterListFragment : Fragment(){
   lateinit var adapter :CharacterListAdapter

    private val characterListViewModel: CharacterListViewModel by viewModels {
        //CharacterListViewModelFactory((requireActivity().application as BreakingBadApplication).characterRepository)
        CharacterListViewModelFactory((requireActivity().application as BreakingBadApplication).characterRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.characterRecyclerView)
//        val adapter = CharacterListAdapter { character ->
//
//        }
      //  recyclerView.adapter = adapter

        recyclerView.layoutManager=LinearLayoutManager(context)
        characterListViewModel.characterLivedata.observe(viewLifecycleOwner, { characters ->
            adapter = CharacterListAdapter(openDetails = ::openDetails)
            adapter.setCharacterList(characters)
            recyclerView.adapter = adapter
        })

        val refreshLayout =  requireActivity().findViewById<SwipeRefreshLayout>(R.id.refresh_layout)
        refreshLayout.setOnRefreshListener {
            characterListViewModel.refreshDataFromRepository()
            Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show()
            refreshLayout.isRefreshing = false
        }
    }

    private fun openDetails(bbCharacter: BBCharacter) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container,CharacterListFragment())
            .addToBackStack(null)
            .commit()
    }
}