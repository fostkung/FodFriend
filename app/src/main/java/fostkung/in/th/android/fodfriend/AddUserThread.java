package fostkung.in.th.android.fodfriend;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AddUserThread extends AsyncTask<String, Void, String> {
    private Context context;

    public AddUserThread(Context contextt) {
        this.context = contextt;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", strings[0])
                    .add("Name", strings[1])
                    .add("User", strings[2])
                    .add("Password", strings[3])
                    .add("Avata", strings[4])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url("https://www.androidthai.in.th/ksu/addUserPanupong.php").post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
