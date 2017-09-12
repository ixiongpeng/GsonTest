package com.example.xiongpeng.gsontest;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Gson gson = null;
    Person person = null;
    String jsonStr = null;
    List<String> list = null;
    Map<String ,Object> content = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String TAG = getClass().getName();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person = new Person();
        person.setName("xiongpeng");
        person.setAge(18);
        gson = new Gson();
        jsonStr = gson.toJson(person);
        Log.d("Persopn",jsonStr);

        list = Arrays.asList("AA", "BB", "CC", "DD", "EE");
        System.out.println("<-------------------------------------------->");
        jsonStr = gson.toJson(list);
        Log.d("List", jsonStr);

        content = new HashMap<String, Object>();
        content.put("A", "AAAAA");
        content.put("B", "BBBBB");
        System.out.println("<-------------------------------------------->");
        jsonStr = gson.toJson(content);
        Log.d("content", jsonStr);

        System.out.println("<-------------------------------------------->");
        Person person = null;
        String studentJsonStr="{\"name\":\"xuanyouwu\",\"age\":26}";
        person = gson.fromJson(studentJsonStr,Person.class);
        System.out.println(person.toString());

        System.out.println("<-------------------------------------------->");
        String listJsonStr="[\"1\",\"a\",\"3\",\"rt\",\"5\"]";
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        ArrayList<String> sList=gson.fromJson(listJsonStr, type);
        System.out.println(sList);

        System.out.println("<-------------------------------------------->");
        studentJsonStr = "{\"name\":\"xuanyouwu\",\"age\":26}";
        System.out.println("------>studentJsonStr:"+studentJsonStr);
        JsonPrimitive jsonPrimitive=new JsonPrimitive(studentJsonStr);//通过JsonPrimative我们可以获得为转义的字符串
        System.out.println("------>jsonPrimitive:"+jsonPrimitive);









    }

    class Person{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;
        int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
