package csur.app.manager;

import java.time.LocalDateTime;

import org.apache.commons.codec.digest.DigestUtils;
import csur.app.manager.HibernateUtil;
import org.hibernate.Session;

public class Utils {

    protected static Session s;

    public static String getToday() {
        return String.valueOf(LocalDateTime.now().getDayOfMonth()) + "/" +
                String.valueOf(LocalDateTime.now().getMonthValue()) + "/" +
                String.valueOf(LocalDateTime.now().getYear());
    }

    public static boolean empty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean checkCredentials(String user, String password) {
        if (empty(user) || empty(password)) return false;
        s = HibernateUtil.getSessionFactory().openSession();

        try {
            return s.createQuery("FROM Usuarios u WHERE u.user = :user AND u.password = :password")
                    .setParameter("user", user)
                    .setParameter("password", DigestUtils.md5Hex(password)).getSingleResult() != null;
        } catch (Exception e) {
            return false;
        }

    }

    public String strMD5(String str) {
        return DigestUtils.md5Hex(str);
    }


}
