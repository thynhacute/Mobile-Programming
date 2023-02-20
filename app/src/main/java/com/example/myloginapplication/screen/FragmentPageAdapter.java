package com.example.myloginapplication.screen;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentPageAdapter extends FragmentStateAdapter {

    public FragmentPageAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FeatureFragment();
        } else if(position == 1) {
            return new DealFragment();
        }else {
            return new CategoriesFragment();
        }
    }
}
