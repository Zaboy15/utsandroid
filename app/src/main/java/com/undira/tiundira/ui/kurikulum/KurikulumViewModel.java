package com.undira.tiundira.ui.kurikulum;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KurikulumViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public KurikulumViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}