package com.undira.tiundira.ui.hubungi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HubungiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HubungiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}