package pabloaraya.org.data.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitApiClient<T> {

    protected T apiService;

    public RetrofitApiClient() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        apiService = retrofit.create(getApiService());
    }

    private Retrofit retrofitBuilder() {

        return new Retrofit.Builder().baseUrl(getBaseURL())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    protected abstract Class<T> getApiService();

    protected abstract String getBaseURL();
}
