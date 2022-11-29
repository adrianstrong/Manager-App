module csur.app.manager {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires lombok;
    requires com.calendarfx.view;


    opens csur.app.manager to javafx.fxml , org.hibernate.orm.core, java.sql;
    opens models;
    exports csur.app.manager;
    exports controller;
    opens controller to java.sql, javafx.fxml, org.hibernate.orm.core;
}