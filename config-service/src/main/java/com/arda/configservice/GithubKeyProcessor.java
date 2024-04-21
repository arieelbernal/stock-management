package com.arda.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GithubKeyProcessor implements EnvironmentPostProcessor {

    private static final String START_PK = "-----BEGIN OPENSSH PRIVATE KEY-----";
    private static final String END_PK = "-----END OPENSSH PRIVATE KEY-----";
    private static final String LINE_BREAK = "\n";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment,
                                       SpringApplication application) {

        String githubKey = environment.getProperty("SSH_PRIVATE_KEY");

        Map<String, Object> formattedGithubKeyProperties = new HashMap<>();
        formattedGithubKeyProperties.put("formattedGithubKey", formatKey(githubKey));
        environment.getPropertySources()
                .addLast(new MapPropertySource("formattedGithubKeyProperties", formattedGithubKeyProperties));

        System.out.println("Done transforming githubKey to the correct format");
    }

    private String formatKey(String theSshKey) {
        if (theSshKey.indexOf(LINE_BREAK) < 0) {
            String tmpKey = theSshKey.replace(START_PK, "").replace(END_PK, "").trim();
            return START_PK + LINE_BREAK + tmpKey.replaceAll(" ", LINE_BREAK) + LINE_BREAK + END_PK;
        } else {
            return theSshKey;
        }
    }
}
