package android.thecodingarcher.mvvmtest.repositories;

import android.thecodingarcher.mvvmtest.models.NicePlace;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

// Singleton Class
public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance() {
        if (instance == null) {
            instance = new NicePlaceRepository();
        }
        return instance;
    }

    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setNicePlaces();

        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);

        return data;
    }

    private void setNicePlaces() {
        dataSet.add(
                new NicePlace("https://s27922.pcdn.co/wp-content/uploads/2019/04/havasu-falls-hike-5.jpg.optimal.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://d1bvpoagx8hqbg.cloudfront.net/originals/go-trondheim-doubts-5ecebe969ee456abd33e1ec57ce04142.jpg",
                        "Trondheim")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        dataSet.add(
                new NicePlace("https://resize.hswstatic.com/w_907/gif/rocks-frozen-lake.jpg",
                        "Frozen Lake")
        );
        dataSet.add(
                new NicePlace("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}
