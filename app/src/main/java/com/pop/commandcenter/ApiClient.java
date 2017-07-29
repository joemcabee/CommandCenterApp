package com.pop.commandcenter;

import android.util.Log;

import com.pop.commandcenter.models.ServiceRequest;
import com.pop.commandcenter.models.ServiceResponse;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by joemc on 7/22/2017.
 */

public class ApiClient {

    public ServiceResponse httpGet(ServiceRequest request) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(true);
        int timeoutInSeconds = 10;

        try {
            URL myURL = new URL(request.toString());
            HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
            String basicAuth = Authorization.getBasicAuthValue();

            myURLConnection.setRequestProperty ("Authorization", basicAuth);
            myURLConnection.setRequestMethod("GET");
            myURLConnection.setUseCaches(false);
            myURLConnection.setConnectTimeout(timeoutInSeconds * 1000);
            myURLConnection.setReadTimeout(timeoutInSeconds * 1000);
            myURLConnection.setDoInput(true);
            myURLConnection.setDoOutput(true);

            try {

                FileInputStream fileInputStream = null;
                DataOutputStream outputStream = null;

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }

                bufferedReader.close();

                response.setStatusCode(myURLConnection.getResponseCode());

                if (fileInputStream != null) {
                    fileInputStream.close();
                }

                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
            finally {
                myURLConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            response.setException(e);
            response.setSuccess(false);
        }

        return response;
    }

    public ServiceResponse httpPost(ServiceRequest request) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(true);
        int timeoutInSeconds = 10;

        try {
            URL myURL = new URL(request.toString());
            HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
            String basicAuth = Authorization.getBasicAuthValue();

            myURLConnection.setRequestProperty ("Authorization", basicAuth);
            myURLConnection.setRequestMethod("POST");
            myURLConnection.setUseCaches(false);
            myURLConnection.setConnectTimeout(timeoutInSeconds * 1000);
            myURLConnection.setReadTimeout(timeoutInSeconds * 1000);
            myURLConnection.setDoInput(true);
            myURLConnection.setDoOutput(true);

            try {

                FileInputStream fileInputStream = null;
                DataOutputStream outputStream = null;

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }

                bufferedReader.close();

                response.setStatusCode(myURLConnection.getResponseCode());

                if (fileInputStream != null) {
                    fileInputStream.close();
                }

                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            }
            finally {
                myURLConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            response.setException(e);
            response.setSuccess(false);
        }

        return response;
    }
}
