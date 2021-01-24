package com.example.stcchallenge.ui.fragments.senatorsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.stcchallenge.R
import com.example.stcchallenge.adapters.SenatorsAdapter
import com.example.stcchallenge.databinding.FragmentSenatorsListBinding
import com.example.stcchallenge.models.Senator
import kotlinx.android.synthetic.main.fragment_senators_list.*

class SenatorsListFragment : Fragment(), SenatorsListPresenter.View {

    companion object {
        const val ARG_SENATOR = "arg_senator"
    }

    private lateinit var presenter: SenatorsListPresenter
    private val senatorsAdapter = SenatorsAdapter()
    private var binding: FragmentSenatorsListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SenatorsListPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding?.root == null) {
            binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_senators_list, container, false
            )
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (senatorsAdapter.isEmpty()) {
            senatorsAdapter.onSenatorClick = {
                findNavController().navigate(
                    R.id.action_senatorsListFragment_to_senatorDetailsFragment,
                    Bundle().apply { putSerializable(ARG_SENATOR, it) })
            }

            initViews()
            presenter.getSenatorsList(requireContext(), viewLifecycleOwner)
        }
    }

    private fun initViews() {
        rv_senators.apply {
            setItemViewCacheSize(20)
            adapter = senatorsAdapter
        }
    }

    override fun updateList(newList: ArrayList<Senator>) {
        senatorsAdapter.updateList(newList)
    }
}