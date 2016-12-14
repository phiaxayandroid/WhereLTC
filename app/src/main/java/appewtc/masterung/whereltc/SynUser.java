package appewtc.masterung.whereltc;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

/**
 * Created by masterUNG on 12/14/2016 AD.
 */

public class SynUser extends AsyncTask<Void, Void, String>{

    //Explicit
    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/ltc/get_user_master.php";

    public SynUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();

        } catch (Exception e) {
            Log.d("14decV2", "e doin ==> " + e.toString());
        }

        return null;
    }
}   // Main Class
