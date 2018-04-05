package infotech.vns.com.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import infotech.vns.com.realmmodel.UserRegistration;
import infotech.vns.com.ui.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

public class RegistrationActivity extends AppCompatActivity {
    public Realm mRealm;
    @BindView(R.id.btn_register)
    Button btn_register;
    @BindView(R.id.edt_fname)
    EditText fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        mRealm = Realm.getInstance(RegistrationActivity.this);





    }
    @OnClick(R.id.btn_register)
    public void insertUser(){
        mRealm.beginTransaction();
        UserRegistration user= mRealm.createObject(UserRegistration.class);
        user.setFname("suneel");
        user.setLname("jami");
        user.setEmail("suneel j@ gmail.com");
        user.setMobile("9938893939");
        mRealm.commitTransaction();
        Toast.makeText(this, "registered success fully", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mRealm.close();
    }

    // Observable just is a factory method that emmits the values.
    private Observable<String> getObservable() {
        return Observable.just("Cricket", "Football");
    }
    private Observer<String> getObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.d("onNext",value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
    }
    private void doSomeWork() {

        getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread

//                .observeOn(Android.mainThread())
                .subscribe(getObserver());
    }
}
