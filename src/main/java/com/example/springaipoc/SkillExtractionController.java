package com.example.springaipoc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/skills")
public class SkillExtractionController {

    private final SkillExtractionService skillExtractionService;

    public SkillExtractionController(SkillExtractionService skillExtractionService) {
        this.skillExtractionService = skillExtractionService;
    }

    @PostMapping("/extract")
    public Map<String, List<String>> extractSkills(@RequestBody Map<String, String> request) throws IOException {
        String filePath = request.get("filePath");

        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("filePath must not be null or empty");
        }

        String resumeText = FileTextExtractor.extractTextFromFile(filePath);
        Set<String> skillsSet = skillExtractionService.extractSkills(resumeText);

        // Convert Set<String> to List<String> to prevent the ClassCastException
        List<String> skillsList = skillsSet.stream().toList();
        return Map.of("skills", skillsList);
    }
}
