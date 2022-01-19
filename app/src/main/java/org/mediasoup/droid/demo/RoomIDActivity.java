package org.mediasoup.droid.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class RoomIDActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.settings_roomid_activity);
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.settings, new SettingsFragment())
        .commit();
  }

  public static class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
      setPreferencesFromResource(R.xml.roomid_preferences, rootKey);

      Preference preference = findPreference("button");
      preference.setOnPreferenceClickListener(p -> {
        startActivity(new Intent(getActivity(), RoomActivity.class));
        getActivity().finish();
        return true;
      });
    }
  }
}
