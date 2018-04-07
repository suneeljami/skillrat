package infotech.vns.com.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import infotech.vns.com.realmmodel.UserRegistration;
import infotech.vns.com.ui.R;
import io.realm.Realm;
import io.realm.RealmResults;

public class RegistrationActivity extends AppCompatActivity {
    public Realm mRealm;

    Button btn_register;
    EditText edt_fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRealm = Realm.getDefaultInstance();
        btn_register=findViewById(R.id.btn_registration);
        edt_fname =findViewById(R.id.edt_fname);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUser();
            }
        });
    }
    public void insertUser(){
        mRealm.beginTransaction();
        UserRegistration user= mRealm.createObject(UserRegistration.class);
        user.setName("suneel");
        user.setAddress("jami");
        user.setEmail("suneelj@ gmail.com");
        user.setAge(99);
        mRealm.commitTransaction();
        Toast.makeText(this, "registered success fully", Toast.LENGTH_SHORT).show();
        RealmResults<UserRegistration> userRegistrationRealmResults=mRealm.where(UserRegistration.class).findAll();
        edt_fname.setText(userRegistrationRealmResults.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mRealm.close();
    }

}
