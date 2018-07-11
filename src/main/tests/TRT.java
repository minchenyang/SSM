import com.min.bean.BraveKnight;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.InputStream;
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
        System.out.println(Float.parseFloat("7"));
    }



    @Test
    public void commonss()throws Exception{

        String path1 = this.getClass().getClassLoader().getResource("").getPath(); //到根目录/target/classes/ 的路径
        String path2 = this.getClass().getResource("").getPath();//xxx/.../target/classes/edu/bit/files/ 到当前文件的路径
        String path3 = this.getClass().getResource("/").getPath();//xxx/.../target/classes/edu/bit/files/ 到当前文件的路径
        String path4 = this.getClass().getResource("/log4j2.xml").getPath();//target/classes 路径就是 resources 路径
        File file = new File(path3);
        System.out.println(path1);
        System.out.println(path2);
        System.out.println(path3);
        System.out.println(file.exists());
    }

}
