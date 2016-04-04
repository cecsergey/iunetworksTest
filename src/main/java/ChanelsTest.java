import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

/**
 * Created by cecse on 4/2/2016.
 */
public class ChanelsTest {
    private static String temp,temp2;
    private static String[] publicChannels;
    private static String[] channels  = {"1TV", "Հ2", "Շանթ", "Արմենիա TV", "Կենտրոն", "Արարատ",
                                            "Երկիր Մեդիա", "ATV", "ԱՐ", "21 TV", "ԱրմՆյուզ",
                                        "Հ3", "Շողակաթ", "Россия 1", "Первый канал", "РТР Планетa",
                                        "Россия К (Культура)", "HTB", "Перец ТВ", "TNT", "CTC International",
                                        "2x2", "Пятый канал", "Домашний Intenational", "РЕН ТВ", "Мир",
                                        "TV5 Monde", "Telesur", "U! Premium Armenia"};
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();


        //navigate to ucom.am site
        driver.get("https://www.ucom.am/en/home.html");
        driver.manage().window().maximize();

        //find and click services tab
        WebElement services = driver.findElement(By.xpath("//*[@id=\"j_id25\"]/div[3]/div[1]/a/span[1]"));
        services.click();

        //find and click on epg link
        WebElement epg = driver.findElement(By.xpath("//*[@id=\"j_id25\"]/div[3]/div[2]/ul/li[2]/ul/li[2]/ul/li[5]/a"));
        epg.click();

        //find and click on publicChannels link
        WebElement publicChanels = driver.findElement(By.xpath("//*[@id=\"j_id174:j_id176:0:tvCategoryId_\"]"));
        publicChanels.click();


        //compare existing WebElement list with channels list
        temp = driver.findElement(EPGScreen.epgChannel1TV).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannel2x2).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannel21TV).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelAR).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelArarat).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelArmeniaTV).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelArmNews).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelATV).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelDomashniiInternational).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelErkirMedia).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelH2).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelH3).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelKentron).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelMIR).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelNTV).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelPerviiCanal).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelPyatiiCanal).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelRenTV).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelRossia1).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelRossiaK).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelRTRPlaneta).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelShant).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelShoghakat).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelSTSInternational).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelTelesur).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelTNT).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelTV5Monde).getText();
        contains(channels,temp);
        temp = driver.findElement(EPGScreen.epgChannelUPremium).getText();
        contains(channels,temp);


        //Get list of public channels from site
        temp2 = driver.findElement(By.xpath("//*[@id=\"channelList\"]/div[2]/div[1]")).getText();
        if(temp2!=" " && temp2!=null){
        publicChannels = temp2.split("\n");
        }


        //Compare web page channels list with existing channels list
        for(int i=0;i<channels.length;i++){
            contains(publicChannels,channels[i]);
        }

        driver.close();
        driver.quit();

    }

    public static void contains(String[] channelsArray, String channel) {
        if(Arrays.asList(channelsArray).contains(channel)){
            //System.out.println("The channel "+ channel+" exist");
        }else{
            System.out.println("The public channels page doesn't contain  "+ channel+" channel");
        }

    }

}
