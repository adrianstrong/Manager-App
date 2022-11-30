package csur.app.manager;

import java.time.LocalDateTime;
import org.apache.commons.codec.digest.DigestUtils;
import csur.app.manager.HibernateUtil;
import org.hibernate.Session;

public class Utils {
    public static String getToday() {
        return  String.valueOf(LocalDateTime.now().getDayOfMonth()) + "/" +
                String.valueOf(LocalDateTime.now().getMonthValue()) + "/" +
                String.valueOf(LocalDateTime.now().getYear());
    }

    public boolean checkUserPassword(String user, String password) {
        Session s = HibernateUtil.getSessionFactory().openSession();

        return true;
    }
    public String strMD5(String str)  {
        return DigestUtils.md5Hex(str);
    }


}
