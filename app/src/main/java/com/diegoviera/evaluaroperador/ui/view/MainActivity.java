package com.diegoviera.evaluaroperador.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.diegoviera.evaluaroperador.R;
import com.diegoviera.evaluaroperador.ui.view.fragments.LoginFragment;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_fragment_placeholder, new LoginFragment()).commit();

    }
}