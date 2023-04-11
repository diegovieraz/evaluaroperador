package com.diegoviera.evaluaroperador.di.module;

import com.diegoviera.evaluaroperador.ui.viewmodel.EvaluadorViewModel;
import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    EvaluadorViewModel evaluadorViewModel();


}
