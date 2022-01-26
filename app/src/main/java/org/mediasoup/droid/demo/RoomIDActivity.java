package org.mediasoup.droid.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import java.util.List;

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

  private void doDataBind(ListPreference preference, List<String> list){
    CharSequence mentries[] = new String[list.size()];
    CharSequence mentryValues[] = new String[list.size()];
    int i = 0;
    for (String mdata : list) {
      mentries[i] = mdata;
      mentryValues[i] = Integer.toString(i);
      i++;
    }
    preference.setEntries(mentries);
    preference.setEntryValues(mentryValues);
  }
}
