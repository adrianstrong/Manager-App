package csur.app.manager;

import java.time.LocalDateTime;

import controllers.SessionData;
import models.Alumno;
import models.Profesor;
import org.apache.commons.codec.digest.DigestUtils;
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
            var existeAlumno = s.createQuery("FROM Alumno a WHERE a.email = :user AND a.passwordAlumno = :password")
                    .setParameter("user", user)
                    .setParameter("password", DigestUtils.md5Hex(password)).getResultList();

            var existeProfesor = s.createQuery("FROM Profesor a WHERE a.email = :user AND a.passwordProfesor = :password")
                    .setParameter("user", user)
                    .setParameter("password", DigestUtils.md5Hex(password)).getResultList();

            if (existeAlumno.size() >= 1) {
                SessionData.setContextoAdmin(false);
                SessionData.setAlumno((Alumno) existeAlumno.get(0));
                return true;
            } else if (existeProfesor.size() >= 1) {
                SessionData.setContextoAdmin(true);
                SessionData.setProfesor((Profesor) existeProfesor.get(0));
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }
    public static String strMD5(String str) {
        return DigestUtils.md5Hex(str);
    }

}
