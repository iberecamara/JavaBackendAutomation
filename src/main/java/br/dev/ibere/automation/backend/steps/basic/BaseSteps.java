package br.dev.ibere.automation.backend.steps.basic;

import br.dev.ibere.automation.backend.context.ContextProvider;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseSteps {

    @Autowired
    protected ContextProvider contextProvider;

    protected void putInContext(String key, Object value) {
        contextProvider.get().put(key, value);
    }

    protected void updateInContext(String key, Object value) {
        contextProvider.get().update(key, value);
    }

    protected <T> T getFromContext(String key) {
        return contextProvider.get().get(key);
    }

    protected void removeFromContext(String key) {
        contextProvider.get().remove(key);
    }

    protected void clearContext() {
        contextProvider.get().clear();
    }

}