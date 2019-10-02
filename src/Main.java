import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.dao.Person;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Administrator on 2019/10/2 17:34.
 */
public class Main {
    public static void main(String[] args) {


//        bean();
        collection();
//        annotation();
//        serialization();
//        ignore();
//        datetime();


    }

    private static void datetime() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyymmdd HH:mm:ss"));

        Person person = new Person();
        person.setAge(12);
        person.setName("bob");
        person.setDate(Date.from(Instant.now()));
        try {
            String r = objectMapper.writeValueAsString(person);
            System.out.println(r);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    private static void ignore() {

        //字段屏蔽
        try {
            String json = "{\"name\":\"bob\",\"age\":12,\"sex\":1}";
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //如果字段不匹配也不要报错
            Person person = mapper.readValue(json, Person.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void serialization() {

        ObjectMapper objectMapper = new ObjectMapper();


    }

    private static void annotation() {


    }

    private static void bean() {

        //保持到文件
        try {

            File file = new File("res\\person.json");

            Person person = new Person();
            person.setAge(12);
            person.setName("bob");

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, person);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //转为 JOPO
//        try {
//            String json = "{\"name\":\"bob\",\"age\":12}";
//            ObjectMapper mapper = new ObjectMapper();
//            Person person = mapper.readValue(json, Person.class);
//            System.out.println(person);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //转为 JSON字符串
//        try {
//
//            Person person = new Person();
//            person.setAge(12);
//            person.setName("bob");
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonString = mapper.writeValueAsString(person);
//            System.out.println(jsonString);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }


    }

    private static void collection() {

        //Map容器转JSON数组
        Map<String, String> map = new HashMap<>();
        map.put("one", "111");
        map.put("two", "222");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String r = objectMapper.writeValueAsString(map);
            System.out.println(r);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }



        //JSON数组转List容器
//        String array = "[" +
//                "{\"name\":\"bob\",\"age\":12}," +
//                "{\"name\":\"jack\",\"age\":48}" +
//                "]";
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            List<Person> persons = objectMapper.readValue(array, new TypeReference<List<Person>>(){});
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
