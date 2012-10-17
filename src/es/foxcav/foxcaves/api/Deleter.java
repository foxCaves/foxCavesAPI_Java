package es.foxcav.foxcaves.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Deleter extends Authenticatable {
	public Deleter() {
		super();
	}

	public Deleter(String username, String password) {
		super(username, password);
	}

	public boolean deleteFile(String fileid) throws IOException {
		HttpURLConnection httpURLConnection = makeHttpURLConnection("delete?" + fileid);
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		String response = reader.readLine();
		reader.close();
		return (response.charAt(0) == '+');
	}
}
