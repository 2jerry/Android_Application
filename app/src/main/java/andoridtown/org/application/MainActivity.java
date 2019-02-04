package andoridtown.org.application;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static final int REQUEST_CODE_ORDER = 100;
    public static final int REQUEST_CODE_CUSTOMER = 101;
    public static final int REQUEST_CODE_MANAGE = 102;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button orderBtn = (Button)findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                intent.putExtra("titleMsg","주문 등록");

                startActivityForResult(intent,REQUEST_CODE_ORDER);
            }
        });

        Button customerBtn = (Button)findViewById(R.id.customerBtn);


        Button manageBtn = (Button)findViewById(R.id.manageBtn);
    }

}
