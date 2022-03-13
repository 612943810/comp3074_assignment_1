package ca.gbc.comp3074.assignment1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  double pay;
  double tax;

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculateBtn=findViewById(R.id.calculateBtn);
        EditText hoursInput=(EditText) findViewById(R.id.no_of_hours);
        EditText hourlyRateInput=(EditText) findViewById(R.id.hourly_rate);
        TextView totalPayOutput=(TextView) findViewById(R.id.totalPayOutput);
        TextView taxOutput=(TextView) findViewById(R.id.taxOutput);

calculateBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        double no_of_hours = Double.parseDouble(hoursInput.getText().toString());
        double hourly_rate = Double.parseDouble(hourlyRateInput.getText().toString());

            if (hourly_rate <= 40) {
                pay = no_of_hours * hourly_rate;
            } else {
                pay = (no_of_hours - 40) * hourly_rate * 1.5 + hourly_rate;
            }
            tax = pay * 0.18;
            totalPayOutput.setText("Total Pay:$" + String.format("%.2f", pay));
            taxOutput.setText("Tax:$" + String.format("%.2f", tax));

        }

    });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuNav){
        MenuInflater menuInflate= getMenuInflater();
        menuInflate.inflate(R.menu.main_menu,menuNav);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItemBar){

        if(menuItemBar.getItemId()==R.id.aboutMenuItem){

            Intent newActivity=new Intent(this,AboutActivity.class);

            startActivity(newActivity);

        }



        return true;
    }

}