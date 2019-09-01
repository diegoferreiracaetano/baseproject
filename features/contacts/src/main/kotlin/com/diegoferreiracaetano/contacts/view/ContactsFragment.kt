package com.diegoferreiracaetano.contacts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.diegoferreiracaetano.contacts.R
import com.diegoferreiracaetano.contacts.applyBackground
import com.diegoferreiracaetano.domain.user.User
import kotlinx.android.synthetic.main.fragment_contacts.contact_recycle
import kotlinx.android.synthetic.main.fragment_contacts.searchView
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactsFragment : Fragment() {

    val vm: ContactsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.fetchContacts()
        setupAdapter()
        setupSearchView()
    }

    private fun setupSearchView() {
        searchView.applyBackground()
        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Your Logic
                return false
            }
        })
    }

    private fun setupAdapter() {
        vm.contacts.observe(this, Observer {
            it.onSuccess(::showUser)
                .onFailure(::showError)
        })
    }

    private fun showUser(users: List<User>) {
        contact_recycle.adapter = ConstactsAdapter(users)
    }

    private fun showError(error: Throwable) {
        Toast.makeText(requireContext(), R.string.contacts_msg_error, Toast.LENGTH_LONG).show()
    }
}