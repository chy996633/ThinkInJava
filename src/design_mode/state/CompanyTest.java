//package design_mode.state;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.contrib.java.lang.system.SystemOutRule;
//
//public class CompanyTest {
//
//    @Rule
//    public final SystemOutRule log = new SystemOutRule().enableLog();
//
//    @Test
//    public void main() throws Exception {
//        WorkEfficiency workEfficiency = new WorkEfficiency();
//        workEfficiency.handle();
//        assertThat(log.getLog(), is("现在是8点,工作状态是:棒棒哒\n"));
//        log.clearLog();
//        workEfficiency.setTime(11);
//        workEfficiency.handle();
//        assertThat(log.getLog(), is("现在是11点,工作状态是:打瞌睡\n"));
//        log.clearLog();
//        workEfficiency.setTime(14);
//        workEfficiency.handle();
//        assertThat(log.getLog(), is("现在是14点,工作状态是:创意丰富\n"));
//        log.clearLog();
//        workEfficiency.setTime(16);
//        workEfficiency.setTaskFinished(false);
//        workEfficiency.handle();
//        assertThat(log.getLog(), is("现在是16点,工作状态是:疲劳加班中\n"));
//        log.clearLog();
//        workEfficiency.setTime(21);
//        workEfficiency.handle();
//        assertThat(log.getLog(), is("现在是21点,工作状态是:下班途中,公司规定20点之前必须下班\n"));
//    }
//
//}