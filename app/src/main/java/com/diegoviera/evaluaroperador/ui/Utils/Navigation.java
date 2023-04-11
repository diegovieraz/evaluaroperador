package com.diegoviera.evaluaroperador.ui.Utils;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.diegoviera.evaluaroperador.ui.view.MainActivity;

import javax.inject.Inject;

public class Navigation {
    //private final int containerId;
    private final FragmentManager fragmentManager;
    private final Context context;

    @Inject
    public Navigation(MainActivity mainActivity) {
        //this.containerId = R.id.main_fragment_placeholder;
        this.fragmentManager = mainActivity.getSupportFragmentManager();
        this.context = mainActivity.getApplicationContext();
    }

    public void navigateToInitialBandejaFragment(Bundle bundle){

    }

}