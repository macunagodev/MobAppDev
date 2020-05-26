package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.example.proyectofinalpokemon.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MenuFragment extends Fragment {

    private Toolbar toolbar;
    private TextView messageTextView;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private TabItem favoritesTab, recentTab, allTab;
    public PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new PageAdapter(this));

        tabLayout = (TabLayout)view.findViewById(R.id.tbPokemon);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(R.string.favorites);
                        tab.setIcon(R.drawable.ic_star_black);
                        break;
                    case 1:
                        tab.setText(R.string.recents);
                        tab.setIcon(R.drawable.ic_turned_in_black);
                        break;
                    case 2:
                        tab.setText(R.string.all);
                        tab.setIcon(R.drawable.ic_photo_camera_black);
                        break;
                }
            }
        }
        );

        tabLayoutMediator.attach();
    }
}
