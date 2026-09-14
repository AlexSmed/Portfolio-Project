package service;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;

import java.nio.file.Files;
import java.nio.file.Path;

public class AllergyChecker {

    private final Client client;

    public AllergyChecker() {
        this.client = new Client();
    }

    public String checkImage(String imagePath) throws Exception {

        Content systemInstruction = Content.fromParts(
                Part.fromText(
                        "You are an expert allergy safety assistant. " +
                                "Analyze the provided image or text of food ingredients. " +
                                "Check specifically for these allergens: PEANUTS, GLUTEN, DAIRY, SHELLFISH. " +
                                "Return your answer strictly as JSON with these fields: " +
                                "\"containsAllergen\" (boolean), " +
                                "\"foundAllergens\" (array of strings), " +
                                "\"reason\" (short explanation)."
                )
        );

        GenerateContentConfig config =
                GenerateContentConfig.builder()
                        .systemInstruction(systemInstruction)
                        .responseMimeType("application/json")
                        .build();

        Path path = Path.of(imagePath);
        byte[] imageBytes = Files.readAllBytes(path);

        Content content = Content.fromParts(
                Part.fromBytes(imageBytes, "image/jpeg"),
                Part.fromText(
                        "Does this product contain any of my allergens?"
                )
        );

        GenerateContentResponse response =
                client.models.generateContent(
                        "models/gemini-3.6-flash",
                        content,
                        config
                );

        return response.text();
    }

    public void close() {
        client.close();
    }
}

