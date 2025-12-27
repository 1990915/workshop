module workshop {
    requires spring.web;
    requires jakarta.annotation;
    requires spring.core;
    requires spring.context;
    requires org.jpos.jpos;
    requires jakarta.transaction;
    requires spring.beans;
opens spring.web to com.misc.controller;
    opens com.misc.entity to com.misc.controller;
    opens com.misc.service to com.misc.controller;
}
