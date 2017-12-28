package zju.homework.augmentedstudio.Tasks;

import android.os.AsyncTask;

import zju.homework.augmentedstudio.Java.ResponseMsg;
import zju.homework.augmentedstudio.Java.User;
import zju.homework.augmentedstudio.Utils.NetworkManager;
import zju.homework.augmentedstudio.Utils.Util;


/**
 * Created by stardust on 2016/11/18.
 */
//登录
public class UserLoginTask extends AsyncTask<String, Void, String> {


    public UserLoginTask() {

    }

    @Override
    public String doInBackground(String... params) {
        // TODO: attempt authentication against a network service.
        NetworkManager networkManager = new NetworkManager();
        String mEmail = params[0];
        String mPassword = params[1];

        // Simulate network access.
//            Thread.sleep(2000);
        String result = networkManager.postJson(Util.URL_ACCOUNT, Util.objectToJson(
           new User(mEmail, mPassword)
        ));
        if( result == null )
            return null;

        ResponseMsg msg = (ResponseMsg) Util.jsonToObject(result, ResponseMsg.class);
        if( msg != null )
            return msg.getMessage();

        /**
         * 在这里写从服务检查密码正确或者注册新用户
         * 没问题就返回TRUE， 否则返回FALSE
         * */
        return null;
    }

    @Override
    public void onPostExecute(final String success) {
        super.onPostExecute(success);
    }

    @Override
    public void onCancelled() {
        super.onCancelled();
    }
}