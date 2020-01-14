package com.myweather.hotdog.ui.people;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PeopleViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public PeopleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Anna");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
