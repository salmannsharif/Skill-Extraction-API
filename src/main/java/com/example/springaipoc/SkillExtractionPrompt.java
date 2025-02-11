package com.example.springaipoc;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SkillExtractionPrompt {

    private static final String PROMPT_TEMPLATE =
            "Extract all the technical skills and job-related keywords from this resume:\n\n {resume_text} \n\nReturn them as a comma-separated list.";

    public Prompt createPrompt(String resumeText) {
        PromptTemplate template = new PromptTemplate(PROMPT_TEMPLATE);
        return template.create(Map.of("resume_text", resumeText));
    }
}
