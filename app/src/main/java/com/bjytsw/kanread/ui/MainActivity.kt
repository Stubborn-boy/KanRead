package com.bjytsw.kanread.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.bjytsw.kanread.R
import com.bjytsw.kanread.adapter.NewsViewPageAdapter
import com.bjytsw.kanread.ui.base.MvpActivity
import com.bjytsw.kanread.ui.contract.MainContract
import com.bjytsw.kanread.ui.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : MvpActivity<MainPresenter>(), MainContract.View, NavigationView.OnNavigationItemSelectedListener {

    var newsViewPageAdapter = NewsViewPageAdapter(supportFragmentManager)

    override fun onLoadPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun initView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        toolbar.setTitle("看阅")
        setSupportActionBar(toolbar)
        //supportActionBar?.title  = "看阅"
        viewPager.adapter = newsViewPageAdapter
        tabLayout.setupWithViewPager(viewPager)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun initData() {
        val fragments = mutableListOf<Fragment>()
        val titles = mutableListOf<String>()
        for (i in 0..3) {
            titles.add("Ab"+i)
            fragments.add(NewsFragment())
        }
        newsViewPageAdapter.setItems(titles, fragments)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
