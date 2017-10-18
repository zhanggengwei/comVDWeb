import com.Utils.SmsCodeUtils;
import org.apache.log4j.*;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        // 记录debug级别的信息  
        logger.debug("This is debug message.");
        // 记录info级别的信息  
        logger.info("This is info message.");
        // 记录error级别的信息  
        logger.error("This is error message.");

        new SmsCodeUtils().sendCode("18863014571",1);

    }
}