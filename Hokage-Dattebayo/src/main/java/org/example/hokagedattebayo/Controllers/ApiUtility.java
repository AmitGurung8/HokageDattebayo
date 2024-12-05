package org.example.hokagedattebayo.Controllers;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.hokagedattebayo.Models.Characters;

public class ApiUtility {
    private static final String BASE_URL = "https://dattebayo-api.onrender.com/Characters";
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final Gson GSON = new Gson();

    /**
     * Fetches a list of Naruto characters from the API.
     *
     * @param searchQuery the name of the character to search for (optional).
     * @return a list of Character objects or null if the request fails.
     */
    public static Characters fetchCharacters(String searchQuery) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        String url = BASE_URL + searchQuery;
        System.out.println(url);
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseData = response.body().string();
                return gson.fromJson(responseData, Characters.class);
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
