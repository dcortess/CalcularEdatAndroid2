package cat.udl.tidic.amb.calcularedat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    long a = 0;
    long birthday = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","Hola estic entrant al oncreate...");

        final EditText editText_nom = (EditText) findViewById(R.id.editText_nom);
        final EditText editText_any = (EditText) findViewById(R.id.editText_any);
        final EditText editText_mes = (EditText) findViewById(R.id.editText_mes);
        final EditText editText_dia = (EditText) findViewById(R.id.editText_dia);
        final Button buidar_button = (Button) findViewById(R.id.buidar_button);
        final Button enviar_button = (Button) findViewById(R.id.enviar_button);
        final TextView editText_bio = (TextView) findViewById(R.id.tv_resposta);


        enviar_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
               String fullName = editText_nom.getText().toString();
               int year = Integer.parseInt(editText_any.getText().toString());
               int month = Integer.parseInt(editText_mes.getText().toString());
               int day = Integer.parseInt(editText_dia.getText().toString());

               Person p = new Person(fullName,year,month,day);


              /* int age = getYears(year,month,day);

               String bio = "Hola, em dic " + fullName + ". Vaig neixer el dia " + day + "/" +
                       month + "/" + year + ". Tinc " + age + " anys.";*/
               editText_bio.setText(p.toString());
           }
        });




        buidar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                editText_nom.setText("");
                editText_bio.setText("");



            }
        });

    }

    public int getYears(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTimeInMillis());
        cal.set(year,month,day);
        Date birthday = new Date(cal.getTimeInMillis());

        DateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.US);
        int d1 = Integer.parseInt(formatter.format(birthday));
        int d2 = Integer.parseInt(formatter.format(today));
        return (d2 - d1) / 10000;
    }

}
