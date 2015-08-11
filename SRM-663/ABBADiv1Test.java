import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABBADiv1Test {

    protected ABBADiv1 solution;

    @Before
    public void setUp() {
        solution = new ABBADiv1();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String initial = "A";
        String target = "BABA";

        String expected = "Possible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String initial = "BAAAAABAA";
        String target = "BAABAAAAAB";

        String expected = "Possible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String initial = "A";
        String target = "ABBA";

        String expected = "Impossible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase3() {
        String initial = "AAABBAABB";
        String target = "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB";

        String expected = "Possible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase4() {
        String initial = "AAABAAABB";
        String target = "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB";

        String expected = "Impossible";
        String actual = solution.canObtain(initial, target);

        Assert.assertEquals(expected, actual);
    }

}
