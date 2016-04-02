package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import us.areaz.builditbigger.jokelibbackend.jAPI.JAPI;
import us.areaz.jokepreviewlibrary.JokePreview;

/**
 * Created by ahmed on 3/31/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private JAPI jokeApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... contexts) {
        if(contexts!=null && contexts.length>0) {
            this.context = contexts[0];
        }else{
            Log.e(this.getClass().getSimpleName(), "Context Missing");
        }
        String serverUrl;
        if (jokeApiService == null) {
            if (context != null && (serverUrl = context.getString(R.string.serverUrl)).startsWith("http")){
                JAPI.Builder builder = new JAPI.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl(serverUrl);
                jokeApiService = builder.build();
            }else{
                Log.e(this.getClass().getSimpleName(), "JokeLibBackend API url");
            }
        }

        try {
            return jokeApiService.getJoke().execute().getData();
        } catch (Exception e) {
            Log.e(this.getClass().getSimpleName(), e.getMessage(), e);
            return "";
        }

    }

    @Override
    protected void onPostExecute(String result) {
        if(context != null) {
            Intent intent = new Intent(context, JokePreview.class);
            intent.putExtra(JokePreview.INTENT_EXTRA_TAG, result);
            context.startActivity(intent);
        }
    }
}