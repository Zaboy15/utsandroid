package com.undira.tiundira.ui.tujuan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TujuanViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TujuanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}