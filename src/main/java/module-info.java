module workshop {
    requires spring.web;
    requires jakarta.annotation;
    requires spring.core;
    opens spring.web to com.misc.controller;
    opens com.misc.entity to com.misc.controller;
    opens com.misc.service to com.misc.controller;
}
