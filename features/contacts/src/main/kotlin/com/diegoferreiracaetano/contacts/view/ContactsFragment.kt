package com.diegoferreiracaetano.contacts.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView.GONE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.diegoferreiracaetano.contacts.R
import com.diegoferreiracaetano.contacts.applyBackground
import com.diegoferreiracaetano.domain.user.User
import kotlinx.android.synthetic.main.fragment_contacts.contact_container
import kotlinx.android.synthetic.main.fragment_contacts.contact_error
import kotlinx.android.synthetic.main.fragment_contacts.contact_recycle
import kotlinx.android.synthetic.main.fragment_contacts.searchView
import kotlinx.android.synthetic.main.fragment_contacts_loading.shimmer_view_container
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class ContactsFragment : Fragment() {

    private val viewModel: ContactsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startShimmer()
        setupAdapter()
        setupSearchView()
    }

    override fun onStop() {
        super.onStop()
        stopShimmer()
    }

    private fun setupSearchView() {
        searchView.applyBackground()
    }

    private fun setupAdapter() {
        viewModel.contacts.observe(this, Observer {
            it.onSuccess(::showUser)
                .onFailure(::showError)
        })
    }

    private fun startShimmer() {
        contact_error.visibility = GONE
        contact_container.visibility = VISIBLE
        shimmer_view_container.startShimmer()
        viewModel.fetchContacts()
    }

    private fun stopShimmer() {
        shimmer_view_container.visibility = GONE
        shimmer_view_container.stopShimmer()
    }

    private fun showUser(users: List<User>) {
        stopShimmer()
        contact_recycle.adapter = ConstactsAdapter(users)
    }

    private fun showError(error: Throwable) {
        stopShimmer()
        contact_error.visibility = VISIBLE
        contact_container.visibility = GONE
        contact_error.retry(View.OnClickListener {
            startShimmer()
        })
        Timber.e(error)
    }
}
