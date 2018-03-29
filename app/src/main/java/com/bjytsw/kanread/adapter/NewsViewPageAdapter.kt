package com.bjytsw.kanread.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import java.util.*

class NewsViewPageAdapter : FragmentStatePagerAdapter{

    var titles: MutableList<String>
    var fragments: MutableList<Fragment>

    constructor(fm: FragmentManager) : super(fm){
        fragments = ArrayList()
        titles = ArrayList()
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }

    override fun getItemPosition(`object`: Any): Int {
        return return PagerAdapter.POSITION_NONE
    }

    fun setItems(titles:MutableList<String>, fragments: MutableList<Fragment>){
        this.titles = titles
        this.fragments = fragments
        notifyDataSetChanged()
    }
}