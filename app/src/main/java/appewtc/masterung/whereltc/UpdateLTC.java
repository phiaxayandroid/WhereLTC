package appewtc.masterung.whereltc;

import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by LTC on 12/16/2016.
 */

public class UpdateLTC extends AsyncTask<Void, Void, String>{

    private Context context;
    private static final String urlPHP = "http://lao-hosting.com/ltc/add_ltc.php";
    private  String nameloginString, imageString, latString, lngString;

    public UpdateLTC(Context context,
                     String nameloginString,
                     String imageString,
                     String latString,
                     String lngString) {
        this.context = context;
        this.nameloginString = nameloginString;
        this.imageString = imageString;
        this.latString = latString;
        this.lngString = lngString;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd","true").add("NameLogin",nameloginString).add("Image",imageString).add("Lat",latString).add("Lng",lngString).build();
            Request.Builder builder= new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("16decV2","e doin ==>"+ e.toString());
        }


        return null;
    }
}//Main Class
