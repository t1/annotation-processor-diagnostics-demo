package demo;

import static javax.tools.Diagnostic.Kind.ERROR;
import static javax.tools.Diagnostic.Kind.MANDATORY_WARNING;
import static javax.tools.Diagnostic.Kind.NOTE;
import static javax.tools.Diagnostic.Kind.OTHER;
import static javax.tools.Diagnostic.Kind.WARNING;

@SuppressWarnings("unused")
public class Demo {
    String innocentField;

    @Diagnostic(OTHER)
    String otherField;

    @Diagnostic(NOTE)
    String noteField;

    @Diagnostic(WARNING)
    String warningField;

    @Diagnostic(MANDATORY_WARNING)
    String mandatoryWarningField;

    /** compiling this field is supposed to fail */
    @Diagnostic(ERROR)
    String errorField;
}
