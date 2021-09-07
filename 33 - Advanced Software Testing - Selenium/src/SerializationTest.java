import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SerializationTest {

//    @Test
//    public void serializationTester()
//    {
//        Person wes = new Person();
//        File file = FileUtils.getFile("res/", "wes.obj");
//        byte [] data = SerializationUtils.serialize(wes);
//        try {
//            FileUtils.writeByteArrayToFile(file, data);
//        } catch (IOException e)
//        {
//            Assert.fail();
//        }
//    }


    // 2/18/2019 - JSON Serialization Notes

//    @Test
//    public void writeToFileTest() throws Exception
//    {
//        File file = new File("res/data.txt");
//        FileUtils.writeStringToFile(file, "this rocks!", "UTF-8");
//        String str = FileUtils.readFileToString(file, "UTF-8");
//        Assert.assertEquals("this rocks!", str);
//    }


//    @Test
//    public void serializationToJSONTest() throws Exception
//    {
//        ObjectMapper om = new ObjectMapper();
//        Person travis = new Person("travis", 20);
//        String str = om.writeValueAsString(travis);
//        System.out.println(str);
//
//
//
//        String matt = "{\"age\":22,\"name\":\"matt\"}";
//
//    }



}
