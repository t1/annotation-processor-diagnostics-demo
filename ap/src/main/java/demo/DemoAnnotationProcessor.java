package demo;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("demo.*")
public class DemoAnnotationProcessor extends AbstractProcessor {
    @Override public SourceVersion getSupportedSourceVersion() {return SourceVersion.latest();}

    @Override public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotations.stream()
                .flatMap(typeElement -> roundEnv.getElementsAnnotatedWith(typeElement).stream())
                .forEach(this::process);
        return false;
    }

    private void process(Element element) {
        var diagnosticKind = element.getAnnotation(Diagnostic.class).value();
        processingEnv.getMessager().printMessage(diagnosticKind, "found " + element.getSimpleName(), element);
    }
}
