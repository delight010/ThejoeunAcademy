package com.asolec.listadddel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<String>();
        items.add("Fist");
        items.add("Second");
        items.add("Third");

        adapter = new ArrayAdapter<String >(this,
                android.R.layout.simple_list_item_single_choice, items);
        //android.R.layout.simple_list_item_single_choice
        //radio 버튼을 만들기 위함(모양만)

        list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //선택했을 시, 선택된 부분 라디오버튼 체크 표시
        //(CHOICE_MODE_SINGLE이므로 1개만 선택가능)

        //list를 클릭했을 때 toast를 띄움
        list.setOnItemClickListener(mItemClickListener);
        findViewById(R.id.add).setOnClickListener(mClickListener);
        findViewById(R.id.del).setOnClickListener(mClickListener);

    }//onCreate

    //method
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText editText = findViewById(R.id.newItem);
            switch (v.getId()){
                case R.id.add:
                    String text = editText.getText().toString(); // edittext의 내용을 받아옴
                    if(text.length()!=0){
                        items.add(text);
                        editText.setText(""); // edittext 내용 초기화
                        adapter.notifyDataSetChanged(); // data를 새로 구성함
                    }
                    break;
                case R.id.del:
                    int id;
                    id = list.getCheckedItemPosition();//선택한 리스트의 순번을 표시
                    if(id != ListView.INVALID_POSITION){ //무엇이든 선택했을 때만 동작
                         items.remove(id);
                         list.clearChoices(); // 선택한 리스트. 선택표시를 초기화
                         adapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };



    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String message;
            message = "Select Item = " + items.get(position);
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            //MainActivity에 띄움
        }
    };

}