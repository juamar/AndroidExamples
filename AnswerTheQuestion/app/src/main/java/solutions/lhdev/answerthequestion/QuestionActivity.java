package solutions.lhdev.answerthequestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    private EditText editQuestion;
    private TextView textAnswer;
    private Button buttonAsk;
    private final int REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        editQuestion = findViewById(R.id.editQuestion);
        textAnswer = findViewById(R.id.textAnswer);
        buttonAsk = findViewById(R.id.buttonAsk);
    }

    public void askClick(View view)
    {
        Intent i = new Intent(this, AnswerActivity.class);
        String myString = editQuestion.getText().toString();
        i.putExtra("question", myString);
        startActivityForResult(i, REQUESTCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //This will be a potential place to use switch-case instead of ifs.
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK)
        {
            Bundle extras= data.getExtras();
            textAnswer.setText(extras.getString("answer"));
        }
    }
}
