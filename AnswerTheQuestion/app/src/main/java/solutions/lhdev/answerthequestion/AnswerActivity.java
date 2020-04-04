package solutions.lhdev.answerthequestion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private TextView textQuestion;
    private EditText editAnswer;
    private Button buttonAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        textQuestion = findViewById(R.id.textQuestion);
        editAnswer = findViewById(R.id.editAnswer);
        buttonAnswer = findViewById(R.id.buttonAnswer);

        Bundle extras = getIntent().getExtras();

        try
        {
            textQuestion.setText(extras.getString("question"));
        }
        catch (NullPointerException e)
        {
            Log.e(this.getClass().getSimpleName(), "Intent null @ onCreate.");
        }
    }

    public void answerClick(View v)
    {
        this.finish();
    }

    @Override
    public void finish()
    {
        Intent data = new Intent();

        data.putExtra("answer", editAnswer.getText().toString());
        setResult(RESULT_OK, data);

        super.finish();
    }
}
