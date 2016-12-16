package appewtc.masterung.whereltc;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class LTClistView extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltclist_view);

        listView = (ListView) findViewById(R.id.livLtc);

        //Creat ListView
        try {

            SynLTC synLTC = new SynLTC(LTClistView.this);
            synLTC.execute();
            String s = synLTC.get();
            Log.d("16decV3", "JSON==>" + s);


            JSONArray jsonArray = new JSONArray(s);
            String[] nameStrings = new String[jsonArray.length()];
            String[] latStrings = new String[jsonArray.length()];
            String[] lngStrings = new String[jsonArray.length()];
            String[] iconStrings = new String[jsonArray.length()];

            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameStrings[i] = jsonObject.getString("NameLogin");
                latStrings[i]=jsonObject.getString("lat");
                lngStrings[i]=jsonObject.getString("lng");
                iconStrings[i]=jsonObject.getString("Image");

            }

            MyAdapter myAdapter = new MyAdapter(LTClistView.this,
                    nameStrings,latStrings,lngStrings,iconStrings);
            listView.setAdapter(myAdapter);
            

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//Main method



}//Main class
