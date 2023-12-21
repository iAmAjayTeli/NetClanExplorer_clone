package com.example.assigment;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.assigment.databinding.ActivityRefinePageBinding;
import com.google.android.material.slider.Slider;

public class RefinePage extends AppCompatActivity {
    AppCompatButton[] buttons = new AppCompatButton[8];
    boolean[] isButtonSelected=new boolean[8];

    ActivityRefinePageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityRefinePageBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());




        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);

        //setting the default selected option
        binding.spinner.setSelection(0);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOption=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        final int[] selectedButtonCount = {1};

        for(int i=0; i<buttons.length; i++){
            final int buttonIndex=i; //Capture the index for each button

            //find and initialize each button by ID
            buttons[i] =findViewById(getResources().getIdentifier("btn" + (i+1), "id", getPackageName()));

            //set a tag on each button to store its index
            buttons[i].setTag(buttonIndex);

            if(i==0){
                isButtonSelected[buttonIndex]=true;
                buttons[i].setBackgroundResource(R.drawable.btn_pressed);
                buttons[i].setTextColor(getResources().getColor(R.color.white));
            }
            else {
                isButtonSelected[buttonIndex]=false;
            }


            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index=(int) view.getTag();

                    if(selectedButtonCount[0] > 1 || !isButtonSelected[buttonIndex]){
                       isButtonSelected[buttonIndex]=!isButtonSelected[buttonIndex];

                       if(isButtonSelected[buttonIndex]){
                           buttons[buttonIndex].setBackgroundResource(R.drawable.btn_pressed);
                           buttons[buttonIndex].setTextColor(getResources().getColor(R.color.white));
                           selectedButtonCount[0]++;
                       }
                       else {
                           buttons[buttonIndex].setBackgroundResource(R.drawable.btn_normal);
                           buttons[buttonIndex].setTextColor(getResources().getColor(R.color.black));
                           selectedButtonCount[0]--;
                       }
                    }


                }
            });
        }






       binding.slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                if (fromUser) {
                    int roundedValue = Math.round(value);
                    slider.setValue(roundedValue);
                }
            }
        });


       //for the textArea
        final int maxCharacters=250;
        binding.textCounter.setText("47/"+maxCharacters); //initial count

        binding.textArea.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //update character count
                int remainingCharacters= maxCharacters- charSequence.length();
                binding.textCounter.setText(charSequence.length() + "/" + maxCharacters);

                //Disable or enable the Edittext based on the character limit
                binding.textArea.setEnabled(remainingCharacters>0);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //check if the text exceeds the character limit
                if(editable.length()>maxCharacters){
                    String limitedText=editable.toString().substring(0, maxCharacters);
                    binding.textArea.setText(limitedText);
                    binding.textArea.setSelection(maxCharacters); //Move the cursor to end
                }

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStatusBarColor(getResources().getColor(R.color.statusBarColor));
            setLightStatusBarIcons(true);
        }

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RefinePage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RefinePage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setStatusBarColor(int color) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
    }

    private void setLightStatusBarIcons(boolean darkIcons) {

        View decorView = getWindow().getDecorView();
        int flags = decorView.getSystemUiVisibility();
        if (darkIcons) {
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        decorView.setSystemUiVisibility(flags);
    }
}