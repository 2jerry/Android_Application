package andoridtown.org.application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCustomer extends AppCompatActivity
{
    EditText editText;
    EditText name;
    EditText phone;
    EditText address;

    // 고객 정보 추가
    CustomerInfo customerInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_customer_activity);

        final EditText editText = (EditText)findViewById(R.id.editText);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        address = (EditText)findViewById(R.id.address);


        // 파싱 시작 버튼
        Button button = (Button)findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String str = editText.getText().toString();
                customerInfo = new CustomerInfo(str);

                setCustomerInfo(customerInfo);
            }
        });

        Button addBtn = (Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }


    private void setCustomerInfo(CustomerInfo customerInfo)
    {
        name.setText(customerInfo.getName());
        phone.setText(customerInfo.getPhone());
        address.setText(customerInfo.getAddress());
    }
}
