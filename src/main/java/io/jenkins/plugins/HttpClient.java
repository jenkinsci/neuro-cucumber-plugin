package io.jenkins.plugins;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static java.lang.String.format;

public class HttpClient {
    private String baseUrl;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public HttpClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String post(String endpoint, Object body) throws UnsupportedEncodingException, JsonProcessingException {
        String url = format("%s%s", baseUrl, endpoint);
        return doPost(url, body);
    }

    private String doPost(String url, Object body) throws UnsupportedEncodingException, JsonProcessingException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        addHeaders(httpPost);
        String json = objectMapper.writeValueAsString(body);
        httpPost.setEntity(new StringEntity(json));
        return execute(httpclient, httpPost);
    }

    private void addHeaders(HttpRequestBase request) {
        request.addHeader("Content-Type", "application/json");
    }

    private String responseHandler(HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        } else {
            throw new ClientProtocolException("Unexpected response status: " + status);
        }
    }

    private String execute(CloseableHttpClient httpclient, HttpUriRequest request) {
        try {
            return httpclient.execute(request, this::responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
