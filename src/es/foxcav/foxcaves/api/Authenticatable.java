package es.foxcav.foxcaves.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class Authenticatable {
	public Authenticatable() {

	}

	public Authenticatable(String username, String password) {
		this();
		setCredentials(username, password);
	}

	protected String username = null;
	protected String password = null;

	public void setCredentials(String username, String password) {
		if (username == null)
		{
			throw new NullPointerException("username");
		}
		if (password == null)
		{
			throw new NullPointerException("password");
		}
		this.username = username;
		this.password = password;
	}

	protected HttpURLConnection makeHttpURLConnection(String suburl) throws IOException {
		HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(Constants.APIURL + suburl).openConnection();
		httpURLConnection.setRequestProperty("X-Foxcaves-User", username);
		httpURLConnection.setRequestProperty("X-Foxcaves-Password", password);
		httpURLConnection.setConnectTimeout(10000);
		httpURLConnection.setReadTimeout(20000);
		httpURLConnection.setUseCaches(false);
		return httpURLConnection;
	}
}
