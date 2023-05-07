package tobyspring.config;


import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.StreamSupport;

public class AutoConfigImportSelector implements DeferredImportSelector{

    private final ClassLoader classLoader;

    public AutoConfigImportSelector(ClassLoader classLoader){
        this.classLoader=classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Iterable<String> candidates =ImportCandidates.load(RwkAutoConfiguration.class, classLoader);
        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
    }
}
