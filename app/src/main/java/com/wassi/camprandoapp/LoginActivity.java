package com.wassi.camprandoapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.GraphResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.plus.model.people.Person;
import com.wassi.camprandoapp.constants.AppConstants;
import com.wassi.camprandoapp.helpers.FbConnectHelper;
import com.wassi.camprandoapp.helpers.GooglePlusSignInHelper;
import com.wassi.camprandoapp.managers.SharedPreferenceManager;
import com.wassi.camprandoapp.model.UserModel;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity implements FbConnectHelper.OnFbSignInListener, GooglePlusSignInHelper.OnGoogleSignInListener {
    private static final String TAG = LoginActivity.class.getSimpleName();
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    @Bind(R.id.login_layout)
    CardView viewcard;
    private RelativeLayout rela;
    private FbConnectHelper fbConnectHelper;
    private GooglePlusSignInHelper gSignInHelper;
    private UserModel userModel;
    private ImageButton login_facebook;
    private ImageButton login_google;
    private TextView inscription;
    private ImageView login;
    private EditText etemail, etpwd;
    private String e_email, e_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setup();
        initViews();
        userModel = SharedPreferenceManager.getSharedInstance().getUserModelFromPreferences();
        if (userModel != null) {
            Intent intent = new Intent(this, Acceuil_Activity.class);
            intent.putExtra(UserModel.class.getSimpleName(), userModel);
            startActivity(intent);
            finish();
        }
    }

    private void setup() {
        fbConnectHelper = new FbConnectHelper(this, this);
        //google
        GooglePlusSignInHelper.setClientID(AppConstants.GOOGLE_CLIENT_ID);
        gSignInHelper = GooglePlusSignInHelper.getInstance();
        gSignInHelper.initialize(this, this);
    }

    private void initViews() {
        rela = (RelativeLayout) findViewById(R.id.relat);
        etemail = (EditText) findViewById(R.id.et_email);
        etpwd = (EditText) findViewById(R.id.et_pwd);
        login = (ImageView) findViewById(R.id.button_signin);
        login_facebook = (ImageButton) findViewById(R.id.login_facebook);
        login_google = (ImageButton) findViewById(R.id.login_google);
        inscription = (TextView) findViewById(R.id.inscrit);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoLogin();
            }
        });
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });
    }

    public void onFacebookClicked(View view) {
        fbConnectHelper.connect();
        setBackground(R.color.fb_color);
    }

    public void onGoogleClicked(View view) {
        gSignInHelper.signIn(this);
        setBackground(R.color.g_color);
    }

    @Override
    public void OnFbSuccess(GraphResponse graphResponse) {
        userModel = new UserModel();
        try {
            JSONObject jsonObject = graphResponse.getJSONObject();
            userModel.userid = jsonObject.getString("id");
            userModel.userName = jsonObject.getString("name");
            userModel.userEmail = jsonObject.getString("email");
            String id = jsonObject.getString("id");
            String profileImg = "http://graph.facebook.com/" + id + "/picture?type=large";
            userModel.profilePic = profileImg;
            userModel.userTel = "";
            Log.i(TAG, "OnFbSuccess: " + id);
            Log.i(TAG, "OnFbSuccess: " + profileImg);
            if (userModel != null) {
                SharedPreferenceManager.getSharedInstance().saveUserModel(userModel);
                openHomeActivity(userModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void OnFbError(String errorMessage) {
        resetToDefaultView("facebook sgn in @error");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fbConnectHelper.onActivityResult(requestCode, resultCode, data);
        gSignInHelper.onActivityResult(requestCode, resultCode, data);
    }

    public void openHomeActivity(UserModel userModel) {
        Intent intent = new Intent(this, Acceuil_Activity.class);
        intent.putExtra(UserModel.class.getSimpleName(), userModel);
        startActivity(intent);
        finish();
    }

    @Override
    public void OnGSignSuccess(GoogleSignInAccount acct, @Nullable Person person) {
        UserModel userModel = new UserModel();
        userModel.userid = acct.getId();
        userModel.userName = (acct.getDisplayName() == null) ? "" : acct.getDisplayName();
        userModel.userEmail = acct.getEmail();
        Log.i(TAG, "OnGSignSuccess: AccessToken " + acct.getIdToken());
        Uri photoUrl = acct.getPhotoUrl();
        if (photoUrl != null)
            userModel.profilePic = photoUrl.toString();
        else
            userModel.profilePic = "";
        userModel.userTel = "";
        Log.i(TAG, acct.getIdToken());
        SharedPreferenceManager.getSharedInstance().saveUserModel(userModel);
        openHomeActivity(userModel);
    }

    @Override
    public void OnGSignError(GoogleSignInResult errorMessage) {
        resetToDefaultView("Google Sign in error@");
    }

    private void setBackground(int colorId) {
        rela.setBackgroundColor(this.getResources().getColor(colorId));
        progressBar.setVisibility(View.VISIBLE);
        viewcard.setVisibility(View.GONE);

    }

    private void resetToDefaultView(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        rela.setBackgroundColor(this.getResources().getColor(android.R.color.white));
        progressBar.setVisibility(View.GONE);
        viewcard.setVisibility(View.VISIBLE);
    }

    private void gotoLogin() {
        e_email = etemail.getText().toString();
        e_pwd = etpwd.getText().toString();
        if (!e_email.isEmpty() && !e_pwd.isEmpty()) {

            loginProcess(e_email, e_pwd);

        } else {

            Toast.makeText(this, "Fields are empty !", Toast.LENGTH_LONG).show();
        }
    }

    private void loginProcess(String email, String pwd) {
    }

    private void goToRegister() {
        Intent intent = new Intent(LoginActivity.this, Register_activity.class);
        startActivity(intent);
    }
}
