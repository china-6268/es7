package es.ik;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/31
 * @since v1.0
 */
@Slf4j
public class JsonPostTest {
    @Test
    public void ikMaxWordTest() throws IOException {
        URL url = new URL("http://localhost:9200/_analyze");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"analyzer\": \"ik_max_word\", \"text\": \"2021年HanLPv2.1为生产环境带来次世代最先进的多语种NLP技术。" +
                "阿婆主来到北京立方庭参观自然语义科技公司。\"}";
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        ;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            log.info(response.toString());
        }
    }

    @Test
    public void ikSmartTest() throws IOException {
        URL url = new URL("http://localhost:9200/_analyze");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"analyzer\": \"ik_smart\", \"text\": \"2021年HanLPv2.1为生产环境带来次世代最先进的多语种NLP技术。" +
                "阿婆主来到北京立方庭参观自然语义科技公司。\"}";
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        ;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            log.info(response.toString());
        }
    }
}
