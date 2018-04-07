package infotech.vns.com.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SkillPayApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("infotech.vns.com.app.realm")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
