import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Dealership
{
    ////////// fields & constructors
    private Inventory inv;
    public static String url = "https://goo.gl/phaEbQ";

    public Dealership()
    {
        this.inv = new Inventory();
    }
    public Dealership(Inventory inv)
    {
        this.inv = inv;
    }



    public void loadInventoryFromWeb(String url) throws Exception
    {
        InputStream in = new URL(url).openStream();
        String content = IOUtils.toString(in, "UTF-8");
        String[] lines = content.split("\n");


        ////////// for each line:
        for (String line : lines)
        {

            ////////// cleanup and split into a String[] Array
            line = line.replaceAll("\"", "");
            String[] words = line.split(",");



            //////////   split make and model and store them
            String[] makeModel = words[0].split(" ");
            String make = makeModel[0];
            String model = "";
            for (int x = 1; x < makeModel.length; x++)
            {
                model = model + StringUtils.strip(makeModel[x]);
            }



            //////////    parse and store Vehicle fields
            int year = Integer.valueOf(words[1]);
            double price = Double.valueOf(words[2]);
            boolean is4WD = Boolean.valueOf(words[3]);



            //////////    create new vehicle and store it in the inventory
            Vehicle v = new Vehicle(make, model, year, price, is4WD);
            inv.add(v);
        }


    }

    public Inventory getInv()
    {
        return inv;
    }

    public void setInv(Inventory inv)
    {
        this.inv = inv;
    }



    public void loadInventoryFromJSONFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Inventory inv = mapper.readValue(new File("inventory.json"), Inventory.class);
        setInv(inv);
    }



    public void storeInventoryAsJSONFile()
    {
        ///// needs testing -- that verifies the end file isn't empty
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File("inventory.json");
        for (Vehicle v : getInv().getVehicleInventory())
        {
            try {
                mapper.writeValue(jsonFile, v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 2/18/2019 - JSON Serialization Notes
//
//    @Test
//    public void writeToFileTest() throws Exception
//    {
//        File file = new File("res/data.txt");
//        FileUtils.writeStringToFile(file, "this rocks!", "UTF-8");
//        String str = FileUtils.readFileToString(file, "UTF-8");
//        Assert.assertEquals("this rocks!", str);
//    }

//
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
