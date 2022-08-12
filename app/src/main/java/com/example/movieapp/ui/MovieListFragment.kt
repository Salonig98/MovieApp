package com.example.movieapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.adapter.MovieAdapter
import com.example.movieapp.api.MovieService
import com.example.movieapp.api.RetrofitHelper
import com.example.movieapp.database.MovieDatabase
import com.example.movieapp.databinding.FragmentMovieListBinding
import com.example.movieapp.model.Result
import com.example.movieapp.repository.MovieRepository
import com.example.movieapp.viewmodel.MovieViewModel
import com.example.movieapp.viewmodel.ViewModelFactory

class MovieListFragment : Fragment(), MovieAdapter.MovieClickInterface {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()
        setUpAdapter()
        setUpViewModel()
    }

    private fun setUpRecyclerView() {
        binding.idRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setUpAdapter() {
        movieAdapter = MovieAdapter(requireContext(), this)
        binding.idRecyclerView.adapter = movieAdapter
    }

    private fun setUpViewModel() {
        val movieService = RetrofitHelper.getInstance().create(MovieService::class.java)
        val database = MovieDatabase.getDatabase(requireContext())
        val repository = MovieRepository(movieService, database, requireContext())
        movieViewModel =
            ViewModelProvider(this, ViewModelFactory(repository))[MovieViewModel::class.java]
        movieViewModel.movies.observe(viewLifecycleOwner) {
            movieAdapter.setMovieList(it.results)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMovieClick(result: Result) {
        val action =
            MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(result)
        findNavController().navigate(action)
    }

}




