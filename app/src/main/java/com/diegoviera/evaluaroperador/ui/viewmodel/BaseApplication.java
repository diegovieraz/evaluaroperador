package com.diegoviera.evaluaroperador.ui.viewmodel;

import android.app.Activity;
import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.diegoviera.evaluaroperador.di.AndroidFastNetworkingClient;
import com.diegoviera.evaluaroperador.di.AppInjector;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate(){
        super.onCreate();

        try {
            AndroidNetworking.initialize(getApplicationContext(), AndroidFastNetworkingClient.getokhttpclient(getApplicationContext()).build());
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        AppInjector.init(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

}
