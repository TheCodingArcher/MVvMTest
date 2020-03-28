package android.thecodingarcher.mvvmtest.viewModels;

import android.os.AsyncTask;
import android.thecodingarcher.mvvmtest.models.NicePlace;
import android.thecodingarcher.mvvmtest.repositories.NicePlaceRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepository mNicePlaceRepository;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (mNicePlaces != null) {
            return;
        }

        mNicePlaceRepository = NicePlaceRepository.getInstance();
        mNicePlaces = mNicePlaceRepository.getNicePlaces();
    }

    public void addNewValue(final NicePlace nicePlace) {
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces = mNicePlaces.getValue();
                currentPlaces.add(nicePlace);
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }
        }.execute();
    }

    public LiveData<List<NicePlace>> getNicePlaces() {
        return mNicePlaces;
    }

    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}
