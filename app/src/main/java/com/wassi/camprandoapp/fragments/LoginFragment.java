package com.wassi.camprandoapp.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wassi.camprandoapp.Acceuil_Activity;
import com.wassi.camprandoapp.R;
import com.wassi.camprandoapp.constants.AppConstants;
import com.wassi.camprandoapp.helpers.FbConnectHelper;
import com.wassi.camprandoapp.helpers.GooglePlusSignInHelper;
import com.wassi.camprandoapp.managers.SharedPreferenceManager;
import com.wassi.camprandoapp.model.UserModel;
import com.facebook.GraphResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.plus.model.people.Person;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements FbConnectHelper.OnFbSignInListener, GooglePlusSignInHelper.OnGoogleSignInListener{

    private static final String TAG = LoginFragment.class.getSimpleName();
   @Bind(R.id.progress_bar)
    ProgressBar progressBar;

   @Bind(R.id.login_layout)
   CardView view;

    private FbConnectHelper fbConnectHelper;
    private GooglePlusSignInHelper gSignInHelper;

    private ImageButton login_facebook;
    private ImageButton login_google;
    private TextView inscription;
    private ImageView login;
    private EditText etemail,etpwd;
    private String e_email,e_pwd;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        setup();
    }

    private void setup() {
        GooglePlusSignInHelper.setClientID(AppConstants.GOOGLE_CLIENT_ID);
        gSignInHelper = GooglePlusSignInHelper.getInstance();
        gSignInHelper.initialize(getActivity(), this);

        fbConnectHelper = new FbConnectHelper(this,this);

    }
    private void initViews(View view){
        etemail=(EditText)view.findViewById(R.id.et_email);
        etpwd=(EditText)view.findViewById(R.id.et_pwd);
        login=(ImageView)view.findViewById(R.id.button_signin);
        login_facebook = (ImageButton)view.findViewById(R.id.login_facebook);
        login_google = (ImageButton)view.findViewById(R.id.login_google);
        inscription=(TextView)view.findViewById(R.id.inscrit);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoLogin();
            }
        });
        login_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fbConnectHelper.connect();
                setBackground(R.color.fb_color);
            }
        });
        login_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gSignInHelper.signIn(getActivity());
                setBackground(R.color.g_color);
            }
        });
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });
    }


    private void setBackground(int colorId)
    {
        getView().setBackgroundColor(getActivity().getResources().getColor(colorId));
        progressBar.setVisibility(View.VISIBLE);
        view.setVisibility(View.GONE);
    }

    private void resetToDefaultView(String message)
    {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        getView().setBackgroundColor(getActivity().getResources().getColor(android.R.color.white));
        progressBar.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fbConnectHelper.onActivityResult(requestCode, resultCode, data);
        gSignInHelper.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void OnFbSuccess(GraphResponse graphResponse) {
        UserModel userModel = getUserModelFromGraphResponse(graphResponse);
        if(userModel!=null) {
            SharedPreferenceManager.getSharedInstance().saveUserModel(userModel);
            startHomeActivity(userModel);
        }
    }

    private UserModel getUserModelFromGraphResponse(GraphResponse graphResponse)
    {
        UserModel userModel = new UserModel();
        try {
            JSONObject jsonObject = graphResponse.getJSONObject();
            userModel.userid = jsonObject.getString("id");
            userModel.userName = jsonObject.getString("name");
            userModel.userEmail = jsonObject.getString("email");
            //userModel.gender= jsonObject.getString("gender");
            String id=jsonObject.getString("id");
            String profileImg = "http://graph.facebook.com/"+ id+ "/picture?type=large";
            userModel.profilePic = profileImg;
            Log.i(TAG,profileImg);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userModel;
    }

    @Override
    public void OnFbError(String errorMessage) {
        resetToDefaultView(errorMessage);
    }

    @Override
    public void OnGSignSuccess(GoogleSignInAccount acct, Person person) {
        UserModel userModel = new UserModel();
        userModel.userid= acct.getIdToken();
        userModel.userName = (acct.getDisplayName()==null)?"":acct.getDisplayName();
        userModel.userEmail = acct.getEmail();

        Log.i(TAG, "OnGSignSuccess: AccessToken "+ acct.getIdToken());
/*
        if(person!=null) {
            int gender = person.getGender();

            if (gender == 0)
                userModel.gender = "MALE";
            else if (gender == 1)
                userModel.gender = "FEMALE";
            else
                userModel.gender = "OTHERS";

            Log.i(TAG, "OnGSignSuccess: gender "+ userModel.gender);
        }
*/
        Uri photoUrl = acct.getPhotoUrl();
        if(photoUrl!=null)
            userModel.profilePic = photoUrl.toString();
        else
            userModel.profilePic = "";
        Log.i(TAG, acct.getIdToken());

        SharedPreferenceManager.getSharedInstance().saveUserModel(userModel);
        startHomeActivity(userModel);
    }

    @Override
    public void OnGSignError(GoogleSignInResult errorMessage) {
        resetToDefaultView("Google Sign in error@");
    }

    private void startHomeActivity(UserModel userModel)
    {
        Intent intent = new Intent(getActivity(), Acceuil_Activity.class);
        intent.putExtra(UserModel.class.getSimpleName(), userModel);
        startActivity(intent);
       getActivity().finish();
    }

    private void goToRegister(){

        /*Fragment register = new Register_Fragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,register);
        ft.commit();*/
    }
    private void gotoLogin(){
         e_email = etemail.getText().toString();
         e_pwd = etpwd.getText().toString();
        if(!e_email.isEmpty() && !e_pwd.isEmpty()) {

            loginProcess(e_email,e_pwd);

        } else {

            Snackbar.make(getView(), "Fields are empty !", Snackbar.LENGTH_LONG).show();
        }
    }

    private void loginProcess(String email, String pwd) {
    }
}
