package lt.vu.usecases;

import lt.vu.alternatives.NumberGenerator;
import lt.vu.interceptors.LoggedInvocation;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateBookCount implements Serializable {

    @Inject
    NumberGenerator generator;

    private CompletableFuture<Integer> generationStatus = null;

    @LoggedInvocation
    public String generate() {
        generationStatus = CompletableFuture.supplyAsync(() -> generator.generateNumber());
        return "index?faces-redirect=true";
    }

    public boolean isGenerating() {
        return generationStatus != null && !generationStatus.isDone();
    }

    public String getGenerationResult() throws ExecutionException, InterruptedException {
        if (generationStatus == null) {
            return null;
        } else if (isGenerating()) {
            return "Counting books...";
        }
        return "Total books in this library: " + generationStatus.get();
    }
}
