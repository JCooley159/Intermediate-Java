import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestExample
{
    @Test
    public void helloTest()
    {
        Assert.assertEquals(1, 1);

    }

    @Test
    public void testCommonsLang()
    {
        String str = StringUtils.abbreviate("Today is great", 5);
        Assert.assertEquals("To...", str);
    }



}
