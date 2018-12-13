package com.wassi.camprandoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.wassi.camprandoapp.fragments.DatePickerFragment;
import com.wassi.camprandoapp.fragments.TimePickerFragment;
import com.wassi.camprandoapp.managers.SharedPreferenceManager;
import com.wassi.camprandoapp.model.UserModel;


public class Add_Event_Activity extends AppCompatActivity {
    public static final int REQUEST_CODE_CAMERA = 0012;
    public static final int REQUEST_CODE_GALLERY = 0013;
    private static final String TAG_ACTIVITY = Add_Event_Activity.class.getSimpleName();
    String id_user, type_evt, type_trnsp, timeMessaged, timeMessagef, date, imagePath;
    private ImageView imgevt;
    private TextView titre, type, org, des, nb_place, prix;
    private String[] items = {"Camera", "Gallery"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__event);
        initView();
        UserModel userModel = SharedPreferenceManager.getSharedInstance().getUserModelFromPreferences();
        if (userModel != null) {
            id_user = userModel.userid;
        }
    }

    public void initView() {
        imgevt = (ImageView) findViewById(R.id.imageevt);
        titre = (TextView) findViewById(R.id.nomevt);
        org = (TextView) findViewById(R.id.orgevt);
        des = (TextView) findViewById(R.id.desevt);
        nb_place = (TextView) findViewById(R.id.nbplacevt);
        prix = (TextView) findViewById(R.id.prixevt);
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        // The month integer returned by the date picker starts counting at 0
        // for January, so you need to add 1 to show months starting at 1.
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        date = (month_string + "/" + day_string + "/" + year_string);

    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        timeMessaged = (hour_string + ":" + minute_string);

    }

    public void processTimePickerResult_to(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        timeMessagef = (hour_string + ":" + minute_string);
    }

    public void onRadioButtonClickedTransport(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            case R.id.bus:
                if (checked)
                    // Pirates are the best
                    type_trnsp = getString(R.string.bus);
                break;
            case R.id.Train:
                if (checked)
                    // Ninjas rule
                    type_trnsp = getString(R.string.train);
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_rondo:
                if (checked)
                    type_evt = getString(R.string.rondonner);
                break;
            case R.id.radio_camp:
                if (checked)
                    type_evt = getString(R.string.camping);
                break;
        }
    }

    private void openImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Options");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (items[i].equals("Camera")) {
                    // EasyImage.openCamera(Add_Event_Activity.this,REQUEST_CODE_CAMERA);
                } else if (items[i].equals("Gallery")) {
                    // EasyImage.openGallery(Add_Event_Activity.this, REQUEST_CODE_GALLERY);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      /* super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                switch (type){
                    case REQUEST_CODE_CAMERA:
                        Glide.with(Add_Event_Activity.this)
                                .load(imageFile)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(imgevt);
                        imagePath= imageFile.getAbsolutePath();
                        break;
                    case REQUEST_CODE_GALLERY:
                        Glide.with(Add_Event_Activity.this)
                                .load(imageFile)
                                .fitCenter()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(imgevt);
                        imagePath= imageFile.getAbsolutePath();
                        break;
                }
            }

        });*/
    }
}







