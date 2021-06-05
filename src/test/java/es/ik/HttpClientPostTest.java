//package es.ik;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.var;
//import org.apache.http.HttpRequest;
//import org.apache.http.client.HttpClient;
//
//import java.io.IOException;
//import java.net.URI;
////import java.net.http.HttpClient;
////import java.net.http.HttpRequest;
////import java.net.http.HttpResponse;
//import java.util.HashMap;
//
///**
// * @author Jasper Liuzengyu 刘增玉
// * @version v1.0.0
// * @description
// * @date 2021/5/31
// * @since v1.0
// */
//public class HttpClientPostTest {
//    public static void main(String[] args) throws IOException, InterruptedException, InstantiationException, IllegalAccessException {
//
//        var values = new HashMap<String, String>() {{
//            put("name", "John Doe");
//            put("occupation", "gardener");
//        }};
//
//        var objectMapper = new ObjectMapper();
//        String requestBody = objectMapper
//                .writeValueAsString(values);
//
////        HttpClient client = HttpClient.newHttpClient();
//        HttpClient client = HttpClient.class.newInstance();
//
//        HttpRequest request = HttpRequest.class.newInstance().newBuilder()
//                .uri(URI.create("https://httpbin.org/post"))
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());
//    }
//}
