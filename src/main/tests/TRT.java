import com.min.bean.BraveKnight;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: SSM
 * @description:
 * @author: mcy
 * @create: 2018-06-24 12:58
 **/
public class TRT {

    @Test
    public void aop(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BraveKnight br = (BraveKnight) ac.getBean("knight");
        br.saying();
    }

    @Test
    public void test()throws Exception{
        Date date = new Date();
        date.setTime(1530082885965L);
        System.out.println(date.getTime());
        final Date date1 = DateUtils.setHours(date, 23);

        System.out.println(date1.getTime());
    }

    @Test
    public void log(){
        Logger logger  = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

        logger.trace("trance level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");

    }

    @Test
    public void commons()throws Exception{

        Double dou = 3000.5353;
        System.out.println(
                dou = (double)Math.round(dou*100)/100);
    }



    @Test
    public void commonss()throws Exception{

       File file = new File("E:/abc.txt");
        System.out.println(file.exists());
        Thread.sleep(10000);
        System.out.println(file.exists());
    }

}
