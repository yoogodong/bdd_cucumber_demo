package glue.meta;

import cucumber.api.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import glue.meta.utils.PointTransform;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Transformation {

    private List<String> stringList;
    private Date date;
    private Point point;
    private List<Point> points;

    @Given("^有如下几种水果\"([^\"]*)\"$")
    public void 有如下几种水果(@Delimiter("/")List<String> stringList) throws Throwable {
        this.stringList = stringList;
    }


    @Then("^列表的长度是 (\\d+)$")
    public void 列表的长度是(int arg0) throws Throwable {
        assertEquals(arg0,stringList.size());
    }

    @Given("^有如下几种水果：$")
    public void 有如下几种水果(DataTable dataTable) throws Throwable {
        stringList = dataTable.asList(String.class);
    }


    @Given("^我的生日 \"([^\"]*)\"$")
    public void 我的生日(@Format("yyyy-MM-dd")Date date) throws Throwable {
        this.date = date;
    }

    @Then("^年月日分别是\"([^\"]*)\"$")
    public void 年月日分别是(@Delimiter("/")List<Integer> trip) throws Throwable {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        final List<Integer> actural = Arrays.asList(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));

        assertEquals(trip,actural);
    }

    @Given("^点的坐标 \"([^\"]*)\"$")
    public void 点的坐标(@Transform(PointTransform.class) Point point) throws Throwable {
        this.point = point;
    }

    @Then("^横坐标是 (\\d+), 纵坐标是 (\\d+)$")
    public void 横坐标是纵坐标是(int arg0, int arg1) throws Throwable {
        assertEquals(arg0,point.x);
        assertEquals(arg1,point.y);
    }

    @Given("^点的坐标如下$")
    public void 点的坐标如下(@Transpose List<Point> points) throws Throwable {
        this.points = points;
    }

    @Then("^应该有(\\d+)个点$")
    public void 应该有个点(int arg0) throws Throwable {
        assertEquals(arg0,points.size());
    }

    @And("^第(\\d+)个点的坐标是(\\d+)和(\\d+)$")
    public void 第个点的坐标是和(int arg0, int arg1, int arg2) throws Throwable {
        final Point point = points.get(arg0-1);
        assertEquals(arg1,point.x);
        assertEquals(arg2,point.y);
    }

}
