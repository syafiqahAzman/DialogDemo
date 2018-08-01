package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tv1, tv2, tv3, tv4, tv5;

    int theHour, theMin, theYear, theMonth, theDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.button);
        btnDemo2 = findViewById(R.id.button2);
        btnDemo3 = findViewById(R.id.button3);
        btnEx3 = findViewById(R.id.buttonEx3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView3);
        tv3 = findViewById(R.id.textViewEx3b);
        tv4 = findViewById(R.id.textViewDemo4);
        tv5 = findViewById(R.id.textView6);

        //Get current Date and time
        Calendar now = Calendar.getInstance();

        theYear = now.get(Calendar.YEAR);
        theMonth = now.get(Calendar.MONTH);
        theDay = now.get(Calendar.DAY_OF_MONTH);
        theHour = now.get(Calendar.HOUR_OF_DAY);
        theMin = now.get(Calendar.MINUTE);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Create the dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                /*-->Option 1
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App");
                //Can only close the dialog box via the close button
                myBuilder.setCancelable(false);
                //close button
                myBuilder.setPositiveButton("Close", null);
                */
                //Option 2
                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);


                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Create the dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                myBuilder.setTitle("Demo 2 - Buttons Dialog");
                myBuilder.setMessage("Select one of the buttons below");
                //Can only close the dialog box via the close button
                myBuilder.setCancelable(false);

                //configure the positive button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv1.setText("You have selected Yes");
                    }
                });

                //configure the negative button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv1.setText("You have selected No");
                    }
                });

                //Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);
                final EditText etInput = viewDialog.findViewById(R.id.editText);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); //Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      //Extract the text entered by the user
                        String message = etInput.getText().toString();
                        //Set the text to the TextView
                        tv2.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);
                final EditText etInput = viewDialog.findViewById(R.id.editTextEx3a);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextEx3b);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); //Set the view of the dialog
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Extract the text entered by the user
                        String num1 = etInput.getText().toString();
                        String num2 = etInput2.getText().toString();
                        //Sum the text and change it to integer
                        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
                        tv3.setText("The sum is " + sum);

                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tv4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                        theYear = year;
                        theMonth = monthOfYear;
                        theDay = dayOfMonth;

                    }
                };

                //Create the date picker dialog
                /*--> Option 1
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014, 11, 31);
                 */
                // Option 2
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, theYear, theMonth, theDay);

                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv5.setText("Time: " + hourOfDay + ":" + minute);

                        theHour = hourOfDay;
                        theMin = minute;

                    }
                };

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, theHour, theMin, true);

                myTimeDialog.show();
            }
        });
    }
}
