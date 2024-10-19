package demo;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Diagnostic {
    javax.tools.Diagnostic.Kind value();
}
