package andoridtown.org.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity
{
    public static final int REQUEST_CODE_CUSTOMER_VIEW = 200;
    boolean flag = false;

    EditText name;
    EditText phone;
    EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        address = (EditText)findViewById(R.id.address);

        // 받아온 인텐트 토스트로 출력
        Intent receivedIntent = getIntent();
        String msg = receivedIntent.getStringExtra("titleMsg");

        Toast.makeText(this,"titleMsg : "+ msg,Toast.LENGTH_LONG).show();

        // 고객 조회 버튼
        Button button_1 = (Button)findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),OrderCustomer.class);
                intent.putExtra("titleMsg","고객조회 화면");

                startActivityForResult(intent,REQUEST_CODE_CUSTOMER_VIEW);
            }
        });

        Button saveBtn = (Button)findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Toast toast = Toast.makeText(getApplicationContext(),"주문내역이 저장되었습니다.",Toast.LENGTH_LONG);
                //toast.setGravity(Gravity.TOP|Gravity.TO);
                toast.show();
            }
        });


        Button cancelBtn = (Button)findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMessage();
            }
        });



    }


    private void showMessage()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("저장하지 않고 취소 하시겠습니까?");

        builder.setPositiveButton("예", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    // Activity Result 값


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(data !=null)
        {
            if(requestCode == REQUEST_CODE_CUSTOMER_VIEW)
            {
                String msg = data.getStringExtra("result");
                if(msg !=null)
                {
                    name.setText(msg);
                }
            }
        }
    }
}
