package com.example.springaipoc;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SkillExtractionService {

    private final ChatClient chatClient;
    private final SkillExtractionPrompt skillExtractionPrompt;

    public SkillExtractionService(ChatClient chatClient, SkillExtractionPrompt skillExtractionPrompt) {
        this.chatClient = chatClient;
        this.skillExtractionPrompt = skillExtractionPrompt;
    }

    public Set<String> extractSkills(String resumeText) {
        Prompt prompt = skillExtractionPrompt.createPrompt(resumeText);
        String response = chatClient.prompt(prompt).call().content();

        // Convert comma-separated response into a set to remove duplicates
        return Arrays.stream(response.split(","))
                .map(String::trim).collect(Collectors.toSet());
    }
}
