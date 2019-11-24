package lab.itsoul.com.dailygoods.app.fragmentandanimationlearning;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private static final String TEXT = "text";

    EditText editText;
    Button button;
    View view;

    private String mText = "";
    private OnFragmentInteractionListener mlistener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_second, container, false);
        this.button = view.findViewById(R.id.button_fragment);
        this.editText = view.findViewById(R.id.editText_fragment);
        this.editText.setText(this.mText);
        this.editText.requestFocus();
        initListeners();
        return view;

    }

    private void initListeners() {
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = editText.getText().toString();
                sendBack(text);

            }
        });
    }

    private void sendBack(String text) {
            if (mlistener != null)
            {
                mlistener.onFragmentInteractionListener(text);
            }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mlistener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onListenerchange");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mlistener = null ;
    }

    public static SecondFragment newInstance(String text) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(SecondFragment.TEXT, text);
        secondFragment.setArguments(args);
        return secondFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            mText = getArguments().getString(SecondFragment.TEXT);
        }
    }
}
