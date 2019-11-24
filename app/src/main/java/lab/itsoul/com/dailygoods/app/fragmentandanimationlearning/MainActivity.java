package lab.itsoul.com.dailygoods.app.fragmentandanimationlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener{

    EditText editText ;
    Button button ;
    FrameLayout frameLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editText = findViewById(R.id.editText);
        this.button = findViewById(R.id.button);
        this.frameLayout = findViewById(R.id.frameLayout);

        initListeners() ;
    }

    private void initListeners() {
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = editText.getText().toString();
                SecondFragment secondFragment = SecondFragment.newInstance(txt);
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right , R.anim.exit_to_right
                        ,R.anim.enter_from_right , R.anim.exit_to_right );
                transaction.add(frameLayout.getId() , secondFragment , "second fragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }


    @Override
    public void onFragmentInteractionListener(String sendTextBack) {
        this.editText.setText(sendTextBack);
        onBackPressed();
    }
}
