package com.diegoferreiracaetano.users.ui

import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import androidx.appcompat.widget.SearchView.GONE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.diegoferreiracaetano.commons.navigate
import com.diegoferreiracaetano.domain.ResultRouter
import com.diegoferreiracaetano.domain.user.User
import com.diegoferreiracaetano.users.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_users.user_container
import kotlinx.android.synthetic.main.fragment_users.user_recycle
import kotlinx.android.synthetic.main.fragment_users_loading.shimmer_view_container
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : Fragment(R.layout.fragment_users) {

    private val viewModel: UsersViewModel by viewModel()
    private lateinit var usersAdapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startShimmer()
        setupUser()
    }

    override fun onStop() {
        super.onStop()
        stopShimmer()
    }

    private fun setupUser() {
        viewModel.users().observe(this, Observer {
            it.onSuccess(::showUser)
                .onFailure { showError() }
        })
    }

    private fun startShimmer() {
        user_container.visibility = VISIBLE
        shimmer_view_container.startShimmer()
    }

    private fun stopShimmer() {
        shimmer_view_container.visibility = GONE
        shimmer_view_container.stopShimmer()
    }

    private fun showUser(result: ResultRouter<List<User>>) {
        stopShimmer()
        usersAdapter = UsersAdapter(result.result)
        user_recycle.adapter = usersAdapter
        usersAdapter.onItemClick = {
            navigate(result.router, it.id)
        }
    }

    private fun showError() {
        stopShimmer()
        Snackbar.make(requireView(), R.string.users_msg_error, Snackbar.LENGTH_LONG).show()
    }
}
