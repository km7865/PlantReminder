package com.plantreminder;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        String route = strings[0];
        String data = strings[1];
        NetworkHandler.getInstance().connect(route);                //서버와 연결
        String result = NetworkHandler.communication(data);        //strings[1]은 보낼 데이터
        NetworkHandler.disconnect();

        return result;
    }
}
