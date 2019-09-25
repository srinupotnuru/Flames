package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
TextView textView;
String str1,str2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.Boy);
        et2=findViewById(R.id.Girl);
        textView=findViewById(R.id.textView2);



    }

    public void dofalmes(View view) {
        str1=et1.getText().toString();
        str2=et2.getText().toString();
        StringBuffer s1=new StringBuffer(str1);
        StringBuffer s2=new StringBuffer(str2);

        char c,d,e='\0';
        for(int i=0;i<s1.length();i++)
        {
            c=s1.charAt(i);
            for(int j=0;j<s2.length();j++)
            {
                d=s2.charAt(j);
                if(c==d)
                {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(j);
                    i--;
                    j--;
                    break;
                }
            }
        }
        s1=s1.append(s2);
        int k=6,l=0;
        String s3="FLAMES";
        while(k>1)
        {
            for(int m=1;m<s1.length();m++)
            {
                if(s3.charAt(l)!='X')
                {
                    l++;
                    if(l==6)
                        l=0;
                }
                else
                {
                    l++;
                    if(l==6)
                        l=0;
                    m--;
                }
            }
            while(s3.charAt(l)=='X')
            {
                l++;
                if(l==6)
                    l=0;
            }
            s3=s3.substring(0,l)+"X"+s3.substring(l+1);
            k--;
        }

        for(int i=0;i<s3.length();i++)
        {
            if(s3.charAt(i)!='X')
                e=s3.charAt(i);
        }
        if(e=='L'){
        Intent i=new Intent(this,Lovers.class);
        startActivity(i);
        }
    }

}
