package solutions.lhdev.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by JuanIgnacio on 05/03/2018.
 */

public class TextFragment extends Fragment {

    private TextView textView;
    private int x;
    private int y;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.text_fragment, /*Vista padre*/container, /*Como le pasamos el container, esto debe ir a false*/false);

        textView = (TextView) view.findViewById(R.id.textView1);

        return view;
    }

    public void changeTextProperties(int fontsize, String text)
    {
        textView.setTextSize(fontsize);
        textView.setText(text);
    }

    public void setTextPosition(int x, int y)
    {
        RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(x, y, 0, 0); // llp.setMargins(left, top, right, bottom);
        textView.setLayoutParams(llp);
    }

}
