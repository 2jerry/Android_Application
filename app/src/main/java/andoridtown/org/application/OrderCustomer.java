package andoridtown.org.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

/* 고객 조회하는 새로운 액티비티
* */
public class OrderCustomer extends AppCompatActivity
{

    public static final int REQUEST_CODE_ADD_CUSTOMER = 300;

    /* 테스트용 데이터*/
    String[] arWords = new String[]
            {
                    "강아지","이오리","강호동","나비","오리","홍길동","강아지","강강술래","이아무개","이이이"
            };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_customer_activity);

        Intent receivedIntent = getIntent();
        String titleMsg = receivedIntent.getStringExtra("titleMsg");

        Toast.makeText(this, "titleMsg : " + titleMsg, Toast.LENGTH_LONG).show();



        // 문자열로 어댑터 생성
        ArrayAdapter<String> adWord = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,arWords);
        final AutoCompleteTextView autoEdit =(AutoCompleteTextView)findViewById(R.id.editText);
        autoEdit.setAdapter(adWord);

        // 취소 버튼
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });


        // 확인 버튼
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String str = autoEdit.getText().toString();
                Intent resultIntent = new Intent(); resultIntent.putExtra("result", str);

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        // 정보 추가 버튼
        Button addBtn = (Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),AddCustomer.class);
                intent.putExtra("titleMsg","정보 추가 화면");

                startActivityForResult(intent,REQUEST_CODE_ADD_CUSTOMER);
            }
        });

    }
}
